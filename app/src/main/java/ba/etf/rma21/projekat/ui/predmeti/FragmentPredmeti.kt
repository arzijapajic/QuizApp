package ba.etf.rma21.projekat.ui.predmeti

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Grupa
import kotlinx.android.synthetic.main.fragment_predmeti.*


class FragmentPredmeti : Fragment() {

    private val viewModel: PredmetiViewModel by viewModels()

    private lateinit var callback: FragmentPredmetiCallback

    interface FragmentPredmetiCallback {
        fun onUpisan(grupa: Grupa)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            callback = activity as FragmentPredmetiCallback
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement FragmentPredmetiCallback")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_predmeti, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinnerGodina = view.findViewById<Spinner>(R.id.odabirGodina)
        val spinnerPredmet = view.findViewById<Spinner>(R.id.odabirPredmet)
        val spinnerGrupa = view.findViewById<Spinner>(R.id.odabirGrupa)


        viewModel.godine.observe(viewLifecycleOwner) {
            val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_dropdown_item, it)
            spinnerGodina.adapter = adapter
        }

        viewModel.predmeti.observe(viewLifecycleOwner) {
            val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_dropdown_item, it)
            spinnerPredmet.adapter = adapter
        }

        viewModel.grupe.observe(viewLifecycleOwner) {
            val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_dropdown_item, it)
            spinnerGrupa.adapter = adapter
        }
        spinnerGodina.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapter: AdapterView<*>?, p1: View?, pozicija: Int, p3: Long) {
                val item = adapter?.getItemAtPosition(pozicija)
                Toast.makeText(requireContext(), item.toString(), Toast.LENGTH_SHORT).show()
                viewModel.odaberiGodinu(pozicija + 1)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
        spinnerPredmet.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapter: AdapterView<*>?, p1: View?, i: Int, p3: Long) {
                val item = adapter?.getItemAtPosition(i)
                Toast.makeText(requireContext(), item.toString(), Toast.LENGTH_SHORT).show()
                viewModel.odaberiPredmet(item.toString())
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        dodajPredmetDugme.setOnClickListener {
            val grupa = Grupa(id,spinnerGrupa.selectedItem.toString(), spinnerPredmet.selectedItem.toString())
            viewModel.upisiNaGrupu(grupa)

        }
        viewModel.onUpisan.observe(viewLifecycleOwner) {
            callback.onUpisan(it)
        }
    }
}