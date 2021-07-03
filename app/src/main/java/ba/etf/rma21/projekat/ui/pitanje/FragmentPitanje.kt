package ba.etf.rma21.projekat.ui.pitanje

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Pitanje
import kotlinx.android.synthetic.main.fragment_pitanje.*


class FragmentPitanje(val pitanje: Pitanje, val callback: (odgovor: Int) -> Unit) : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tekstPitanja.text = pitanje.tekstPitanja
        val itemsAdapter: ArrayAdapter<String> = OdgovoriAdapter(
            requireContext(),
            pitanje.opcije.toTypedArray(),
            pitanje.tacan
        ) {
            callback(it)
        }.apply {
            nasOdgovor = pitanje.odgovor
        }

        odgovoriLista.adapter = itemsAdapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pitanje, container, false)
    }

}