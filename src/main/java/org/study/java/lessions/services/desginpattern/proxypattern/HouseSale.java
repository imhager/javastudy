package org.study.java.lessions.services.desginpattern.proxypattern;

/**
 * Created by wangzh on 2016/4/21.
 * Description:定义代理模式共用的“抽象对象角色”
 * 声明了目标对象和代理对象的共同接口，这样一来在任何可以使用目标对象的地方都可以使用代理对象。
 */
public interface HouseSale {

    /**
     * 卖房
     */
    void sale();
}
