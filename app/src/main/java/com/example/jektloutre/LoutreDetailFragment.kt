package com.example.jektloutre


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/*class LoutreDetailFragment : Fragment() {

    companion object {
    }
        private const val LOUTRE_RES_ID = "loutreResId"

        fun newInstance(loutreResId: Int): LoutreDetailFragment {
            val fragment = LoutreDetailFragment()
            val args = Bundle()
            args.putInt(LOUTRE_RES_ID, loutreResId)
            fragment.arguments = args
            return fragment
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_loutre_detail, container, false)
        //val loutreResId = arguments?.getInt(LOUTRE_RES_ID) ?: return view

        //val loutre = (requireParentFragment() as LoutreListFragment).loutres[loutreResId]
        val loutreView = view.findViewById<TextView>(R.id.oneNameView)

        loutreView.text = "pouit"

        return view
    }
}
*/

class LoutreDetailFragment : Fragment() {
    companion object {
        fun newInstance(index: Int): LoutreDetailFragment {
            val fragment = LoutreDetailFragment()
            val args = Bundle().apply {
                putInt(LoutreDetailFragment.ARG_LOUTRE_INDEX, index)
            }
            fragment.arguments = args
            return fragment
        }

        const val ARG_LOUTRE_INDEX = "loutre_index"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_loutre_detail, container, false)
        val loutreView = view.findViewById<TextView>(R.id.oneNameView)
        val loutreIndex = arguments?.getInt(ARG_LOUTRE_INDEX)?: return view
        val loutre = LoutreListFragment().loutres[loutreIndex]
        loutreView.text = loutre.nom
        return view
    }
}

