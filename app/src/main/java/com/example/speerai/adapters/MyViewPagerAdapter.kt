package com.example.speerai.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.speerai.fragments.FollowerFragment
import com.example.speerai.fragments.FollowingFragment

class MyViewPagerAdapter(userName:String,fragmentActivity:FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    var user:String=userName
    override fun getItemCount(): Int {
        return 2;
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FollowerFragment.newInstance(user)
            1 -> FollowingFragment.newInstance(user)
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}