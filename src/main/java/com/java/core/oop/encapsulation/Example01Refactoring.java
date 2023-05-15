package com.java.core.oop.encapsulation;

public class Example01Refactoring {

    /**
     * 아래 코드는 처럼 캡슐화 하는 것이 객체지향 프로그래밍의 기초
     */
    public AuthResult authenticate(String id, String pw) {
        Member member = findOne(id);
        if (member == null) {
            return AuthResult.NO_MATCH;
        }

        // TODO: 캡슐화 진행함
        if (!member.isEmailVerified()) {
            return AuthResult.NO_EMAIL_VERIFIED;
        }

        if (PasswordEncoder.isPasswordValid(member.getPassword(), pw, member.getId())) {
            return AuthResult.SUCCESS;
        }

        return AuthResult.NO_MATCH;
    }




    private Member findOne(String id) {
        return new Member();
    }

    static class AuthResult {
        public static final AuthResult NO_EMAIL_VERIFIED = null;
        public static final AuthResult SUCCESS = null;
        public static AuthResult NO_MATCH;
    }

    static class Member {
        private String id;
        private String password;

//        public int getVerificationEmailStatus() {
//            return 0;
//        }

        public String getId() {
            return id;
        }

        public String getPassword() {
            return password;
        }

        public boolean isEmailVerified() {
            return false;
        }


    }

    static class PasswordEncoder {
        public static boolean isPasswordValid(String password, String pw, String id) {
            return false;
        }
    }
}
