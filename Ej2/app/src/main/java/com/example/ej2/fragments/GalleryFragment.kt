package com.example.ej2.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ej2.ImagenAdapter
import com.example.ej2.ImagenGallery
import com.example.ej2.R
import com.example.ej2.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ImagenAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configuración del RecyclerView
        binding.recyclerViewImagenes.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        // Instanciación del Adapter
        adapter = ImagenAdapter(getSampleData()) {
            // Callback para manejo adicional si es necesario
        }

        binding.recyclerViewImagenes.adapter = adapter
    }

    private fun getSampleData(): List<ImagenGallery> {
        return listOf(
            ImagenGallery(R.drawable.image1, "Imagen 1"),
            ImagenGallery(R.drawable.image2, "Imagen 2"),
            ImagenGallery(R.drawable.image3, "Imagen 3"),
            ImagenGallery(R.drawable.image4, "Imagen 4"),
            ImagenGallery(R.drawable.image5, "Imagen 5"),
            ImagenGallery(R.drawable.image6, "Imagen 6"),
            ImagenGallery(R.drawable.image7, "Imagen 7"),
            ImagenGallery(R.drawable.image8, "Imagen 8"),
            ImagenGallery(R.drawable.image9, "Imagen 9")
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
