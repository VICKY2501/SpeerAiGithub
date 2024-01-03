package com.example.speerai.fragments

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.viewpager2.widget.ViewPager2
import com.example.speerai.R
import com.example.speerai.adapters.MyViewPagerAdapter
import com.google.android.material.textfield.TextInputEditText

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchView:TextInputEditText=view.findViewById(R.id.searchBar)
        val searchButton:Button=view.findViewById(R.id.searchButton)
        val query:String=searchView.toString()
        searchButton.setOnClickListener {
            Log.d(tag,query)
            if(query.isNotEmpty()){
            performSearch(query)}
            else Toast.makeText(this.requireActivity(),"Enter Github UserName",Toast.LENGTH_SHORT).show()
        }
    }

    private fun performSearch(query: String) {
        // Implement your search logic here
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer,ProfileFragment.newInstance(query))
        transaction.addToBackStack(null)
        transaction.commit()
    }
}