package com.arpit.noteapp.Repo

import android.content.Context
import androidx.lifecycle.LiveData
import com.arpit.noteapp.Database.UserDatabase
import com.arpit.noteapp.Model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserRepository {
companion object{
    private  var userdatabase:UserDatabase?=null

    fun initialiseDb(context: Context):UserDatabase?{
        return UserDatabase.getInstance(context)
    }



    fun insert(context: Context , user: User){
     userdatabase= initialiseDb(context)
        CoroutineScope(IO).launch {
            userdatabase?.getDao()?.insert(user)
        }
    }

    fun getAllUserdata(context: Context): LiveData<List<User>>? {
      userdatabase= initialiseDb(context)
        return userdatabase?.getDao()?.getalldata()
    }
 }

 }