package com.example.crud.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.interfaces.CharacterIdAndName;
import com.example.crud.interfaces.CharacterNameAndMusicStyle;
import com.example.crud.model.Characters;
import com.example.crud.model.Music;
import com.example.crud.service.CharacterService;
import com.example.crud.service.MusicService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CharacterController {
    
    @Autowired
    CharacterService characterService;

    @Autowired
    MusicService musicService;

    // 1. Creates a character from a name and a music style
    // body example: {"name":"Max","musicId":1}
    @PostMapping("/character")
    private String saveCharacter(@RequestBody Characters character)
    {
        int musicId = character.getMusicId();
        if (!musicService.musicIdExists(musicId))
        {
            return "Music style " + musicId + " does not exist";
        }

        characterService.saveCharacter(character);
        int charId  = character.getId();
        String charName  = character.getName();

        return "Created character '" + charName + "' with id " + charId;   
    }

    // 2. Deletes a character by its id
    @DeleteMapping("/character/{id}")
    private String deleteCharacter(@PathVariable("id") int id)
    {
        try {
            characterService.delete(id);
            return "Character " + id + " deleted";
        } catch (Exception e) {
            return "Character " + id + " does not exist";
        }
    }

    // 3. Returns a list of all characters name and id
    @GetMapping("/characters")
    private List<CharacterIdAndName> getAllCharacters()
    {
        return characterService.getAllCharacters();
    }

    // 4. Returns the name and music style of the character by its id
    @GetMapping("/character/{id}")
    private CharacterNameAndMusicStyle getCharacter(@PathVariable("id") int id)
    {
        return characterService.getCharacterNameAndStyle(id);
    }

    // 5. Gets a sum of all ids of characters with the same name, case insensitive, odds are worth double
    @GetMapping("/idsum/{name}")
    private int getCharacterIdSum(@PathVariable("name") String name)
    {
        return characterService.getCharacterIdSum(name);
    }

    // Returns a list of music styles
    @GetMapping("/music")
    private List<Music> getAllMusicStyles()
    {
        return musicService.getAllMusicStyles();
    }

    // Adds a music style
    // body example: {"style":"Rock"}
    @PostMapping("/music")
    private String addMusicStyle(@RequestBody Music music)
    {
        musicService.saveMusic(music);
        int musicId = music.getId();
        return "Added music style '" + music.getStyle() + "' with id " + musicId;
    }
}
