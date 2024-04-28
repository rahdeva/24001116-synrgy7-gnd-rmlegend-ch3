package com.rahdeva.rmlegend.alphabet

import RMLegend
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.rahdeva.rmlegend.R

class AlphabetAdapter(
    private val listRMLegend: ArrayList<RMLegend>,
    private val onItemClick: (RMLegend) -> Unit
) : RecyclerView.Adapter<AlphabetAdapter.ViewHolder>() {
    // Class Holder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val alphabet = itemView.findViewById<Button>(R.id.btn_alphabet)
    }

    // Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.alphabet_item, parent, false)
        return ViewHolder(view)
    }

    // Penentuan data yang akan ditampilkan
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.alphabet.text = listRMLegend[position].letter
        holder.alphabet.setOnClickListener{
            onItemClick(listRMLegend[position])
        }
    }

    // Banyaknya data yang akan ditampilkan
    override fun getItemCount(): Int {
        return listRMLegend.size
    }
}