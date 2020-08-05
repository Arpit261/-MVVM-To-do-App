package com.arpit.noteapp.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arpit.noteapp.Model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insert(user: User)


    @Query("SELECT * FROM user ORDER BY id ASC")
    fun getalldata():LiveData<List<User>>

}