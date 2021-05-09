package com.xfactor.noted.databse

import androidx.room.*
import kotlin.collections.List

@Dao
interface ListDao {
    @Query("SELECT * FROM list")
    fun getAll(): List<com.xfactor.noted.databse.List>

    @Transaction
    @Query("SELECT * FROM list")
    fun getListsWithListItems(): List<ListWithListItems>

    @Insert
    fun insertAll(vararg lists: com.xfactor.noted.databse.List)

    @Delete
    fun delete(list: com.xfactor.noted.databse.List)
}