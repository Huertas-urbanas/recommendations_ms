package com.huerta.recommendations_ms.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class Recommendation {
    @Id

    private Integer id;
    private String username;
    private String title;
    private String content;
    private String category;
    private Date releaseDate;

    
    public Recommendation(Integer id,String username,String title,String  content, String category, Date releaseDate){
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.category = category;
        this.releaseDate = releaseDate;
    }
    public Recommendation(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }
    public static void setId(Integer id){
       // this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public static void setUsername (String username) {
       // this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    //revisar si es string o no
    public String getContent() {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public String getCategoty() {
        return category;
    }

    public void setCategoty (String category) {
        this.category = category;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public static void setReleaseDate(Date releaseDate) {
      //  this.releaseDate = releaseDate;
    }



}
