package com.congcong.traffic;

/**
 * @ClassName Person
 * @Description
 * @Author wangcong
 * @Date 2025/12/10 14:48
 * @Version 1.0
 */
public class Pedestrian implements TrafficObserver {

    private String name;

    public Pedestrian(String name) {
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
