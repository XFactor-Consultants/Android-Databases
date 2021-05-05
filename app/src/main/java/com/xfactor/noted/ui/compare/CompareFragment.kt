package com.xfactor.noted.ui.compare

import android.app.AlertDialog
import android.graphics.Paint
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.xfactor.noted.ListsToCompare
import com.xfactor.noted.R
import com.xfactor.noted.getSubItems
import com.xfactor.noted.ui.add.NewlistViewModel

class CompareFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_compare, container, false)
        root.findViewById<Button>(R.id.back).setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.navigation_listcontainer)
        }
        val leftTitle: TextView = root.findViewById(R.id.list_compare_left_title)
        val rightTitle: TextView = root.findViewById(R.id.list_compare_right_title)
        val leftElements: TextView = root.findViewById(R.id.list_compare_left_elements)
        val rightElements: TextView = root.findViewById(R.id.list_compare_right_elements)

        if(ListsToCompare.size !== 2) {
            val builder: AlertDialog.Builder = AlertDialog.Builder(context)
            builder.setTitle("Missing Lists")
            val desc = TextView(context)
            desc.setPadding(30)
            desc.text = "You have only specified ".plus(ListsToCompare.size).plus(" list(s). Select 2 to compare.")
            builder.setView(desc)
            builder.setPositiveButton("Ok"
            ) { _, _ -> Navigation.findNavController(root).navigate(R.id.navigation_listcontainer) }
            builder.show()
            return root
        }
        val leftList = ListsToCompare[0]
        val rightList = ListsToCompare[1]
        leftTitle.text = leftList.title
        rightTitle.text = rightList.title
        leftTitle.paintFlags = leftTitle.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        rightTitle.paintFlags = rightTitle.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        leftElements.text = getSubItems(leftList)
        rightElements.text = getSubItems(rightList)
        return root
    }
}