package com.example.marvelapp.data.db;import androidx.room.Dao;import androidx.room.Delete;import androidx.room.Insert;import androidx.room.OnConflictStrategy;import androidx.room.Query;import androidx.room.Transaction;import com.example.marvelapp.data.model.Character;import java.util.ArrayList;import java.util.List;import io.reactivex.rxjava3.core.Flowable;import io.reactivex.rxjava3.core.Observable;import io.reactivex.rxjava3.core.Single;@Daopublic interface CharacterDao {   @Query("SELECT * FROM character")   Observable<List<Character>> loadCharacters();    @Query("SELECT * FROM character WHERE ID IN (:id)")    Character loadCharacter(String id);    @Transaction    default void updateRecord(Character character){        deleteAllCharacters();        List<Character> charactersList = new ArrayList<>();        charactersList.add(character);        saveCharacters(new ArrayList<Character>(charactersList));    }    @Query("Select * from character where  name like '%' || :search || '%' ")    Observable<List<Character>> getSearchResults(String search);    @Query("DELETE from character")    void deleteAllCharacters();    @Insert(onConflict = OnConflictStrategy.REPLACE)    void saveCharacters(List<Character> characters);}