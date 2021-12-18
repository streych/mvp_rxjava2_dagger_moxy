package com.example.mvp_rxjava2_dagger_moxy.repo

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    @Expose val id: String? = null,
    @Expose val login: String? = null,
    @Expose val avatarUrl: String? = null,
    @Expose val node_id: String? = null,
    @Expose val html_url: String? = null
): Parcelable
