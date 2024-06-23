package com.example.wyymusic.bean;

import java.util.List;

public class HotMusicBean {

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

    public class DataDTO{

        private String imgUrl;

        private String musicName;

        private String name;

        private String audioPath;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getMusicName() {
            return musicName;
        }

        public void setMusicName(String musicName) {
            this.musicName = musicName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAudioPath() {
            return audioPath;
        }

        public void setAudioPath(String audioPath) {
            this.audioPath = audioPath;
        }

        @Override
        public String toString() {
            return "DataDTO{" +
                    "imgUrl='" + imgUrl + '\'' +
                    ", musicName='" + musicName + '\'' +
                    ", name='" + name + '\'' +
                    ", audioPath='" + audioPath + '\'' +
                    '}';
        }
    }

}
