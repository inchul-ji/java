package com.java.core.oop.encapsulation;

public class Example02 {
    private Movie movie;
    private int daysRented;

    // 포인트 계산하는 로직
    public int getFrequentRenterPoints() {
        // TODO: 캡슐화 필요
        if (movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }

    }

    static class Movie {
        public static int REGULAR = 0;
        public static int NEW_RELEASE = 1;
        private int priceCode;

        public int getPriceCode() {
            return priceCode;
        }
    }


}
