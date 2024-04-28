package com.rahdeva.rmlegend.legends

import RMLegend
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.rahdeva.rmlegend.R

class LegendAdapter(
    private val rmLegend: RMLegend,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<LegendAdapter.ViewHolder>() {
    // Class Holder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val legends = itemView.findViewById<Button>(R.id.btn_legend)
    }

    // Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.legend_item, parent, false)
        return ViewHolder(view)
    }

    // Penentuan data yang akan ditampilkan
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.legends.text = rmLegend.legends[position]
        holder.legends.setOnClickListener{
            onItemClick(rmLegend.legends[position])
        }
    }

    // Banyaknya data yang akan ditampilkan
    override fun getItemCount(): Int {
        return rmLegend.legends.size
    }
}