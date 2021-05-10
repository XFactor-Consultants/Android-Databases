package com.xfactor.noted.databse

import androidx.room.Embedded
import androidx.room.Relation

data class ListWithListItems (
    @Embedded val list: List,
    @Relation (
        parentColumn = "uid",
        entityColumn = "listId"
    )
    val ListItems: kotlin.collections.List<ListItem>
)
