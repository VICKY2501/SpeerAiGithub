package com.example.speerai.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.speerai.R
import com.example.speerai.adapters.RecyclerAdapter
import com.example.speerai.databinding.ItemLayoutBinding
import com.example.speerai.viewmodel.GithubUserViewModel

private const val ARG_PARAM1 = "param1"
class ProfileFragment : Fragment() {

    private var UserName:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            UserName = it.getString(ARG_PARAM1)
        }
    }
    private val viewModel: GithubUserViewModel by lazy {
        ViewModelProvider(this).get(GithubUserViewModel::class.java)
    }
    lateinit var binding:ItemLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.setContentView(this.requireActivity(),R.layout.fragment_profile)
        viewModel.getProducts {  }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
                    putString(ARG_PARAM1,param1)
                }
            }
    }
}