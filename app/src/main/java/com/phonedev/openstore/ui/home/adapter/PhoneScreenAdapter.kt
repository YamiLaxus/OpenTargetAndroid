package com.phonedev.openstore.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.phonedev.openstore.core.BaseViewHolder
import com.phonedev.openstore.data.model.PhoneModel
import com.phonedev.openstore.databinding.PhoneItemViewBinding

class PhoneScreenAdapter(private val phoneList: List<PhoneModel>): RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = PhoneItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhoneScreenViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is PhoneScreenViewHolder -> holder.bind(phoneList[position])
        }
    }

    override fun getItemCount(): Int = phoneList.size

    private inner class PhoneScreenViewHolder(
        val binding: PhoneItemViewBinding,
        val context: Context
    ): BaseViewHolder<PhoneModel>(binding.root){
        override fun bind(item: PhoneModel) {
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