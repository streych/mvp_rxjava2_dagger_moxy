package com.example.mvp_rxjava2_dagger_moxy.recycler_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp_rxjava2_dagger_moxy.databinding.GitUsersItemBinding
import com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter.interfaces.IUserListPresenter
import com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter.interfaces.UserItemView

class UsersRVAdapter(val presenter: IUserListPresenter) :
    RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: GitUsersItemBinding) : RecyclerView.ViewHolder(binding.root),
        UserItemView {
        override fun setLogin(text: String) { binding.tvLogin.text = text }

        override var pos = -1

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(GitUsersItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            .apply { itemView.setOnClickListener {
                //Для вызова itemClickListener используется функция invoke(), так как он может быть равен null.
                //presenter.itemClickListener?.invoke(holder)
                presenter.itemClickListener?.invoke(this)
            } }

    override fun onBindViewHolder(holder: UsersRVAdapter.ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    override fun getItemCount() = presenter.getCount()
}