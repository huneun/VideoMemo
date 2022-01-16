package com.example.videomemo;

public class MemoData {

    private String videoUrl;
    private String title;
    private String content;

    public MemoData(String videoUrl, String title, String content) {
        this.videoUrl = videoUrl;
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
