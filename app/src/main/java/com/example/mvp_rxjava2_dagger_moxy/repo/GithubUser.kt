package com.example.mvp_rxjava2_dagger_moxy.repo

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "GitHubUserTable")
data class GithubUser(

    @PrimaryKey
    @ColumnInfo
    @SerializedName("id")
    @Expose
    val id: String = "",

    @ColumnInfo
    @SerializedName("login")
    @Expose
    val login: String? = null,

    @ColumnInfo
    @SerializedName("avatarUrl")
    @Expose
    val avatarUrl: String? = null,

    @ColumnInfo
    @SerializedName("node_id")
    @Expose
    val node_id: String? = null,

    @ColumnInfo
    @SerializedName("html_url")
    @Expose
    val html_url: String? = null


): Parcelable
