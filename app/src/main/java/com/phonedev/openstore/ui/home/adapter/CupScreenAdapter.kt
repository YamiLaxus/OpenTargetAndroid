package com.phonedev.openstore.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.phonedev.openstore.core.BaseViewHolder
import com.phonedev.openstore.data.model.CupModel
import com.phonedev.openstore.databinding.PhoneItemViewBinding
import java.util.*

class CupScreenAdapter(private val cupList: List<CupModel>) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = PhoneItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CupScreenViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is CupScreenViewHolder -> holder.bind(cupList[position])
        }
    }

    override fun getItemCount(): Int = cupList.size

    private inner class CupScreenViewHolder(
            val binding: PhoneItemViewBinding,
            val context: Context
    ) : BaseViewHolder<CupModel>(binding.root){
        override fun bind(item: CupModel) {

            Glide.with(context).load(item.img).centerCrop().into(binding.img)
            binding.txtNombre.text = item.nombre
            binding.txtEstado.text = item.tipo
            binding.txtPrecio.text = item.precio
            binding.txtDescripcion.text = item.description
            binding.txtNumeroTel.text = item.numeroTel
            binding.txtDistribuidor.text = item.distribuidor
        }

    }
}