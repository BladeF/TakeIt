package com.bladefrisch.takeit.data.viewmodel;

import com.bladefrisch.takeit.data.NoteRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class NoteListVMFactory extends ViewModelProvider.NewInstanceFactory {

    private final NoteRepository mRepository;

    public NoteListVMFactory(NoteRepository repository) {
        mRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new NoteListViewModel(mRepository);
    }
}
