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
import com.example.speerai.viewmodel.GithubUserListViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [FollowerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FollowerFragment() : Fragment() {
    // TODO: Rename and change types of parameters
    private var user: String? = null
    lateinit var binding: FragmentFollowerFollowingBinding
    var followerAdapter = RecyclerAdapter()
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_follower_following, container, false)
        binding.recyclerFollower.adapter=followerAdapter
        followerAdapter.setOnProductClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,ProfileFragment.newInstance(user!!))
            transaction.addToBackStack(null)
            transaction.commit()
        }
        viewModel.githubUserFollower.observe(this.requireActivity())
        {
            followerAdapter.setDataSet(it)
        }
        viewModel.getUserList(user!!)
        {
            Toast.makeText(this.requireActivity(),it.message, Toast.LENGTH_SHORT).show()
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
            FollowerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}