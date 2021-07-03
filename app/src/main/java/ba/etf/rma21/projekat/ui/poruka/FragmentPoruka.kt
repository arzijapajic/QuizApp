package ba.etf.rma21.projekat.ui.poruka

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.navigation.fragment.navArgs
import ba.etf.rma21.projekat.R
import kotlinx.android.synthetic.main.fragment_poruka.*

class FragmentPoruka : Fragment() {
    private var text: String? = null
    val args by navArgs<FragmentPorukaArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            text = it.getString(TEXT)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvPoruka.text = text.toString()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poruka, container, false)
    }

    companion object {
        private const val TEXT = "text"

        @JvmStatic
        fun newInstance(text: String) =
            FragmentPoruka().apply {
                arguments = Bundle().apply {
                    putString(TEXT, text)
                }
            }
    }
}