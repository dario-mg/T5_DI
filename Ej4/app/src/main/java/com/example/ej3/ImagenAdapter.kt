package com.example.ej3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ej2.ImagenGallery

class ImagenAdapter(
    private val cardList: List<ImagenGallery>,
    private val onLongClick: (View, Int) -> Unit
) : RecyclerView.Adapter<ImagenAdapter.CardViewHolder>() {

    inner class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageCard: ImageView = view.findViewById(R.id.imageView)

        init {
            view.setOnLongClickListener {
                onLongClick(view, adapterPosition)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.imagen_view, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cardList[position]
        holder.imageCard.setImageResource(card.getImagen())
    }

    override fun getItemCount(): Int = cardList.size
}
