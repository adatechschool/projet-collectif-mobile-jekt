package com.example.jektloutre


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Méthode onCreate est appelée lorsque l'activité commence à exister. C'est ici que vous initialisez votre activité.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Vérifier si c'est la première ouverture de l'application
        if (isFirstTimeLaunch()) {
            // Si c'est la première fois, charger le fragment HomeFragment
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        } else {
            // Si ce n'est pas la première fois, charger directement le fragment LoutreListFragment
            loadLoutreListFragment()
        }
    }

    private fun isFirstTimeLaunch(): Boolean {
        return true
    }

    private fun loadLoutreListFragment() {
        // Charger le fragment LoutreListFragment dans le conteneur
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, LoutreListFragment())
            .commit()
    }

        /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button = findViewById<Button>(R.id.show_profile)
        button.setOnClickListener { startActivity(Intent(applicationContext,LoutreFragment::class.java))
        }*/
}

