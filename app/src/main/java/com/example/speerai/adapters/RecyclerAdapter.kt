package com.example.speerai.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.speerai.databinding.ItemLayoutBinding
import com.example.speerai.dataclass.GithubDataClass

class RecyclerAdapter:RecyclerView.Adapter<RecyclerAdapter.GithubViewHolder>(){
    private var GithubUserList = ArrayList<GithubDataClass>()

    private var onProductClickListener: ((GithubDataClass) -> Unit)? = null
    fun setDataSet(productList : ArrayList<GithubDataClass>) {
        this.GithubUserList = productList
        notifyDataSetChanged()
    }

    fun setOnProductClickListener(onProductClickListener: ((GithubDataClass) -> Unit)?) {
        this.onProductClickListener= onProductClickListener
    }

    inner class GithubViewHolder(var binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(GithubUser: GithubDataClass) {
            binding.githubdata=GithubUser
            binding.root.setOnClickListener {
                onProductClickListener?.invoke(GithubUser)
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter.GithubViewHolder {
        return GithubViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.GithubViewHolder, position: Int) {
        holder.bind(GithubUserList[position])
    }

    override fun getItemCount(): Int {
        return GithubUserList.size
    }
}