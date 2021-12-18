package com.example.mvp_rxjava2_dagger_moxy.repo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    var login: String? = null
): Parcelable
