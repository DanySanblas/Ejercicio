package com.example.crud.model;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name = "characters")
public class Characters {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(name = "music_id")
    private int musicId;

    @ManyToOne
    @JoinColumn(name = "music_id", insertable = false, updatable = false)
    private Music music;


    public int getId()
    {
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public Music getMusic()
    {
        return music;
    }
    
    public void setMusic(Music music)
    {
        this.music = music;
    }

    public String getMusicName()
    {
        return music.getStyle();
    }
}

