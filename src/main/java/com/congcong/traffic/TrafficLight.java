package com.congcong.traffic;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName TrafficLight
 * @Description
 * @Author wangcong
 * @Date 2025/12/10 14:36
 * @Version 1.0
 */
public class TrafficLight implements Runnable{
    //当前灯的状态
    private TrafficEnum trafficEnum;

    //观察者列表（保证线程安全）
    private List<TrafficObserver> observers = new CopyOnWriteArrayList<>();

    //控制红绿灯是否运行
    private volatile boolean running = true;

    //红绿灯的名字
    private String name;

    public TrafficLight(String name) {
        this.name = name;
        this.trafficEnum = TrafficEnum.RED;
    }

    public void addObserve(TrafficObserver observer) {
        observers.add(observer);
    }

    public void removeObserve(TrafficObserver observer) {
        observers.remove(observer);
    }

    //通知观察者，私有方法是因为只有红绿灯自己能决定变灯。
    private void notifyObservers() {
        for (TrafficObserver observer : observers) {
            observer.update(trafficEnum);
        }
    }

    @Override
    public void run() {
        while (running) {
            System.out.println("[" + name +"]" + trafficEnum.getLight() + "亮了" + trafficEnum.getDuration() + "秒");
            //通知所有观察者
            notifyObservers();
            try {
                Thread.sleep(trafficEnum.getDuration() * 1000);
                trafficEnum = trafficEnum.getNext();
            } catch (InterruptedException e) {}
        }
    }

    public void stop() {
        running = false;
    }


    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight("十字路口灯");

        // 添加观察者
        trafficLight.addObserve(new Pedestrian("行人甲"));
        trafficLight.addObserve(new Car("轿车乙"));
        // 启动线程
        new Thread(trafficLight).start();
    }
}
