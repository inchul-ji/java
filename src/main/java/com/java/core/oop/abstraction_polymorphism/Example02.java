//package com.java.core.oop.abstraction_polymorphism;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 추상화 예시
// *
// * 기능 예시
// *  - 클라우드 파일 통합 관리 기능 개발
// *  - 대상 클라우드
// *      - 드롭박스, 박스
// *  - 주요 기능
// *      - 각 클라우드의 파일 목록 조회, 다운로드, 업로드, 삭제, 검색
// *
// *  추상화 하지 않은 코드 vs 추상화한 코드
// */
//public class Example02 {
//
//    public enum CloudId {
//        DROPBOX,
//        BOX,
//        NCLOUD
//        // TODO : 서비스 고도화로 지원 서비스를 SCloud, ACloud, GCloud 등 추가되면 어떻게될까???
//        // else if() 문이 계속 늘어날 것이다.
//    }
//
//    @Getter @Setter
//    static class FileInfo {
//        private CloudId cloudId;
//        private String fileId;
//        private String name;
//        private long length;
//
//    }
//
//    public class CloudFileManager {
//        // TODO: 추상화가 안됨
//        // TODO: 추상화하지 않은 구현 : 파일 목록 조회
//        public List<FileInfo> getFileInfos(CloudId cloudId) {
//            if (cloudId == CloudId.DROPBOX) {
//                DropboxClient dc = new DropboxClient();
//                List<DbFile> dbFiles = dc.getFiles();
//                List<FileInfo> result = new ArrayList<>();
//                for (DbFile dbFile : dbFiles) {
//                    FileInfo fi = new FileInfo();
//                    fi.setCloudId(CloudId.DROPBOX);
//                    fi.setFileId(fi.getFileId());
//
//                    // ...
//
//                    result.add(fi);
//                }
//                return result;
//            } else if (cloudId == CloudId.BOX) {
//                BoxService boxSvc = new BoxService();
//                // ... 기능 구현
//            }
//        }
//
//        // TODO: 추상화하지 않은 구현: 파일 다운로드
//        public void download(FileInfo file, File localTarget) {
//            if (file.getCloudId() == CloudId.DROPBOX) {
//                DropboxClient dc = new DropboxClient();
//                // ... 기능 구현
//
//            } else if (file.getCloudId() == CloudId.BOX) {
//                BoxService boxSvc = new BoxService();
//                // ... 기능 구현
//
//            }
//        }
//
//        // TODO: 추상화하지 않은 구현: 파일 업로드
//        public void upload(FileInfo file, File localTarget) {
//            if (file.getCloudId() == CloudId.DROPBOX) {
//                DropboxClient dc = new DropboxClient();
//                // ... 기능 구현
//
//            } else if (file.getCloudId() == CloudId.BOX) {
//                BoxService boxSvc = new BoxService();
//                // ... 기능 구현
//
//            }
//        }
//
//        // TODO: 추상화하지 않은 구현: 파일 삭제
//        public void delete(FileInfo file, File localTarget) {
//            if (file.getCloudId() == CloudId.DROPBOX) {
//                DropboxClient dc = new DropboxClient();
//                // ... 기능 구현
//
//            } else if (file.getCloudId() == CloudId.BOX) {
//                BoxService boxSvc = new BoxService();
//                // ... 기능 구현
//
//            }
//        }
//
//        // TODO: 추상화하지 않은 구현: 파일 조회
//        public void search(FileInfo file, File localTarget) {
//            if (file.getCloudId() == CloudId.DROPBOX) {
//                DropboxClient dc = new DropboxClient();
//                // ... 기능 구현
//
//            } else if (file.getCloudId() == CloudId.BOX) {
//                BoxService boxSvc = new BoxService();
//                // ... 기능 구현
//
//            }
//        }
//
//        // TODO: 추상화하지 않은 구현: 클라우드 간 복사
//        public void copy(FileInfo fileInfo, CloudId to) {
//            CloudId from = fileInfo.getCloudId();
//            if (to == CloudId.DROPBOX) {
//                if (from == CloudId.BOX) {}
//                else if (from == CloudId.NCLOUD) {}
//            } else if (to == CloudId.BOX) {
//                if (from == CloudId.DROPBOX) {}
//                else if (from == CloudId.NCLOUD) {}
//            } else if (to == CloudId.NCLOUD) {
//                if (from == CloudId.DROPBOX) {}
//                else if (from == CloudId.BOX) {}
//            }
//
//            // ... 기능 구현
//        }
//    }
//
//    private class DropboxClient {
//        public List<DbFile> getFiles() {
//
//        }
//    }
//
//    private class DbFile {
//    }
//
//    private class BoxService {
//    }
//}
