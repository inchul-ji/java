//package com.java.core.oop.abstraction_polymorphism;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import java.io.File;
//import java.io.InputStream;
//import java.io.OutputStream;
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
// *
// *  이것이 바로 OCP (Open-Closed Principle)
// *  - 개방 폐쇄 원칙
// *  - 확장에는 열려있고, 변경에는 닫혀있어야한다.
// *  - 기능을 변경하고 확장할 수 있으면서, 기능을 사용하는 코드는 수정하지 않아야 한다.
// */
//public class Example02Refactoring {
//
//    public enum CloudId {
//        DROPBOX,
//        BOX,
//        NCLOUD
//        // TODO : 서비스 고도화로 지원 서비스를 SCloud, ACloud, GCloud 등 추가되면 어떻게될까???
//        // else if() 문이 계속 늘어날 것이다.
//    }
//
//    public static class CloudFileSystemFactory {
//        public static CloudFileSystem getFileSystem(CloudId cloudId){
//
//        }
//    }
//
//    public interface CloudFileSystem {
//        public List<CloudFile> getFiles();
//        public List<CloudFile> getFilesInfo(CloudId cloudId);
//        public  List<CloudFile> search();
//        public void getFile();
//        public void addFile();
//    }
//
//    public interface CloudFile {
//        void getId();
//        void getName();
//        void getLength();
//        boolean hasUrl();
//        String getUrl();
//        InputStream getInputStream();
//        void write(OutputStream out);
//        void delete();
//    }
//
//
//    public class DropBoxFileSystem implements CloudFileSystem {
//        private DropboxClient dbClient = new DropboxClient();
//
//        @Override
//        public List<CloudFile> getFiles() {
//            List<DbFile> dbFiles = dbClient.getFiles();
//            List<CloudFile> result = new ArrayList<>();
//            for (DbFile file : dbFiles) {
//                DropBoxCloudFile cf = new DropBoxCloudFile(file, dbClient);
//                result.add(cf);
//            }
//            return result;
//        }
//
//        @Override
//        public List<CloudFile> getFilesInfo(CloudId cloudId) {
//            CloudFileSystem fileSystem =
//                    CloudFileSystemFactory.getFileSystem(cloudId);
//            return fileSystem.getFiles();
//        }
//
//        @Override
//        public List<CloudFile> search() {
//            return null;
//        }
//
//        @Override
//        public void getFile() {
//
//        }
//
//        @Override
//        public void addFile() {
//
//        }
//    }
//
//    private class DropBoxCloudFile implements CloudFile {
//        private DropboxClient dbClient;
//        private DbFile dbFile;
//
//        public DropBoxCloudFile(DbFile file, DropboxClient dbClient) {
//            this.dbFile = file;
//            this.dbClient = dbClient;
//        }
//
//        @Override
//        public void getId() {}
//
//        @Override
//        public void getName() {}
//
//        @Override
//        public void getLength() {}
//
//        @Override
//        public boolean hasUrl() {
//            return false;
//        }
//
//        @Override
//        public String getUrl() {
//            return null;
//        }
//
//        @Override
//        public InputStream getInputStream() {
//            return null;
//        }
//
//        @Override
//        public void write(OutputStream out) {}
//
//        @Override
//        public void delete() {}
//    }
//
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
//
//
//
//
//
//}
