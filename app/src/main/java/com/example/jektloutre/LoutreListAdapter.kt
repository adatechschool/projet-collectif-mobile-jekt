package com.example.jektloutre

// LoutreListAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//  Class parent de la liste qui va transmettre en héritage le recyclerView, l'adapter et le ViewHolder
class LoutreListAdapter(private val loutres: List<Loutre>, private val listener: OnLoutreItemClickListener) :
    RecyclerView.Adapter<LoutreListAdapter.LoutreViewHolder>() {

// Sous class de class LoutreListAdapter (class enfant) qui hérite des attributs de la classe parent et qui affiche les données définis
    inner class LoutreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val loutreNameTextView: TextView = itemView.findViewById(R.id.loutreNameTextView)

    // Va récupérer la position de la loutre séléctionnée dans la liste des loutres (dans l'array)
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onLoutreItemClick(position)
                }
            }
        }
    }

    interface OnLoutreItemClickListener {
        fun onLoutreItemClick(position: Int)
    }

    /* Déclaration de la fonction OncreatViewHolder : Sert à générer les différents éléments de la liste (etr par conséquent chaque détails de la cellule sélectionnéee).
  ViewHolder permet également de gérer la performance des vues (évite la création & destruction permanantes des vues en les stockants = équivalent d'un cookie) */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoutreViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_loutre, parent, false)
        return LoutreViewHolder(itemView)
    }

    // Permet de lier la vue et les données.
    override fun onBindViewHolder(holder: LoutreViewHolder, position: Int) {
        val currentItem = loutres[position]
        holder.loutreNameTextView.text = currentItem.nom
    }
// L'équvalent d'un .length
    override fun getItemCount() = loutres.size
}