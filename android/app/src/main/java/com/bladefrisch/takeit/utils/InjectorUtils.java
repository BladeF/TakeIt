package com.bladefrisch.takeit.utils;

import android.content.Context;

import com.bladefrisch.takeit.data.AppDatabase;
import com.bladefrisch.takeit.data.NoteRepository;
import com.bladefrisch.takeit.data.viewmodel.NoteListVMFactory;

public class InjectorUtils {

    public static NoteRepository provideRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context.getApplicationContext());
        AppExecutors executors = AppExecutors.getInstance();

        return NoteRepository.getInstance(database.noteDao(), executors);
    }

    public static NoteListVMFactory provideCategoryVMFactory(Context context) {
        NoteRepository repository = provideRepository(context.getApplicationContext());
        return new NoteListVMFactory(repository);
    }

}
