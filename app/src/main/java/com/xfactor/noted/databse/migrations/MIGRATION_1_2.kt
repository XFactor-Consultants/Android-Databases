package com.xfactor.noted.databse.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGATION_1_2 = object  : Migration(1,2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE `ListItem` (`uid` INTEGER NOT NULL, `value` TEXT NOT NULL, `listId` INTEGER NOT NULL, PRIMARY KEY(`uid`)) ")
    }
}