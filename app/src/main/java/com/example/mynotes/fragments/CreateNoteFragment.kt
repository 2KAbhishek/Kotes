package com.example.mynotes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mynotes.R
import com.example.mynotes.models.NoteModel
import com.example.mynotes.persistence.NotesPersistence

class CreateNoteFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                saveNote()
                findNavController().popBackStack()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolBar = view.findViewById<Toolbar>(R.id.topAppBarCreateNoteFragment)
        toolBar.setNavigationOnClickListener {
            saveNote()
            findNavController().popBackStack()
        }
    }

    private fun saveNote() {
        val noteTitle: String = requireView().findViewById<TextView>(R.id.noteTitleInputField).text.toString()
        val noteBody: String = requireView().findViewById<TextView>(R.id.noteBodyInputField).text.toString()
        if (noteTitle.isNotEmpty()) {
            val note = NoteModel(noteTitle, noteBody)
            NotesPersistence.notes.add(note)
        }
    }
}