package com.example.mvp_rxjava2_dagger_moxy.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Users(
    val login: String? = null,
    val password: String? = null
) : Parcelable
