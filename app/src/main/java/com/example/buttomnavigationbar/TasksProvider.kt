package com.example.buttomnavigationbar

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri

class TasksProvider : ContentProvider() {

    companion object{
        val PROVIDER_NAME= "com.example.customcontentproviderdemo/TasksProvider"
        val URL = "content://$PROVIDER_NAME/TASKS"
        val CONTENT_URI = Uri.parse(URL)

        //creating the values that points at the db cols
        val _ID= "_id"
        val task_name="task_name"
        val has_alarm="alarm"
        val is_checked="checked"

    }
    lateinit var db : SQLiteDatabase




    override fun onCreate(): Boolean {
        var helper= MyHelper(context)
        db= helper.writableDatabase
        return if(db==null) false else true
    }

    override fun query(
        uri: Uri,
        cols: Array<out String>?,
        condition: String?,
        condition_val: Array<out String>?,
        order: String?
    ): Cursor? {
        return db.query("TASKS",cols,condition,condition_val,null,null,null)
    }

    override fun getType(uri: Uri): String? {
        return "vnd.android.cursor.dir/vnd.example.TASKS"
    }

    override fun insert(uri: Uri, cv: ContentValues?): Uri? {
        db.insert("TASKS",null,cv)
        context?.contentResolver?.notifyChange(uri,null)
        return uri
    }

    override fun delete(uri: Uri, condition: String?, condition_val: Array<out String>?): Int {
        var count: Int= db.delete("TASKS",condition,condition_val)
        context?.contentResolver?.notifyChange(uri,null)
        return count
    }

    override fun update(uri: Uri, cv: ContentValues?, condition: String?, condition_val: Array<out String>?): Int {
        var count: Int = db.update("TASKS",cv,condition,condition_val)
        context?.contentResolver?.notifyChange(uri,null)
        return count
    }
}