package com.congcong.traffic;

/**
 * @ClassName TrafficObserver
 * @Description 信号灯观察者接口
 * @Author wangcong
 * @Date 2025/12/10 14:22
 * @Version 1.0
 */
public interface TrafficObserver {

    void update(TrafficEnum trafficEnum);
}
