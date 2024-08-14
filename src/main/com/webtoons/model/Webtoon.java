package main.com.webtoons.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Webtoon {
    private int id;
    private String title, author, platform, cover_img, summary, created_at;

    public Webtoon(String title, String author, String platform, String cover_img, String summary) {
        this.title = title;
        this.author = author;
        this.platform = platform;
        this.cover_img = cover_img;
        this.summary = summary;
    }
}
