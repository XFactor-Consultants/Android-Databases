package com.xfactor.noted.databse

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ListItemDao {
    @Query("SELECT * FROM listitem")
    fun getAll(): kotlin.collections.List<ListItem>

    @Insert
    fun insertAll(vararg listitems: com.xfactor.noted.databse.ListItem)

    @Delete
    fun delete(listitem: com.xfactor.noted.databse.ListItem)
}