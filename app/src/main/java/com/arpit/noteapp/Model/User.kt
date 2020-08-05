package com.arpit.noteapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
 data class User(
    var name:String, var age:Int)
{
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}
