package com.congcong.traffic;

/**
 * @ClassName Car
 * @Description
 * @Author wangcong
 * @Date 2025/12/10 16:06
 * @Version 1.0
 */
public class Car implements  TrafficObserver {

    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void update(TrafficEnum trafficEnum) {
        if(trafficEnum == TrafficEnum.RED) {
            System.out.println(name + "红灯停！");
        }else if (trafficEnum == TrafficEnum.GREEN) {
            System.out.println(name + "绿灯行。");
        }else  if (trafficEnum == TrafficEnum.YELLOW) {
            System.out.println(name + "黄灯亮了。");
        }
    }
}
