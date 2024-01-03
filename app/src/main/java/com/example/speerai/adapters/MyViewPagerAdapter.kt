package com.example.speerai.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.speerai.fragments.FollowerFragment
import com.example.speerai.fragments.FollowingFragment

class MyViewPagerAdapter(fragmentActivity:FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2;
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FollowerFragment()
            1 -> FollowingFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}