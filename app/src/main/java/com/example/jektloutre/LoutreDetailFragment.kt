package com.example.jektloutre


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class LoutreDetailFragment : Fragment() {

    companion object {
        private const val LOUTRE_RES_ID = "loutreResId"

        fun newInstance(loutreResId: Int): LoutreDetailFragment {
            val fragment = LoutreDetailFragment()
            val args = Bundle()
            args.putInt(LOUTRE_RES_ID, loutreResId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_loutre_detail, container, false)
        val loutreResId = arguments?.getInt(LOUTRE_RES_ID) ?: return view

        val loutre = (requireParentFragment() as LoutreListFragment).loutres[loutreResId]
        val loutreView = view.findViewById<TextView>(R.id.oneNameView)
        loutreView.text = loutre.lieu
        // liste = loutre[resId].nom .lieu .photo

        return view
    }
}