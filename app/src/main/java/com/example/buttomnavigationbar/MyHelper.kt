package com.example.buttomnavigationbar

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context: Context?):SQLiteOpenHelper(context,"TASKS", null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE TASKS(_id INTEGER PRIMARY KEY AUTOINCREMENT, task_name TEXT NOT NULL,alarm INTEGER DEFAULT 0,checked INTEGER DEFAULT 0)")//creating the sql db thingy
        db?.execSQL("DELETE FROM TASKS WHERE _id=2 or _id=1")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}