package ba.etf.rma21.projekat.ui.kvizovi

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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Kviz

class FragmentKvizovi : Fragment() {

    private lateinit var callback: FragmentKvizoviCallback
    private val adapter: KvizAdapter by lazy {
        return@lazy KvizAdapter{ kviz ->
            callback.onKvizClicked(kviz)
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            callback = activity as FragmentKvizoviCallback
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement FragmentKvizoviCallback")
        }
    }
    interface FragmentKvizoviCallback {
        fun onKvizClicked(kviz: Kviz)
    }

    private lateinit var spinner: Spinner
    private val viewModel: KvizoviViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kvizovi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spinner = view.findViewById(R.id.filterKvizova)!!
        setupSpinner()
        setupRecyclerView()
        viewModel.kvizovi.observe(viewLifecycleOwner) { listaKvizova ->
            adapter.kvizovi = listaKvizova
            adapter.notifyDataSetChanged()
        }
    }


    private fun setupSpinner() {
        val spinnerAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.kviz_filters,
            android.R.layout.simple_spinner_item
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapter: AdapterView<*>?, p1: View?, i: Int, p3: Long) {
                val item = adapter?.getItemAtPosition(i)
                Toast.makeText(requireContext(), item.toString(), Toast.LENGTH_SHORT).show()
                setFilterType(i)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        spinner.setSelection(0)
    }

    override fun onStart() {
        super.onStart()
        spinner.setSelection(0)
    }


    private fun setupRecyclerView() {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.listaKvizova)!!
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun setFilterType(positon: Int) {
        when (positon) {
            0 -> viewModel.setFilterType(KvizoviViewModel.FilterType.SVI_MOJI_KVIZOVI)
            1 -> viewModel.setFilterType(KvizoviViewModel.FilterType.SVI_KVIZOVI)
            2 -> viewModel.setFilterType(KvizoviViewModel.FilterType.URADENI_KVIZOVI)
            3 -> viewModel.setFilterType(KvizoviViewModel.FilterType.BUDUCI_KVIZOVI)
            4 -> viewModel.setFilterType(KvizoviViewModel.FilterType.PROSLI_KVIZOVI)
        }
    }
}