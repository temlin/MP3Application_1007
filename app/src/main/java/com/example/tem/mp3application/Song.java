package com.example.tem.mp3application;

/**
 * Created by user on 2016/10/7.
 */
public class Song {
    private long id;
    private String title;
    private String album;

    public Song(long thisId, String thisTitle, String thisAlbum) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
