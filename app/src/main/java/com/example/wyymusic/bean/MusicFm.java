package com.example.wyymusic.bean;


import java.io.Serializable;
import java.util.List;

/**
 * @author 派大星
 * @title: MusicFm
 * @projectName ShiXun01
 * @description: PDX
 * @date 2024/1/18 15:28
 */

public class MusicFm implements Serializable {

    private int code;

    private String msg;

    private List<DateDTO> data;

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

    public List<DateDTO> getData() {
        return data;
    }

    public void setData(List<DateDTO> data) {
        this.data = data;
    }

    public class DateDTO{

        private String imgUrl;

        private String musicName;

        private String name;

        private String album;

        private String playSum;

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

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        public String getPlaySum() {
            return playSum;
        }

        public void setPlaySum(String playSum) {
            this.playSum = playSum;
        }

        public String getAudioPath() {
            return audioPath;
        }

        public void setAudioPath(String audioPath) {
            this.audioPath = audioPath;
        }
    }


}
