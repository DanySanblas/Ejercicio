package com.example.crud.model;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name = "music")
public class Music {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String style;
    
    public int getId()
    {
        return id;
    }

    public String getStyle(){
        return style;
    }

    public void setStyle(String style){
        this.style = style;
    }
}
