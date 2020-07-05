package com.example.wangeci;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_note_list);
    }
   private void initializeDisplayContent(){
        final RecyclerView recyclerViewNotes=(RecyclerView) findViewById(R.id.list_notes);
        final LinearLayoutManager notesLayoutManager=new LinearLayoutManager(this);
        recyclerViewNotes.setLayoutManager(notesLayoutManager);

       List<NoteInfo> notes =DataManager.getInstance().getNotes();
       final NoteRecyclerViewAdapter noteRecyclerViewAdapter=new NoteRecyclerViewAdapter(this,notes);
       recyclerViewNotes.setAdapter(noteRecyclerViewAdapter);
   }

}
