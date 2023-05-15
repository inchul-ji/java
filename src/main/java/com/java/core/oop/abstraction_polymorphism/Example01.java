package com.java.core.oop.abstraction_polymorphism;

public class Example01 {

    private SmsSender smsSender;
    private KakaoPush kakaoPush;
    private MailService mailService;

    public void cancel() {
        // ... 주문 취소 처리

        boolean pushEnabled = false;

        // TODO: 추상화가 안 이뤄짐
        if (pushEnabled) {
            kakaoPush.push();
        } else {
            smsSender.sendSms();
        }

    }


    private class SmsSender {
        public void sendSms() {
        }
    }

    private class KakaoPush {
        public void push() {
        }
    }

    private class MailService {
        public void sendMail() {

        }
    }
}
