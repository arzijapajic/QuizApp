package ba.etf.rma21.projekat.ui.pokusaj

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.GravityCompat
import androidx.fragment.app.commit
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Pitanje
import ba.etf.rma21.projekat.ui.pitanje.FragmentPitanje
import ba.etf.rma21.projekat.ui.poruka.FragmentPoruka
import kotlinx.android.synthetic.main.fragment_pokusaj.*
import kotlin.math.round
import kotlin.math.roundToInt

class FragmentPokusaj : Fragment() {

    private val args: FragmentPokusajArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {

                }
            }
        )
        val mPitanja = args.pitanja
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
        recycler_view.adapter = PitanjaAdapter { pozicija ->
            childFragmentManager.commit {
                replace(R.id.framePitanje,
                    FragmentPitanje(args.pitanja[pozicija]) { odgovor ->
                        // Pozovi Odgovor repozitori i odgovori na pitanje
                        mPitanja[pozicija].odgovor = odgovor
                        recycler_view.adapter?.notifyDataSetChanged()
                    }
                )
            }
        }.apply { pitanja = mPitanja.toList() }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokusaj, container, false)
    }

    fun predajKviz() {
        val kviz = args.pitanja.firstOrNull()?.nazivKviza ?: ""
        rezultat.visibility = View.VISIBLE
        rezultat.setOnClickListener {
            childFragmentManager.commit {
                childFragmentManager.commit {
                    replace(R.id.framePitanje, FragmentPoruka.newInstance("Završili ste kviz ${kviz} sa tačnosti ${dajTacnost()}%"))
                }
            }
        }
        childFragmentManager.commit {
            childFragmentManager.commit {
                replace(R.id.framePitanje, FragmentPoruka.newInstance("Završili ste kviz ${kviz} sa tačnosti ${dajTacnost()}%"))
            }
        }
    }

    private fun dajTacnost(): Double {
        val brojTacni = args.pitanja.filter { it.odgovor == it.tacan }.size
        return round(brojTacni / args.pitanja.size.toDouble() * 100)
    }
}