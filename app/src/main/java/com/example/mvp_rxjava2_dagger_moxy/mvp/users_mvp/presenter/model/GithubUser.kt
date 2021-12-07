package com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    var login: String
): Parcelable
