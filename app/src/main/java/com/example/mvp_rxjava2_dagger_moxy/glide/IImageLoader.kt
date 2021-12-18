package com.example.mvp_rxjava2_dagger_moxy.glide

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}