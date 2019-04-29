package com.bladefrisch.takeit.data.viewmodel;

import com.bladefrisch.takeit.data.NoteRepository;
import com.bladefrisch.takeit.data.entity.Note;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class NoteListViewModel extends ViewModel {
    private LiveData<List<Note>> mNotes;
    private NoteRepository         mRepository;

    public NoteListViewModel(NoteRepository repository) {
        mRepository = repository;
        mNotes      = mRepository.getNotes();
    }

    public LiveData<List<Note>> getNotes() {
        return mNotes;
    }

    public void deleteNote(Note note) {
        mRepository.deleteNote(note);
    }
}
