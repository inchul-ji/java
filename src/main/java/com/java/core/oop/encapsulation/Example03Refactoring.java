package com.java.core.oop.encapsulation;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class Example03Refactoring {

    // TODO: 캡술화 진행
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.start();

        // ,,, 로직 ....

        timer.stop();

        long elapsedTime = timer.elapsedTime(MILLISECONDS);
    }

    static class Timer {
        public Long startTime;
        public Long stopTime;

        public void start() {
            this.startTime = System.currentTimeMillis();
        }

        public void stop() {
            this.stopTime = System.currentTimeMillis();
        }

        public long elapsedTime(TimeUnit unit) {
            switch (unit) {
                case MILLISECONDS:
                    return stopTime - startTime;
                default:
                    return 0;
            // ...
            }
        }
    }


}
