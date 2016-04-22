package org.study.java.lessions.services.desginpattern.proxypattern;

/**
 * Created by wangzh on 2016/4/21.
 * Description:代理对象，实现“抽象对象角色”接口
 * 代理对象内部含有目标对象的引用，从而可以在任何时候操作目标对象；代理对象提供一个与目标对象相同的接口，以便可以在任何时候替代目标对象。代理对象通常在客户端调用传递给目标对象之前或之后，执行某个操作，而不是单纯地将调用传递给目标对象。
 */
public class BrokerProxyClient {
    public static void main(String[] args) {

        /**
         * 代理类，包含了目标对象的引用。
         */
        HouseSale service = new BrokerProxyService();

        // TODO 依然可以new到一个真实目标对象的实例，如何控制权限呢？
        HouseSale houseSale = new HouseMasterService();
        //houseSale.sale();

        service.sale();

        System.out.println("============");
        System.out.println("动态代理测试结果");

        // 房主--即真实对象实例
        HouseSale masterService = new HouseMasterService();


        // 因返回的是Object，需要类型转换
        HouseSale dynamicProxy = (HouseSale) HouseSaleInvocationHandler.getProxyInstanceFactory(masterService);

        // 方式二，利用instanceof检测
        Object obj = HouseSaleInvocationHandler.getProxyInstanceFactory(masterService);
        if (obj instanceof HouseSale) {
            System.out.println("=====dynamicProxy2 instanceof begin=======");
            HouseSale dynamicProxy2 = (HouseSale) obj;
            dynamicProxy2.sale();
            System.out.println("=====dynamicProxy2 instanceof end=======");
        }

        dynamicProxy.sale();

        System.out.println(dynamicProxy.getClass().getName());
    }
}
