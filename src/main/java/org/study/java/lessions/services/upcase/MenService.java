package org.study.java.lessions.services.upcase;

/**
 * Created by wangzh on 2016/4/19.
 * Description:
 */
public class MenService extends HumanService {

    public MenService() {
//        super();
        System.out.println("MenService.init.");
    }

    public void play() {
        System.out.println("MenService.play.");
    }

    /**
     * 子类扩展自有方法
     */
    public void happy() {
        System.out.println("MenService.happy.");
    }

}
