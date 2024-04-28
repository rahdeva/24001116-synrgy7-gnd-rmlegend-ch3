package com.rahdeva.rmlegend.alphabet

import RMLegend
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahdeva.rmlegend.R
import com.rahdeva.rmlegend.databinding.FragmentAlphabetBinding
import com.rahdeva.rmlegend.legends.LegendsFragment

class AlphabetFragment : Fragment() {

    private var listRMLegend: ArrayList<RMLegend>? = null
    private lateinit var fragmentAlphabetBinding: FragmentAlphabetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentAlphabetBinding = FragmentAlphabetBinding.inflate(inflater, container, false)
        return fragmentAlphabetBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listRMLegend = arguments?.getParcelableArrayList(ARG_LIST_RMLEGEND)

        val adapter = AlphabetAdapter(listRMLegend ?: arrayListOf()) { item ->
            goToLegendsFragment(item)
        }

        fragmentAlphabetBinding.alphabetRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        fragmentAlphabetBinding.alphabetRecyclerview.adapter = adapter
    }

    private fun goToLegendsFragment(data: RMLegend) {
        val legendsFragment = LegendsFragment.newInstance(data)
        getParentFragmentManager().beginTransaction()
            .replace(R.id.alphabet_container, legendsFragment)
            .commit()
        val actionToLegendFragment = AlphabetFragmentDirections
            .actionAlphabetFragmentToLegendsFragment()
        findNavController().navigate(actionToLegendFragment)
    }

    companion object {
        const val ARG_LIST_RMLEGEND = "arg_list_rmlegend"

        fun newInstance(listRMLegend: ArrayList<RMLegend>): AlphabetFragment {
            val fragment = AlphabetFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARG_LIST_RMLEGEND, listRMLegend)
            fragment.arguments = args
            return fragment
        }
    }
}
