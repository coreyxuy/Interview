package service;

import java.util.ServiceLoader;

/**
 * @Auther: corey
 * @Date: 2020/7/3 10:17
 * @Description:
 */
public class RobotCarTest {

    public static void main(String[] args) {
        ServiceLoader<RobotCar> serviceLoader = ServiceLoader.load(RobotCar.class);
        System.out.println("Java SPI....");
        serviceLoader.forEach(RobotCar::hello);

//        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
//        Iterator<Robot> it = serviceLoader.iterator();
//        while (it != null && it.hasNext()){
//            Robot demoService = it.next();
//            System.out.println("class:" + demoService.getClass().getName());
//            demoService.hello();
//        }
    }
}
