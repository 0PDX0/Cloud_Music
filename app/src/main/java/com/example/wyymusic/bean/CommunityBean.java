package com.example.wyymusic.bean;

import java.util.List;

public class CommunityBean {

    private int code;

    private String msg;

    private List<DataDTO> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }



    public static class DataDTO{

        private String userImgUrl;

        private String userName;

        private String content;

        private String img1;

        private String img2;

        private String musicPath;

        private String musicName;

        private String singName;

        private String type;

        private String shareNumber;

        private String commentNumber;

        private String likeNumber;

        public DataDTO(String userImgUrl, String userName, String content, String img1, String img2, String musicPath, String musicName, String singName, String type, String shareNumber, String commentNumber, String likeNumber) {
            this.userImgUrl = userImgUrl;
            this.userName = userName;
            this.content = content;
            this.img1 = img1;
            this.img2 = img2;
            this.musicPath = musicPath;
            this.musicName = musicName;
            this.singName = singName;
            this.type = type;
            this.shareNumber = shareNumber;
            this.commentNumber = commentNumber;
            this.likeNumber = likeNumber;
        }

        public String getUserImgUrl() {
            return userImgUrl;
        }

        public void setUserImgUrl(String userImgUrl) {
            this.userImgUrl = userImgUrl;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImg1() {
            return img1;
        }

        public void setImg1(String img1) {
            this.img1 = img1;
        }

        public String getImg2() {
            return img2;
        }

        public void setImg2(String img2) {
            this.img2 = img2;
        }

        public String getMusicPath() {
            return musicPath;
        }

        public void setMusicPath(String musicPath) {
            this.musicPath = musicPath;
        }

        public String getMusicName() {
            return musicName;
        }

        public void setMusicName(String musicName) {
            this.musicName = musicName;
        }

        public String getSingName() {
            return singName;
        }

        public void setSingName(String singName) {
            this.singName = singName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getShareNumber() {
            return shareNumber;
        }

        public void setShareNumber(String shareNumber) {
            this.shareNumber = shareNumber;
        }

        public String getCommentNumber() {
            return commentNumber;
        }

        public void setCommentNumber(String commentNumber) {
            this.commentNumber = commentNumber;
        }

        public String getLikeNumber() {
            return likeNumber;
        }

        public void setLikeNumber(String likeNumber) {
            this.likeNumber = likeNumber;
        }
    }



}
























