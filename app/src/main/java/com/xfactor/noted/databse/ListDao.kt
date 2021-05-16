package com.xfactor.noted.databse

import androidx.room.*
import kotlin.collections.List

@Dao
interface ListDao {
    @Query("SELECT * FROM list")
    fun getAll(): List<com.xfactor.noted.databse.List>

    @Query("SELECT * FROM list WHERE title LIKE '%Favorite%'")
    fun getAllFavorites(): List<ListWithListItems>

    @Query("SELECT * FROM list INNER JOIN listitem ON list.uid = listitem.listId WHERE list.title LIKE '%Favorite%' GROUP BY list.uid")
    fun getCompareLists(): List<ListWithListItems>

    @Transaction
    @Query("SELECT * FROM list")
    fun getListsWithListItems(): List<ListWithListItems>

    @Insert
    fun insertAll(vararg lists: com.xfactor.noted.databse.List)

    @Delete
    fun delete(list: com.xfactor.noted.databse.List)
}