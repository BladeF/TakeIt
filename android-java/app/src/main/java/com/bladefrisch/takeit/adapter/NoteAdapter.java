package com.bladefrisch.takeit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bladefrisch.takeit.R;
import com.bladefrisch.takeit.data.entity.Note;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note> mDataset;

    private final NoteClickListener mNoteClickListener;

    public interface NoteClickListener {
        void onNoteClick(Note note);
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {
        public TextView noteText;

        public NoteViewHolder(View view) {
            super(view);
            noteText = view.findViewById(R.id.note_text);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mNoteClickListener.onNoteClick(mDataset.get(getAdapterPosition()));
        }
    }

    public NoteAdapter(NoteClickListener listener) {
        mDataset           = new ArrayList<>();
        mNoteClickListener = listener;
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
