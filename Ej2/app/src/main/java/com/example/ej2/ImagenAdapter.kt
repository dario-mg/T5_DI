package com.example.ej2

import android.view.Gravity
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView

class ImagenAdapter(
    private val imageList: List<ImagenGallery>,
    private val onItemClick: (Int) -> Unit // Callback opcional
) : RecyclerView.Adapter<ImagenAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.imagen_view, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = imageList[position]
        holder.imageCard.setImageResource(item.imagen)
        holder.textCard.text = item.nombre

        // Detectar clic largo
        holder.itemView.setOnLongClickListener { v ->
            holder.showPopupMenu(v)  // Mostrar el menú en la ubicación del toque
            true
        }
    }

    override fun getItemCount(): Int = imageList.size

    inner class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageCard: ImageView = view.findViewById(R.id.imageView)
        val textCard: TextView = view.findViewById(R.id.tvCard)

        // Método para mostrar el PopupMenu en la ubicación del toque
        fun showPopupMenu(view: View) {
            val popupMenu = PopupMenu(view.context, view)

            // Inflar el menú contextual
            val inflater: MenuInflater = popupMenu.menuInflater
            inflater.inflate(R.menu.menu_contextual, popupMenu.menu)

            // Manejar el evento de selección del menú
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.option_edit -> {
                        editarImagen()
                        true
                    }
                    R.id.option_delete -> {
                        eliminarImagen()
                        true
                    }
                    R.id.option_share -> {
                        compartirImagen()
                        true
                    }
                    else -> false
                }
            }

            // Obtener la ubicación en pantalla del View (RecyclerView o el elemento tocado)
            val location = IntArray(2)
            view.getLocationOnScreen(location)

            // Ajustar la posición del PopupMenu usando las coordenadas exactas
            popupMenu.show()

            // Opcional: ajustar el posicionamiento usando el método `setGravity` del PopupMenu si se necesita un ajuste fino
            popupMenu.gravity = Gravity.START or Gravity.TOP
        }

        private fun editarImagen() {
            // Lógica para editar la imagen
            Toast.makeText(itemView.context, "Editar imagen", Toast.LENGTH_SHORT).show()
        }

        private fun eliminarImagen() {
            // Lógica para eliminar la imagen
            Toast.makeText(itemView.context, "Eliminar imagen", Toast.LENGTH_SHORT).show()
        }

        private fun compartirImagen() {
            // Lógica para compartir la imagen
            Toast.makeText(itemView.context, "Compartir imagen", Toast.LENGTH_SHORT).show()
        }
    }
}
