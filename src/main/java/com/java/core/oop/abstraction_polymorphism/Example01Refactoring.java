//package com.java.core.oop.abstraction_polymorphism;
//
//public class Example01Refactoring {
//
//    /**
//     * 추상화 진행하는 시점
//     * - 추상화는 의존 대상이 변경하는 시점에 진행
//     *  - 추상화 -> 추상 타입 증가 ->복잡도 증가
//     *      - 아직 존재하지도 않는 기능에 대한 이른 추상화는 주의
//     *          : 잘못된 추상화 가능성, 복잡도만 증가
//     *      - 실제 변경/확장이 발생할 때 추상화 시도
//     *
//     *
//     * 추상화를 잘 하려면,
//     * - 구현을 한 이유가 무엇 때문인지 잘 생각해야 한다.
//     * - SMSSender, KakaoPush, MailService  --> Notifier
//     *                                      --> Messenger
//     */
//
//
//    private SmsSender smsSender;
//    private KakaoPush kakaoPush;
//    private MailService mailService;
//
//    public void cancel() {
//        // ... 주문 취소 처리
//
//
//        // TODO: 추상화 진행
//        Notifier notifier = getNotifier(false);
//        notifier.notifier();
//
//        // ---------------------------------------------------
//
//        // TODO : 한 번 더 추상화 (사용할 대상 접근도 추상화)
//        Notifier notifier = NotifierFactory.instance().getNotifier();
//        notifier.notify();;
//
//
//    }
//
//    private interface Notifier {
//        void notifier();
//    }
//
//    private interface NotifierFactory {
//        Notifier getNotifier();
//
//        static NotifierFactory instance() {
//            return new DefaultNotifierFactory();
//        }
//    }
//
//    private class DefaultNotifierFactory implements NotifierFactory {
//        @Override
//        public NotifierFactory instance() {
//            if (true) return new KakaoPush();
//            else return new SmsSender();
//        }
//    }
//
//    private Notifier getNotifier(boolean pushEnabled) {
//        if (pushEnabled) {
//            return new KakaoPush();
//        } else {
//            return new SmsSender();
//        }
//    }
//
//
//    private class SmsSender implements Notifier {
//        @Override
//        public void notifier() {}
//    }
//
//    private class KakaoPush implements Notifier {
//        @Override
//        public void notifier() {}
//    }
//
//    private class MailService implements Notifier {
//        @Override
//        public void notifier() {}
//    }
//}
