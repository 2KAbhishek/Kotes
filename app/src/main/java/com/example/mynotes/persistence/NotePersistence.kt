package com.example.mynotes.persistence

import com.example.mynotes.models.NoteModel

object NotesPersistence {
    val notes = ArrayList<NoteModel>()

    init {
        initializeNotesPersistence();
    }

    private fun initializeNotesPersistence() {
        println(notes.size)
    }
}