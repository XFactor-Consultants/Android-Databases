package com.xfactor.noted.ui.add

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.xfactor.noted.ListItem
import com.xfactor.noted.Lists
import com.xfactor.noted.R
import com.xfactor.noted.getSubItems

class NewlistFragment : Fragment() {

    private lateinit var newlistViewModel: NewlistViewModel



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        newlistViewModel =
                ViewModelProviders.of(this).get(NewlistViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_newlist, container, false)
        val textView: TextView = root.findViewById(R.id.text_newlist)
        val elements: TextView = root.findViewById(R.id.elements_adding)
        newlistViewModel.listItem.observe(viewLifecycleOwner, Observer {
            textView.text = it.title
            elements.text = getSubItems(it)
        })
        val editTitle: AppCompatEditText = root.findViewById(R.id.edit_title)
        editTitle.addTextChangedListener(object :TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                newlistViewModel.setTitle(s.toString())
            }
        })
        val addItem :Button = root.findViewById(R.id.add_item)

        addItem.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(context)
            builder.setTitle("New List Item")
            val input = EditText(context)
            builder.setView(input)
            builder.setPositiveButton("Add"
            ) { _, _ -> newlistViewModel.addItem(input.text.toString()) }
            builder.setNegativeButton("Cancel"
            ) { dialog, _ -> dialog.cancel() }
            builder.show()
        }

        val submit: Button = root.findViewById(R.id.submit_newlist)
        submit.setOnClickListener {
            Lists.add(Lists.size, newlistViewModel.listItem.value!!)
            Navigation.findNavController(it).navigate(R.id.navigation_listcontainer)
        }
        val cancel: Button = root.findViewById(R.id.cancel_newlist)
        cancel.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.navigation_listcontainer)
        }
        return root
    }
}