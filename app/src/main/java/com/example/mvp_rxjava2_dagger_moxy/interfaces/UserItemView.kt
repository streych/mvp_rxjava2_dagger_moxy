package com.example.mvp_rxjava2_dagger_moxy.interfaces

interface UserItemView : IItemView {
    fun setLogin(text: String)
    fun loadAvatar(url: String)
}