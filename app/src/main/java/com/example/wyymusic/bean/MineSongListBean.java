package com.example.wyymusic.bean;

import java.util.List;

public class MineSongListBean {

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

        private String content;

        private int isLove;

        public DataDTO(int imgUrl, String name, String content, int isLove) {
            this.imgUrl = imgUrl;
            this.name = name;
            this.content = content;
            this.isLove = isLove;
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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getIsLove() {
            return isLove;
        }

        public void setIsLove(int isLove) {
            this.isLove = isLove;
        }
    }

}
