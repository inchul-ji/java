package com.java.core.oop.encapsulation;

public class Example04 {
    public void verifyEmail(String token) throws AlreadyVerifiedException, BadTokenException {
        Member member = findByToken(token);
        if (member == null)
            throw new BadTokenException();

        // TODO: 캡슐화 필요
        if (member.getVerificationEmailStatus() == 2) {
            throw new AlreadyVerifiedException();
        } else {
            // TODO: 캡슐화 필요
            member.setVerificationEmailStatus(2);
        }

        // ... 수정사항 DB 반영영
    }

    private Member findByToken(String token) {
        return null;
    }

    private class Member {
        public int getVerificationEmailStatus() {
            return 0;
        }

        public void setVerificationEmailStatus(int i) {

        }
    }

    private class BadTokenException extends Throwable {
    }

    private class AlreadyVerifiedException extends Throwable {
    }
}
