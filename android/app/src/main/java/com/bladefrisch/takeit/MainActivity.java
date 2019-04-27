package com.bladefrisch.takeit;

import android.content.Intent;
import android.os.Bundle;

import com.bladefrisch.takeit.data.entity.Note;
import com.bladefrisch.takeit.data.viewmodel.NoteListVMFactory;
import com.bladefrisch.takeit.data.viewmodel.NoteListViewModel;
import com.bladefrisch.takeit.utils.InjectorUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import com.bladefrisch.takeit.adapter.NoteAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView               mRecyclerView;
    private NoteAdapter                mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView  = findViewById(R.id.rv_note_list);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new NoteAdapter();
        mRecyclerView.setAdapter(mAdapter);

        NoteListVMFactory factory   = InjectorUtils.provideCategoryVMFactory(getApplicationContext());
        NoteListViewModel viewModel = ViewModelProviders.of(this, factory).get(NoteListViewModel.class);
        viewModel.getNotes().observe(this, (@Nullable List<Note> notes) ->
                mAdapter.setDataset(notes)
        );

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener( (View v) -> {
            Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
            startActivity(intent);
        });
    }
}
