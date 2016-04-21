package org.study.java.lessions.services.desginpattern.proxypattern;

/**
 * Created by wangzh on 2016/4/21.
 * Description:目标对象，会被代理对象所代理。比如示例中的中介经纪人
 */
public class HouseMasterService implements HouseSale {
    public void sale() {
        System.out.println("我是房主，我需要卖房子。");
    }
}
