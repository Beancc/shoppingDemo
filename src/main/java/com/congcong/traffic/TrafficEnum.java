package com.congcong.traffic;


/**
 * @ClassName TrafficEnum
 * @Description  信号灯枚举
 * @Author wangcong
 * @Date 2025/12/10 14:07
 * @Version 1.0
 */
public enum TrafficEnum {
    RED("红灯亮了！", 3),
    GREEN("绿灯亮了！", 2),
    YELLOW("黄灯亮了！", 1),
    ;


    private final String light;

    private final Integer duration;

    TrafficEnum(String light, Integer duration) {
        this.light = light;
        this.duration = duration;
    }

    public String getLight() {
        return light;
    }

    public Integer getDuration() {
        return duration;
    }

    //获取下一个灯的枚举
    public TrafficEnum getNext() {
        TrafficEnum[] values = TrafficEnum.values();
        //当前索引
        int currentIndex = this.ordinal();
        //下一个索引
        int nextIndex = (currentIndex + 1) % values.length;
        //得到下一个枚举
        return values[nextIndex];
    }


}
