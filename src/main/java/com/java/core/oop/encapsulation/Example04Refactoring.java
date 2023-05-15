package com.java.core.oop.encapsulation;

public class Example04Refactoring {
    public void verifyEmail(String token) throws AlreadyVerifiedException, BadTokenException {
        Member member = findByToken(token);
        if (member == null)
            throw new BadTokenException();

        // TODO: 캡슐화 진행
        member.verifyEmail();


        // ... 수정사항 DB 반영영
    }

    private Member findByToken(String token) {
        return null;
    }

    private class Member {
        private int verificationEmailStatus;

        public int getVerificationEmailStatus() {
            return verificationEmailStatus;
        }

        public void setVerificationEmailStatus(int i) {

        }

        public void verifyEmail() throws AlreadyVerifiedException {
            if (isEmailVerify()) {
                throw new AlreadyVerifiedException();
            } else {
                this.verificationEmailStatus = 2;
            }
        }

        private boolean isEmailVerify() {
            return this.verificationEmailStatus == 2;
        }
    }


    private class BadTokenException extends Throwable {
    }

    private class AlreadyVerifiedException extends Throwable {
    }
}
