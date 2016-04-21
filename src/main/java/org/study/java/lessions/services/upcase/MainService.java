package org.study.java.lessions.services.upcase;

/**
 * Created by wangzh on 2016/4/19.
 * Description:
 */
public class MainService {
    public static void main(String[] args) {

        //直接实例化，无转型
        MenService men = new MenService();
        men.play();
        System.out.println("============");

        //直接实例化，无转型
        WomenService women = new WomenService();
        women.play();
        System.out.println("============");

        //将MenService向上转型为BaseHumanService
        //向上转型，子类新增方法会丢失；但是基类方法仍会保留；
        HumanService human = new MenService();
        human.play();//human 此时，应该是MenService，因为通过后期绑定（多态）将对象转成了MenService，但是也是一个阉割版本的MenService；
        System.out.println("============");

        //upcase后，子类新增方法会丢失；所以没有happy方法可用
//        HumanService human2 = new MenService();
//        human2.happy();

        HumanService human3 = new MenService();
        human3.run();
    }
}
