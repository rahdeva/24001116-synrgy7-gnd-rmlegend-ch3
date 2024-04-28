package com.rahdeva.rmlegend.legends

import RMLegend
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahdeva.rmlegend.databinding.FragmentLegendsBinding

class LegendsFragment : Fragment() {
    private lateinit var binding: FragmentLegendsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLegendsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rmLegend = arguments?.getParcelable<RMLegend>(LegendsFragment.ARG_RMLEGEND)

        val adapter = LegendAdapter(rmLegend ?: RMLegend(letter = "A", legends = arrayOf(""))) {
            item -> searchLegend(item)
        }

        binding.legendRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.legendRecyclerview.adapter = adapter
    }

    private fun searchLegend(name: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("https://www.google.com/search?q=$name"))
        startActivity(intent)
    }

    companion object {
        const val ARG_RMLEGEND = "arg_rmlegend"

        fun newInstance(rmLegend: RMLegend): LegendsFragment {
            val fragment = LegendsFragment()
            val args = Bundle()
            args.putParcelable(ARG_RMLEGEND, rmLegend)
            fragment.arguments = args
            return fragment
        }
    }
}
