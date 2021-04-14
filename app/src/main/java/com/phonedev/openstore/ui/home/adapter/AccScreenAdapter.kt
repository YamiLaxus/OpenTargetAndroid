package com.phonedev.openstore.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.phonedev.openstore.core.BaseViewHolder
import com.phonedev.openstore.data.model.AccModel
import com.phonedev.openstore.databinding.PhoneItemViewBinding

class AccScreenAdapter(private val accList: List<AccModel>, private val itemClickListener: accOnClickListener) :
        RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface accOnClickListener{
            fun onCellClickListener(data: Any)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
                PhoneItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
         return AccScreenViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is AccScreenViewHolder -> holder.bind(accList[position])
        }
    }

    override fun getItemCount(): Int = accList.size

    private inner class AccScreenViewHolder(
            val binding: PhoneItemViewBinding,
            val context: Context
    ) : BaseViewHolder<AccModel>(binding.root) {
        override fun bind(item: AccModel) {

            itemView.setOnClickListener { itemClickListener.onCellClickListener(item.img) }

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