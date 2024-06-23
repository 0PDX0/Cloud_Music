package com.example.wyymusic.bean;

import java.util.List;

public class WyyMusicBean {

    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result{

        private List<Songs> songs;

        public List<Songs> getSongs() {
            return songs;
        }

        public void setSongs(List<Songs> songs) {
            this.songs = songs;
        }

        public class Songs{

            private String id;

            private String name;

            private List<Artists> artists;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<Artists> getArtists() {
                return artists;
            }

            public void setArtists(List<Artists> artists) {
                this.artists = artists;
            }

            @Override
            public String toString() {
                return "Songs{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", artists=" + artists.toString() +
                        '}';
            }

            public class Artists{

                private int id;

                private String name;

                private String picUrl;

                private String img1v1Url;

                private String img1v1;

                @Override
                public String toString() {
                    return "Artists{" +
                            "id=" + id +
                            ", name='" + name + '\'' +
                            ", picUrl='" + picUrl + '\'' +
                            ", img1v1Url='" + img1v1Url + '\'' +
                            ", img1v1='" + img1v1 + '\'' +
                            '}';
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public String getImg1v1() {
                    return img1v1;
                }

                public void setImg1v1(String img1v1) {
                    this.img1v1 = img1v1;
                }
            }
        }


    }





}
























