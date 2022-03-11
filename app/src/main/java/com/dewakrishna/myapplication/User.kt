package com.dewakrishna.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var name:String,
    var username:String,
    var photo:Int,
    var location:String,
    var company:String,
    var followerCount:Int,
    var followingCount:Int,
    var repositoriesCount:Int
): Parcelable
