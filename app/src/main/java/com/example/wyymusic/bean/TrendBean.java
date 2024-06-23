package com.example.wyymusic.bean;

import java.util.List;

public class TrendBean {

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

        private int imgUrl;

        private String name;

        private String time;

        private String content;

        private String musicPath;

        private String musicName;

        private String singName;

        private String shareNumber;

        private String commentNumber;

        private String likeNumber;

        public DataDTO(int imgUrl, String name, String time, String content, String musicPath, String musicName, String singName, String shareNumber, String commentNumber, String likeNumber) {
            this.imgUrl = imgUrl;
            this.name = name;
            this.time = time;
            this.content = content;
            this.musicPath = musicPath;
            this.musicName = musicName;
            this.singName = singName;
            this.shareNumber = shareNumber;
            this.commentNumber = commentNumber;
            this.likeNumber = likeNumber;
        }

        public int getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(int imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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
