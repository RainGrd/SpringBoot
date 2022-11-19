package com.bdqn;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/11 11:24
 * FileName: TimeTaskApp
 * Description:
 */
public class TimeTaskApp {
    public static void main(String[] args) {
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer task run...");
            }
        };
        timer.schedule(task,0,2000);
    }
}
