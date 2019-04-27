package com.bladefrisch.takeit.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bladefrisch.takeit.R;
import com.bladefrisch.takeit.data.entity.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note> mDataset;

    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        public TextView noteText;

        public NoteViewHolder(View view) {
            super(view);
            noteText = view.findViewById(R.id.note_text);
        }
    }

    public NoteAdapter() {
        mDataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public NoteAdapter.NoteViewHolder onCreateViewHolder(@NonNull ViewGroup group, int viewType) {
        View v = LayoutInflater.from(group.getContext())
                .inflate(R.layout.note_layout, group, false);

        return new NoteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = mDataset.get(position);
        holder.noteText.setText(note.text);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setDataset(List<Note> dataset) {
        mDataset = dataset;
        notifyDataSetChanged();
    }
}
