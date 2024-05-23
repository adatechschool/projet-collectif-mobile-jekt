package com.example.jektloutre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val textView = view.findViewById<TextView>(R.id.test)
        val apiService = ApiService()
        val url = "http://192.168.7.178:8080" //ip wifi de son ordi à modifier en fonction du poste

        Thread {
            val result = apiService.fetchData(url)
            val activity = activity?: return@Thread // Correction ici
            activity.runOnUiThread {
                textView.text = result
            }
        }.start()
        // Trouver le bouton ou l'élément pour passer à la liste des loutres
        val goToLoutreListButton = view.findViewById<Button>(R.id.goToLoutreListButton)
        goToLoutreListButton.setOnClickListener {
            // L'utilisateur a appuyé sur le bouton, donc on passe à la liste des loutres
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoutreListFragment())
                .commit()
        }

        return view
    }
}