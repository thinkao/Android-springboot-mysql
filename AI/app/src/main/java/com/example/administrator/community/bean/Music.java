package com.example.administrator.community.bean;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2019/5/24.
 */

public class Music {
    public String title;//歌曲名称
    public String artist;//歌手名称
    public String album;//专辑名称
    public int length;//歌曲时间长度
    public Bitmap albumbtm;//专辑图片

    public Music(String title, String artist, String album, int length, Bitmap albumbtm) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.length = length;
        this.albumbtm = albumbtm;
    }

    public Music() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Bitmap getAlbumbtm() {
        return albumbtm;
    }

    public void setAlbumbtm(Bitmap albumbtm) {
        this.albumbtm = albumbtm;
    }
}
