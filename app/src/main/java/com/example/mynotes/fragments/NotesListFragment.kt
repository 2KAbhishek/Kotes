package com.example.mynotes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.R
import com.example.mynotes.adapters.NotesListRecyclerViewAdapter
import com.example.mynotes.persistence.NotesPersistence
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NotesListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val notesRecyclerViewUI: RecyclerView = view.findViewById(R.id.notesListRecyclerView)
        notesRecyclerViewUI.layoutManager = LinearLayoutManager(activity)
        val notesListRecyclerViewAdapter: NotesListRecyclerViewAdapter = NotesListRecyclerViewAdapter()
        notesRecyclerViewUI.adapter = notesListRecyclerViewAdapter
        notesListRecyclerViewAdapter.setNotes(NotesPersistence.notes)

        view.findViewById<FloatingActionButton>(R.id.floating_action_button).setOnClickListener {
            findNavController().navigate(R.id.action_notesListFragment_to_createNoteFragment)
        }
    }
}