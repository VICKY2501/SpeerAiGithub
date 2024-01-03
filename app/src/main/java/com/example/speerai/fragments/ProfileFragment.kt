package com.example.speerai.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.speerai.R
import com.example.speerai.adapters.RecyclerAdapter
import com.example.speerai.databinding.FragmentProfileBinding
import com.example.speerai.databinding.ItemLayoutBinding
import com.example.speerai.viewmodel.GithubUserViewModel

private const val ARG_PARAM1 = "param1"
class ProfileFragment : Fragment() {
    private var UserName:String?=null
    private var profileLink:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            UserName = it.getString(ARG_PARAM1)
        }
    }
    private val viewModel: GithubUserViewModel by lazy {
        ViewModelProvider(this).get(GithubUserViewModel::class.java)
    }
    lateinit var binding:FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        viewModel.githubUser.observe(this.requireActivity()){
           binding.githubProfile=it
            profileLink=it.html_url
        }
        viewModel.getProducts(UserName!!) {
          Toast.makeText(this.requireActivity(),it.message,Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.followerCountTextView.setOnClickListener{
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,ViewPagerFragment.newInstance(UserName.toString()))
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.followingCountTextView.setOnClickListener{
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,ViewPagerFragment.newInstance(UserName.toString()))
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.ProfileLink.setOnClickListener{
            if(profileLink!=null)
            openWebBrowser(profileLink!!)
            else
                Toast.makeText(this.requireActivity(),"Link is Invalid",Toast.LENGTH_SHORT).show()
        }
    }
    private fun openWebBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        } else {
            // Handle the case where the web browser app is not installed
            Toast.makeText(this.requireActivity(), "Web browser not found", Toast.LENGTH_SHORT).show()
        }
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
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1,param1)
                }
            }
    }
}