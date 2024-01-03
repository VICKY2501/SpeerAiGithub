package com.example.speerai.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.speerai.R
import com.example.speerai.adapters.MyViewPagerAdapter
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
        val searchView:SearchView=view.findViewById(R.id.search_bar)
        setupSearchView(searchView)
    }
    private fun setupSearchView(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Perform search or any other action when the user submits the query
                if (!query.isNullOrBlank()) {
                    performSearch(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Perform filtering or any other action as the text changes
                // This method is called whenever the user types something in the search input field
                return true
            }
        })
    }

    private fun performSearch(query: String) {
        // Implement your search logic here
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer,ProfileFragment.newInstance(query))
        transaction.addToBackStack(null)
        transaction.commit()
    }
}