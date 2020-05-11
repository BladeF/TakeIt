package com.bladefrisch.takeit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bladefrisch.takeit.adapter.NoteAdapter;
import com.bladefrisch.takeit.data.entity.Note;
import com.bladefrisch.takeit.data.viewmodel.NoteListVMFactory;
import com.bladefrisch.takeit.data.viewmodel.NoteListViewModel;
import com.bladefrisch.takeit.utils.InjectorUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity
    implements NoteAdapter.NoteClickListener {

    private RecyclerView               mRecyclerView;
    private NoteAdapter                mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private NoteListViewModel          mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView  = findViewById(R.id.rv_note_list);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new NoteAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        NoteListVMFactory factory   = InjectorUtils.provideCategoryVMFactory(getApplicationContext());
        mViewModel = ViewModelProviders.of(this, factory).get(NoteListViewModel.class);
        mViewModel.getNotes().observe(this, (@Nullable List<Note> notes) ->
                mAdapter.setDataset(notes)
        );

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener( (View v) -> {
            Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onNoteClick(Note note) {
        mViewModel.deleteNote(note);
    }
}
