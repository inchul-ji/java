package com.java.core.oop.encapsulation;

public class Example03 {

    // TODO: 캡술화 필요
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.startTime = System.currentTimeMillis();

        // ,,, 로직 ....

        timer.stopTime = System.currentTimeMillis();

        long elapsedTime = timer.stopTime - timer.startTime;
    }

    static class Timer {
        public Long startTime;
        public Long stopTime;
    }


}
