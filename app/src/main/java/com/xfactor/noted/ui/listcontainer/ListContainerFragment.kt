package com.xfactor.noted.ui.listcontainer

import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xfactor.noted.ListItem
import com.xfactor.noted.Lists
import com.xfactor.noted.R
import kotlinx.android.synthetic.main.fragment_listcontainer.view.*
import kotlinx.android.synthetic.main.fragment_listitem.view.*


class ListContainerFragment : Fragment() {

    private var adapter = ListsAdapter(Lists);

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_listcontainer, container, false)
        root.all_lists.layoutManager = GridLayoutManager(context, 2)
        root.all_lists.adapter = adapter
        return root
    }

}
class ListsAdapter(private val dataSet: MutableList<ListItem>) :
    RecyclerView.Adapter<ListsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val listItem: LinearLayout = view.findViewById(R.id.listitem)
    }

    private fun getSubItems(item: ListItem):String {
        val inListForm = item.elements.mapIndexed {idx, value -> (idx+1).toString().plus(". ").plus(value)}
        return inListForm.joinToString("\n")
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val title = viewHolder.listItem.list_title
        title.text = dataSet[position].title
        title.paintFlags = title.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        viewHolder.listItem.list_elements.text = getSubItems(dataSet[position])
        val visibility: Int = viewHolder.listItem.visibility
        viewHolder.listItem.visibility = View.GONE
        viewHolder.listItem.visibility = visibility
    }

    override fun getItemCount():Int {
        return dataSet.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_listitem, parent, false)
        return ViewHolder(view)
    }

}