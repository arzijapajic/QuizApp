package ba.etf.rma21.projekat.ui.pitanje

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import ba.etf.rma21.projekat.R

class OdgovoriAdapter(
    context: Context,
    odgovori: Array<String>,
    val tacanOdgovor: Int,
    val callback: (odgovor: Int) -> Unit
) : ArrayAdapter<String>(context, 0, odgovori) {
    var nasOdgovor :Int? = null
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get the data item for this position
        var view: View? = convertView
        val odgovorText = getItem(position)
        // Check if an existing view is being reused, otherwise inflate the view
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_odgovor, parent, false)
        }
        view?.tag = position
        // Lookup view for data population
        val odgovor = view?.findViewById(R.id.odgovor) as TextView
        // Populate the data into the template view using the data object
        odgovor.text = odgovorText
        // Return the completed view to render on screen
        if (nasOdgovor == null) {
            view.setOnClickListener {
                val pozicija = it.tag as Int
                nasOdgovor = pozicija
                notifyDataSetChanged()
                callback(pozicija)
            }
        } else {
            view.isEnabled = false
            if (tacanOdgovor == position) {
                view.setBackgroundColor(ContextCompat.getColor(context, R.color.zelena))
            } else if (position == nasOdgovor) {
                view.setBackgroundColor(ContextCompat.getColor(context, R.color.crvena));
            }
        }
        return view
    }

}