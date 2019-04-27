package com.bladefrisch.takeit.data;

import android.content.Context;

import com.bladefrisch.takeit.data.dao.NoteDao;
import com.bladefrisch.takeit.data.entity.Note;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "notes_db";
    private static final Object LOCK          = new Object();
    private static AppDatabase  sInstance;

    abstract public NoteDao noteDao();

    public static AppDatabase getInstance(Context context) {
        if(sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .build();
            }
        }

        return sInstance;
    }
}