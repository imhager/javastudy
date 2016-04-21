package org.study.java.lessions.services.desginpattern.proxypattern;

/**
 * Created by wangzh on 2016/4/21.
 * Description:
 */
public class BrokerProxyService implements HouseSale {

    //被代理的对象；
    private final HouseSale masterService;

    public BrokerProxyService() {
        masterService = new HouseMasterService();
    }

    public void sale() {

        System.out.println("我是中介经纪人，代理雇主出售房子.begin......");
        masterService.sale();

        System.out.println("我是中介经纪人，代理雇主出售房子.end......");
    }
}
