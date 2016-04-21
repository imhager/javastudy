package org.study.java.lessions.services.desginpattern.proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wangzh on 2016/4/21.
 * Description: 动态代理的调用处理类
 */
public class HouseSaleInvocationHandler implements InvocationHandler {

    // 被代理类的实例
    private Object obj = null;

    // 将被代理者的实例传进动态代理类的构造函数中
    public HouseSaleInvocationHandler(Object obj) {
        this.obj = obj;
    }

    /**
     * 生成代理类工厂
     *
     * @param realObj 真实对象
     * @return 返回生成的代理类
     * @author com.tiantian
     */
    public static Object getProxyInstanceFactory(Object realObj) {

        Class<?> classType = realObj.getClass();
        ClassLoader classLoader = classType.getClassLoader();
        Class<?>[] interfaces = classType.getInterfaces();
        InvocationHandler invocationHandler = new HouseSaleInvocationHandler(realObj);
        /*
         * classLoader : 被代理类的类加载器
         * interfaces ：被代理类已实现的所有接口，而这些是动态代理类要实现的接口列表
         * invocationHandler ：用被代理类的实例创建动态代理类的实例，用于真正调用处理程序
         *
         * return ：返回实现了被代理类所实现的所有接口的Object对象，即动态代理，需要强制转型
         */
        //获得代理的实例
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }


    /**
     * 覆盖InvocationHandler接口中的invoke()方法
     * <p>
     * 更重要的是，动态代理模式可以使得我们在不改变原来已有的代码结构
     * 的情况下，对原来的“真实方法”进行扩展、增强其功能，并且可以达到
     * 控制被代理对象的行为，下面的before、after就是我们可以进行特殊
     * 代码切入的扩展点了。
     * </p>
     *
     * @param proxy
     * @param method
     * @param args
     * @return return null
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("dynamic invoke before");
        Object result = null;

        // 除此之外，还可以扩展自有逻辑，比如判定、日志等
        result = method.invoke(obj, args);

        System.out.println("dynamic invoke after");

        return result;
    }
}
