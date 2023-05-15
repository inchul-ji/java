package com.java.core.oop.encapsulation;

public class Example02Refactoring {
    private Movie movie;
    private int daysRented;

    // 포인트 계산하는 로직
    public int getFrequentRenterPoints() {
        // TODO: 캡슐화 살짝 진행함.
//        if (movie.isNewRelease() && daysRented > 1) {
//            return 2;
//        } else {
//            return 1;
//        }

        // TODO: 캡슐화 완전 진행함.
        return movie.getFrequentRenterPoints(daysRented);

    }

    static class Movie {
        public static int REGULAR = 0;
        public static int NEW_RELEASE = 1;
        private int priceCode;

        public int getPriceCode() {
            return priceCode;
        }

        public boolean isNewRelease() {
            if (this.priceCode == this.NEW_RELEASE) {
                return true;
            }
            return false;
        }

        public int getFrequentRenterPoints(int daysRented) {
            if (this.priceCode == this.NEW_RELEASE && daysRented > 1) {
                return 2;
            } else {
                return 1;
            }
        }
    }


}
