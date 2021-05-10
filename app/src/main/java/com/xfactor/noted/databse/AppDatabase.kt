package com.xfactor.noted.databse

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [List::class, ListItem::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun listDao(): ListDao
    abstract fun listItemDao(): ListItemDao
}