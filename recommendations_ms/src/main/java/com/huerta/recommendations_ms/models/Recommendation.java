package com.huerta.recommendations_ms.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class Recommendation {
    @Id
    private String id;
    private String username;
    private String title;
    private String content;
    private String category;
    private Date releaseDate;

    
    public Recommendation(String id,String username,String title,String  content, String category, Date releaseDate){
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.category = category;
        this.releaseDate = releaseDate;
    }
    public Recommendation(String id){
        this.id = id;
    }
    public Recommendation(){
        
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public  void setUsername (String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }


    public String getContent() {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory (String category) {
        this.category = category;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate =releaseDate;
    }

}
