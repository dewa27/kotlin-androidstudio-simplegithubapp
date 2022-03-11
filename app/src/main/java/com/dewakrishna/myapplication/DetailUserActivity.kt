package com.dewakrishna.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import com.dewakrishna.myapplication.databinding.ActivityDetailUserBinding
import com.dewakrishna.myapplication.databinding.ActivityMainBinding

class DetailUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUserBinding
    companion object {
        const val EXTRA_USER = "extra_user"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        binding.tvDetailName.text=user.name
        binding.tvDetailUsername.text=user.username
        binding.tvDetailCompany.text=user.company
        binding.tvDetailLocation.text=user.location
        binding.civProfileImage.setImageResource(user.photo)
        binding.tvDetailFollowerCount.text=user.followerCount.toString()
        binding.tvDetailFollowingCount.text=user.followingCount.toString()
        binding.tvDetailRepositoriesCount.text=user.repositoriesCount.toString()
    }
}