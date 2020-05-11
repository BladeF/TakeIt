package com.bladefrisch.takeit.data.dao;

import com.bladefrisch.takeit.data.entity.Note;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM notes")
    public LiveData<List<Note>> getNotes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addNote(Note note);

    @Delete
    public void deleteNote(Note note);
}
