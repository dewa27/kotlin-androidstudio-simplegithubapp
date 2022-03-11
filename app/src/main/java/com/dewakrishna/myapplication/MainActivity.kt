package com.dewakrishna.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dewakrishna.myapplication.databinding.ActivityMainBinding
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var rvListUser: RecyclerView
    private val generatedListUser=ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvListUser = binding.rvListUser
        showRecyclerView()
    }

    private val listUser: ArrayList<User>
        get() {
            val testListUser=ArrayList<User>()
            val dataName = resources.getStringArray(R.array.name)
            val dataUsername= resources.getStringArray(R.array.username)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val dataLocation=resources.getStringArray(R.array.location)
            val dataCompany=resources.getStringArray(R.array.company)
            val dataFollowerCount = resources.getStringArray(R.array.followers)
            val dataFollowingCount = resources.getStringArray(R.array.following)
            val dataRepositoriesCount = resources.getStringArray(R.array.repository)
            for(i in dataName.indices){
                val user = User(dataName[i],dataUsername[i], dataPhoto.getResourceId(i, -1),
                    dataLocation[i],dataCompany[i],parseInt(dataFollowerCount[i]),parseInt(dataFollowingCount[i]),parseInt(dataRepositoriesCount[i]))
                testListUser.add(user)
            }
            return testListUser
        }
    private fun showRecyclerView(){
        generatedListUser.addAll(listUser)
        rvListUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(generatedListUser)
        rvListUser.adapter = listUserAdapter
    }
}