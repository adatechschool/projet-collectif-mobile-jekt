package com.example.jektloutre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Liste des objets loutres avec leurs attribues
class LoutreListFragment : Fragment(), LoutreListAdapter.OnLoutreItemClickListener {
    private val loutres = listOf(
        Loutre("toto", "Loutre 1","titi"),
        Loutre("toto", "Loutre 2","titi"),
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
    override fun onLoutreItemClick(position: Int) {/*
        val loutre = loutres[position]
        val detail = DetailNiqueNique.newInstance(loutre)*/
        TODO("Not yet implemented")
    }
}