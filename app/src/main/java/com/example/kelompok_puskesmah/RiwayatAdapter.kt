package com.example.kelompok_puskesmah

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RiwayatAdapter(private val riwayatList: List<RiwayatData>) :
    RecyclerView.Adapter<RiwayatAdapter.RiwayatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_riwayat, parent, false)
        return RiwayatViewHolder(view)
    }

    override fun onBindViewHolder(holder: RiwayatViewHolder, position: Int) {
        val data = riwayatList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = riwayatList.size

    class RiwayatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvPoli: TextView = itemView.findViewById(R.id.tvPoli)
        private val tvLokasi: TextView = itemView.findViewById(R.id.tvLokasi)
        private val tvJam: TextView = itemView.findViewById(R.id.tvJam)
        private val tvTanggal: TextView = itemView.findViewById(R.id.tvTanggal)
        private val tvDokter: TextView = itemView.findViewById(R.id.tvDokter)

        fun bind(data: RiwayatData) {
            tvPoli.text = data.poli
            tvLokasi.text = data.lokasi
            tvJam.text = "Jam: ${data.jam}"
            tvTanggal.text = "Tanggal: ${data.tanggal}"
            tvDokter.text = "Dokter: ${data.dokter}"
        }
    }
}
