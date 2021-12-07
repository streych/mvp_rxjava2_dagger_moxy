package com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter.interfaces

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface IUserListPresenter : IListPresenter<UserItemView>