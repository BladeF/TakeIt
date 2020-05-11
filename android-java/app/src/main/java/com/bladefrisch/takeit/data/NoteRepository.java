package com.bladefrisch.takeit.data;

import com.bladefrisch.takeit.data.dao.NoteDao;
import com.bladefrisch.takeit.data.entity.Note;
import com.bladefrisch.takeit.utils.AppExecutors;

import java.util.List;

import androidx.lifecycle.LiveData;

public class NoteRepository {

    private static final Object LOCK = new Object();

    private static NoteRepository sInstance;

    private final NoteDao      mNoteDao;
    private final AppExecutors mExecutors;

    NoteRepository(NoteDao noteDao, AppExecutors executors) {
        mNoteDao   = noteDao;
        mExecutors = executors;
    }

    public static NoteRepository getInstance(NoteDao noteDao, AppExecutors executors) {
        if(sInstance == null) {
            synchronized (LOCK) {
                sInstance = new NoteRepository(noteDao, executors);
            }
        }

        return sInstance;
    }

    public LiveData<List<Note>> getNotes() {
        return mNoteDao.getNotes();
    }

    public void takeNote(Note note) {
        mExecutors.getDiskIO().execute( () ->
                mNoteDao.addNote(note)
        );
    }

    public void deleteNote(Note note) {
        mExecutors.getDiskIO().execute( () ->
                mNoteDao.deleteNote(note)
        );
    }
}
