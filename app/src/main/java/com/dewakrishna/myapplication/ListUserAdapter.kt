package com.dewakrishna.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.dewakrishna.myapplication.databinding.ItemListUserBinding
import de.hdodenhof.circleimageview.CircleImageView

class ListUserAdapter(private val listUser: ArrayList<User>): RecyclerView.Adapter<ListUserAdapter.ListUserViewHolder>() {
    class ListUserViewHolder(private val binding : ItemListUserBinding) : RecyclerView.ViewHolder(binding.root) {
        val civProfileImage:CircleImageView=binding.civProfileImage
        val tvName:TextView=binding.tvName
        val tvUsername:TextView=binding.tvUsername
        val cardView:CardView=binding.cardView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserViewHolder {
        val binding = ItemListUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListUserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListUserViewHolder, position: Int) {
//        val (name,username,photo,followerCount,followingCount,repositoriesCount) = listUser
        val user=listUser[position]
        val ctx=holder.tvName.context

        holder.civProfileImage.setImageResource(user.photo)
        holder.tvName.text = user.name
        holder.tvUsername.text = user.username
        holder.cardView.setOnClickListener(View.OnClickListener {
            val detailUserIntent = Intent(ctx,DetailUserActivity::class.java)
            detailUserIntent.putExtra(DetailUserActivity.EXTRA_USER, user)
            ctx.startActivity(detailUserIntent)
        })
    }

    override fun getItemCount(): Int {
        return listUser.size
    }
}