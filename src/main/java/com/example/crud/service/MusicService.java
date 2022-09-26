package com.example.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Music;
import com.example.crud.repository.MusicRepository;

@Service
public class MusicService 
{
    @Autowired
    MusicRepository musicRepository;

    public boolean musicIdExists(int id)
    {
        return musicRepository.findById(id).isPresent();
    }

    public List<Music> getAllMusicStyles()
    {
        List<Music> styles = new ArrayList<Music>();  
        musicRepository.findAll().forEach(style -> styles.add(style));  
        return styles;  
    }
    
    public void saveMusic(Music music)
    {
        musicRepository.save(music);
    }
}
