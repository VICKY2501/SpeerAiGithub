package com.example.speerai.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.speerai.R
import com.example.speerai.adapters.MyViewPagerAdapter
import com.example.speerai.databinding.FragmentFollowerFollowingBinding

private const val ARG_PARAM1 = "param1"
class ViewPagerFragment : Fragment() {
    private var UserName:String?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            UserName = it.getString(ARG_PARAM1)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager: ViewPager2 = view.findViewById(R.id.viewPager)
        val adapter = MyViewPagerAdapter(UserName!!,requireActivity())
        viewPager.adapter = adapter
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FollowerFollowingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            ViewPagerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1,param1)
                }
            }
    }
}