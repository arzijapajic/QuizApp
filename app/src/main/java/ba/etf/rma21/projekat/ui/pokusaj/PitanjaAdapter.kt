package ba.etf.rma21.projekat.ui.pokusaj

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Pitanje

class PitanjaAdapter(val onItemClick: (position: Int) -> Unit) : RecyclerView.Adapter<PitanjaAdapter.PitanjeViewHolder>() {

    var pitanja = listOf<Pitanje>()
    var selected = -1

    inner class PitanjeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val indexPitanja = itemView.findViewById<TextView>(R.id.index_pitanja)
        private val backGround = itemView.findViewById<View>(R.id.pitanjeBackground)
        fun bind(position: Int) {
            itemView.setOnClickListener {
                selected = position
                onItemClick(position)
            }
            if (pitanja[position].odgovor == null) {
                backGround.setBackgroundColor(ContextCompat.getColor(itemView.context, android.R.color.black))
                indexPitanja.setTextColor(ContextCompat.getColor(itemView.context, android.R.color.white))
            } else {
                if (pitanja[position].odgovor == pitanja[position].tacan) {
                    backGround.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.zelena));
                } else {
                    backGround.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.crvena));
                }
                indexPitanja.setTextColor(ContextCompat.getColor(itemView.context, android.R.color.black))
            }
            indexPitanja.text = "Pitanja ${position}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PitanjeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pitanje, parent, false)
        return PitanjeViewHolder(view)
    }

    override fun onBindViewHolder(holder: PitanjeViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return pitanja.size

    }
}