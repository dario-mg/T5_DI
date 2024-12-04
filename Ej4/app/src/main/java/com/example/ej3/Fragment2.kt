package com.example.ej3
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ej2.ImagenGallery
import android.widget.PopupMenu

class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerViewImagenes)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = ImagenAdapter(getSampleData()) { itemView, position ->
            showPopupMenu(itemView, position)
        }
    }

    private fun getSampleData(): List<ImagenGallery> {
        return listOf(
            ImagenGallery(R.drawable.image1),
            ImagenGallery(R.drawable.image2),
            ImagenGallery(R.drawable.image3),
            ImagenGallery(R.drawable.image4),
            ImagenGallery(R.drawable.image5),
            ImagenGallery(R.drawable.image6),
            ImagenGallery(R.drawable.image7),
            ImagenGallery(R.drawable.image8),
            ImagenGallery(R.drawable.image9)
        )
    }

    private fun showPopupMenu(view: View, position: Int) {
        val popupMenu = PopupMenu(requireContext(), view)
        popupMenu.menuInflater.inflate(R.menu.menu_contextual, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.option_share -> {
                    Toast.makeText(requireContext(), "Compartir imagen $position", Toast.LENGTH_SHORT).show()
                }
                R.id.option_delete -> {
                    Toast.makeText(requireContext(), "Eliminar imagen $position", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

        popupMenu.show()
    }
}
