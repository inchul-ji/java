package com.java.core.oop.encapsulation;

public class example01 {

    /**
     * 아래 코드는 캡슐화가 안된 코드 이다.
     *
     * 데이터를 가져와서 판단하려는 방식을
     *
     * 캡슐화된 객체에 판단해달라고 해야한다.
     */
    public AuthResult authenticate(String id, String pw) {
        Member member = findOne(id);
        if (member == null) {
            return AuthResult.NO_MATCH;
        }

        // TODO: 캡슐화가 필요함.
        if (member.getVerificationEmailStatus() != 2) {
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

        public int getVerificationEmailStatus() {
            return 0;
        }

        public String getId() {
            return id;
        }

        public String getPassword() {
            return password;
        }
    }

    static class PasswordEncoder {
        public static boolean isPasswordValid(String password, String pw, String id) {
            return false;
        }
    }

}
