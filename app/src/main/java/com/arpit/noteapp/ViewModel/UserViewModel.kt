package com.arpit.noteapp.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arpit.noteapp.Model.User
import com.arpit.noteapp.Repo.UserRepository

class UserViewModel:ViewModel() {

    fun insert(context: Context , user: User){
        UserRepository.insert(context , user)
    }


    fun getalldata(context: Context): LiveData<List<User>>? {
        return UserRepository.getAllUserdata(context)
    }
}