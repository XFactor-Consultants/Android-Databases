package com.xfactor.noted.ui.listcontainer

import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xfactor.noted.*
import kotlinx.android.synthetic.main.fragment_listcontainer.view.*
import kotlinx.android.synthetic.main.fragment_listitem.view.*

private lateinit var statusText : TextView;

fun updateStatus() {
    if(ListsToCompare.size == 0)  return
    var status = "Selected: ".plus(ListsToCompare[0].title)
    if(ListsToCompare.size == 2) {
        status = status.plus(", ").plus(ListsToCompare[1].title)
    }
    statusText.text = status
}

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
        statusText = root.findViewById(R.id.status)
        updateStatus()
        return root
    }

}
class ListsAdapter(private val dataSet: MutableList<ListItem>) :
    RecyclerView.Adapter<ListsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val listItem: LinearLayout = view.findViewById(R.id.listitem)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.listItem.setOnClickListener {
            if(ListsToCompare.size > 1) {
                ListsToCompare.clear()
            }
            ListsToCompare.add(dataSet[position])
            updateStatus()
        }
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