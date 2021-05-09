package com.xfactor.noted.databse

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class List (
    @PrimaryKey val uid: Int,
    @ColumnInfo(name="title") val title: String
)