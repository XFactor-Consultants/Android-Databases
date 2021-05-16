package com.xfactor.noted.ui.add

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xfactor.noted.databse.ListItem
import com.xfactor.noted.databse.ListWithListItems
import com.xfactor.noted.getListItems
import com.xfactor.noted.getLists

class NewlistViewModel : ViewModel() {

    private val lastId = if (getLists().isNotEmpty()) getLists().last().list.uid else 0

    private var lastElementId = if (getListItems().isNotEmpty()) getListItems().last().uid else 0

    private  var indexInList = 0

    private var _listItem = MutableLiveData<ListWithListItems>().apply {
        value = ListWithListItems(com.xfactor.noted.databse.List(lastId + 1, "Example title"), mutableListOf())
    }
    var listItem: LiveData<ListWithListItems> = _listItem
    fun setTitle(title:String) {
        _listItem.postValue(ListWithListItems(com.xfactor.noted.databse.List(_listItem.value!!.list.uid, title), _listItem.value!!.ListItems))
    }
    fun addItem(item:String){
        val currentVal = _listItem.value ?: return
        val elements = currentVal.ListItems
        lastElementId += 1
        _listItem.postValue(ListWithListItems(com.xfactor.noted.databse.List(currentVal.list.uid, currentVal.list.title), elements.plus(ListItem(
            lastElementId + 1, currentVal.list.uid, item, indexInList))))
        indexInList +=1
        Log.e("list uid", currentVal.list.uid.toString())
        Log.e("list element uid", (getListItems().size + 1).toString())
    }
}