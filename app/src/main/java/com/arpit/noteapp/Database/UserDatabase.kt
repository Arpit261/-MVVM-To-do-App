package com.arpit.noteapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arpit.noteapp.Dao.UserDao
import com.arpit.noteapp.Model.User

@Database(entities = [User::class] , version = 1 , exportSchema = false)
abstract class UserDatabase :RoomDatabase() {

    abstract fun getDao():UserDao

  companion object{

    @Volatile
    var instance:UserDatabase?=null


    fun getInstance(context: Context):UserDatabase?{
        if (instance==null){
            synchronized(UserDatabase::class.java){
                if (instance==null){
                    instance=Room.databaseBuilder(context , UserDatabase::class.java , "UserDatabase")
                        .build()
                }
            }
        }
        return instance
    }

  }

}