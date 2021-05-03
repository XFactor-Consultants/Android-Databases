package com.xfactor.noted.ui.compare

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.xfactor.noted.R
import com.xfactor.noted.ui.add.NewlistViewModel

class CompareFragment : Fragment() {
    private lateinit var compareViewModel: CompareViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        compareViewModel =
            ViewModelProviders.of(this).get(CompareViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_compare, container, false)
        val textView: TextView = root.findViewById(R.id.text_compare)
        compareViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}