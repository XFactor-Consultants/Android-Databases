package com.xfactor.noted

fun getSubItems(item: ListItem):String {
    val inListForm = item.elements.mapIndexed {idx, value -> (idx+1).toString().plus(". ").plus(value)}
    return inListForm.joinToString("\n")
}