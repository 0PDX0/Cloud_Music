package com.example.wyymusic.bean;

public class MusicBean {

    private String musicName;

    private String singName;

    private String imgUrl;

    private String audioPath;

    public MusicBean(String musicName, String singName, String imgUrl, String audioPath) {
        this.musicName = musicName;
        this.singName = singName;
        this.imgUrl = imgUrl;
        this.audioPath = audioPath;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }
}
