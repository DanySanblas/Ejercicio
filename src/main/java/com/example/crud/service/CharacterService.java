package com.example.crud.service;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.example.crud.interfaces.CharacterIdAndName;
import com.example.crud.interfaces.CharacterNameAndMusicStyle;
import com.example.crud.model.Characters;
import com.example.crud.repository.CharacterRepository;

@Service
public class CharacterService 
{
    @Autowired
    CharacterRepository characterRepository;

    public List<CharacterIdAndName> getAllCharacters()
    {
        return characterRepository.getCharacterIdAndName();
    }

    public CharacterNameAndMusicStyle getCharacterNameAndStyle(int id)
    {
        return characterRepository.getCharacterNameAndMusicStyle(id);
    }

    public void saveCharacter(Characters character)
    {
        characterRepository.save(character);
    }

    public void delete(int id)
    {
        characterRepository.deleteById(id);
    }

    public int getCharacterIdSum(String name)
    {
        return characterRepository.getCharacterIdSum(name);
    }
}
