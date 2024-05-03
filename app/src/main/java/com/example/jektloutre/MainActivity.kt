package com.example.jektloutre


import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Méthode onCreate est appelée lorsque l'activité commence à exister. C'est ici que vous initialisez votre activité.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Définir le layout principal de l'activité
        setContentView(R.layout.activity_main)
        // Commencer une transaction de fragment
        supportFragmentManager.beginTransaction()
            // Remplacer le fragment actuel dans le conteneur par un nouveau fragment LoutreListFragment
            .replace(R.id.fragment_container, LoutreListFragment())
            // Valider la transaction pour qu'elle soit appliquée
            .commit()

        /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button = findViewById<Button>(R.id.show_profile)
        button.setOnClickListener { startActivity(Intent(applicationContext,LoutreFragment::class.java))
        }*/
    }

}