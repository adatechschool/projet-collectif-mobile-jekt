package com.example.jektloutre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Liste des objets loutres avec leurs attribues
class LoutreListFragment : Fragment(), LoutreListAdapter.OnLoutreItemClickListener {
    val loutres = listOf(
        Loutre("photo", "Loutre 1","Russia"),
        Loutre("photo", "Loutre 2","Japon"),
        Loutre("photo","Loutre 3","Canada")
    )

    /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }*/

// Création de la fonction de la création de vue
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Instruction pour gérer l'affichage de la vue (en appelant le bon layout = xml)

        val view = inflater.inflate(R.layout.loutre_list_fragment_layout, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = LoutreListAdapter(loutres, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        return view
    }

    // Instruction d'affichage des données de la loutre choisit lors du clic
    override fun onLoutreItemClick(position: Int) {
        val loutreDetailFragment = LoutreDetailFragment.newInstance(position)
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, loutreDetailFragment)
            ?.addToBackStack(null)
            ?.commit()
    }
}