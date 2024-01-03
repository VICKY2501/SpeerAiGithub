package com.example.speerai.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.speerai.R
import com.example.speerai.adapters.RecyclerAdapter
import com.example.speerai.databinding.FragmentFollowerFollowingBinding
import com.example.speerai.databinding.FragmentFollowingBinding
import com.example.speerai.viewmodel.GithubUserListViewModel
import com.example.speerai.viewmodel.GithubUserViewModel

private const val ARG_PARAM1 = "param1"
class FollowingFragment() : Fragment() {

    var user:String?=null
    var followingAdapter=RecyclerAdapter()
    lateinit var binding: FragmentFollowingBinding
    private val viewModel: GithubUserListViewModel by lazy {
        ViewModelProvider(this).get(GithubUserListViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            user = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_following, container, false)

        binding.recyclerFollowing.adapter=followingAdapter
        followingAdapter.setOnProductClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,ProfileFragment.newInstance(user!!))
            transaction.addToBackStack(null)
            transaction.commit()
        }
        viewModel.githubUserFollowing.observe(this.requireActivity())
        {
            followingAdapter.setDataSet(it)
        }
        viewModel.getUserList(user!!)
        {
            Toast.makeText(this.requireActivity(),it.message,Toast.LENGTH_SHORT).show()
        }
        return binding.root
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
            FollowingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}