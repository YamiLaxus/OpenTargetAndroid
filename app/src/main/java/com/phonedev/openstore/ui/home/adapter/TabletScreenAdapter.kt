package com.phonedev.openstore.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.phonedev.openstore.core.BaseViewHolder
import com.phonedev.openstore.data.model.TabletModel
import com.phonedev.openstore.databinding.PhoneItemViewBinding

class TabletScreenAdapter(private val tablList: List<TabletModel>): RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = PhoneItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TabletScreenViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is TabletScreenViewHolder -> holder.bind(tablList[position])
        }
    }

    override fun getItemCount(): Int = tablList.size

    private inner class TabletScreenViewHolder (
            val binding: PhoneItemViewBinding,
            val context: Context
            ): BaseViewHolder<TabletModel>(binding.root){
        override fun bind(item: TabletModel) {
            Glide.with(context).load(item.img).centerCrop().into(binding.img)
            binding.txtNombre.text = item.nombre
            binding.txtEstado.text = item.estado
            binding.txtPrecio.text = item.precio
            binding.txtDescripcion.text = item.description
            binding.txtNumeroTel.text = item.numeroTel
            binding.txtDistribuidor.text = item.distribuidor
        }

    }
}