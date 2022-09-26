package com.example.crud.repository;  
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.crud.interfaces.CharacterIdAndName;
import com.example.crud.interfaces.CharacterNameAndMusicStyle;
import com.example.crud.model.Characters;
public interface CharacterRepository extends CrudRepository<Characters, Integer>  
{  
    @Query(value = "SELECT id as id, name as name from characters", nativeQuery = true)
    List<CharacterIdAndName> getCharacterIdAndName();

    @Query(value = "SELECT c.name, m.style as musicName FROM characters c INNER JOIN music m ON c.music_id = m.id WHERE c.id = ?1", nativeQuery = true)
    CharacterNameAndMusicStyle getCharacterNameAndMusicStyle(int id);

    @Query(value = "SELECT COALESCE(SUM(CASE WHEN id % 2 <> 0 THEN id * 2 ELSE id END),0) id FROM characters WHERE LOWER(name) LIKE LOWER(?1)", nativeQuery = true)
    int getCharacterIdSum(String name);
}  