package ba.etf.rma21.projekat.ui.kvizovi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.models.KvizStatus
import ba.etf.rma21.projekat.data.models.Pitanje
import java.text.SimpleDateFormat
import java.util.*


class KvizAdapter(val onItemClicked: (kviz: Kviz) -> Unit) : RecyclerView.Adapter<KvizAdapter.KvizViewHolder>() {

    var kvizovi = listOf<Kviz>()

    inner class KvizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nazivPredmenta = itemView.findViewById<TextView>(R.id.naziv_predmenta)
        private val naslovKviza = itemView.findViewById<TextView>(R.id.naslov_kviza)
        private val datumKviza = itemView.findViewById<TextView>(R.id.datum_kviza)
        private val brojBodova = itemView.findViewById<TextView>(R.id.broj_bodova)
        private val statusImage = itemView.findViewById<ImageView>(R.id.status_image)

        fun bind(kviz: Kviz) {
            itemView.setOnClickListener {
                onItemClicked(kviz)
            }
            nazivPredmenta.text = kviz.nazivPredmeta
            naslovKviza.text = kviz.naziv
            brojBodova.text = kviz.osvojeniBodovi.toString()
            when (kviz.kvizStatus) {
                KvizStatus.DONE -> {
                    statusImage.setImageResource(R.drawable.plava)
                    datumKviza.text = kviz.datumRada?.let { formatDate(it) }
                }
                KvizStatus.NOT_DONE -> {
                    statusImage.setImageResource(R.drawable.crvena)
                    datumKviza.text = formatDate(kviz.datumKraj)
                }
                KvizStatus.ACTIVE -> {
                    statusImage.setImageResource(R.drawable.zelena)
                    datumKviza.text = formatDate(kviz.datumKraj)
                }
                KvizStatus.NOT_ACTIVE -> {
                    statusImage.setImageResource(R.drawable.zuta)
                    datumKviza.text = formatDate(kviz.datumPocetka)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KvizViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_kviz, parent, false)
        return KvizViewHolder(view)
    }

    override fun onBindViewHolder(holder: KvizViewHolder, position: Int) {
        holder.bind(kvizovi[position])
    }

    override fun getItemCount(): Int {
        return kvizovi.size
    }

    private fun formatDate(date: Date): String {
        val df = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        return df.format(date)
    }
}