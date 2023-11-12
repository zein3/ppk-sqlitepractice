package com.polstat.sqlitepractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MahasiswaRVAdapter(
    val mahasiswaModalList: List<MahasiswaModal>,
    context: Context
) : RecyclerView.Adapter<MahasiswaRVAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nimTV: TextView
        var namaTV: TextView
        var kelasTV: TextView
        var nohpTV: TextView

        init {
            nimTV = itemView.findViewById(R.id.nimTextView)
            namaTV = itemView.findViewById(R.id.namaTextView)
            kelasTV = itemView.findViewById(R.id.kelasTextView)
            nohpTV = itemView.findViewById(R.id.nohpTextView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mahasiswa_rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mahasiswaModalList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modal = mahasiswaModalList[position]
        holder.nimTV.text = modal.nim
        holder.namaTV.text = modal.nama
        holder.kelasTV.text = modal.kelas
        holder.nohpTV.text = modal.nohp
    }

}