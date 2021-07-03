package ba.etf.rma21.projekat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.models.Pitanje
import ba.etf.rma21.projekat.data.repositories.PitanjeKvizRepository
import ba.etf.rma21.projekat.ui.kvizovi.FragmentKvizovi
import ba.etf.rma21.projekat.ui.kvizovi.FragmentKvizoviDirections
import ba.etf.rma21.projekat.ui.pokusaj.FragmentPokusaj
import ba.etf.rma21.projekat.ui.predmeti.FragmentPredmeti
import ba.etf.rma21.projekat.ui.predmeti.FragmentPredmetiDirections
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), FragmentPredmeti.FragmentPredmetiCallback, FragmentKvizovi.FragmentKvizoviCallback {

    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        bottomNav.setupWithNavController(navController)
        bottomNav.menu.findItem(R.id.predajKviz).setOnMenuItemClickListener {
            val fragment = navHostFragment.childFragmentManager.fragments.firstOrNull {
                it.javaClass == FragmentPokusaj::class.java && it.isVisible
            } as? FragmentPokusaj
            fragment?.predajKviz()
            return@setOnMenuItemClickListener true
        }
        bottomNav.menu.findItem(R.id.zaustaviKviz).setOnMenuItemClickListener {
            bottomNav.menu.setGroupVisible(R.id.group1, true)
            bottomNav.menu.setGroupVisible(R.id.group2, false)
            navController.popBackStack()
            return@setOnMenuItemClickListener true
        }
    }

    override fun onUpisan(grupa: Grupa) {
        navController.navigate(FragmentPredmetiDirections.actionFragmentPredmetiToFragmentPoruka( "Uspješno ste upisani u grupu ${grupa.naziv} predmeta ${grupa.nazivPredmeta}!."))
    }

    override fun onKvizClicked(kviz: Kviz) {
        bottomNav.menu.setGroupVisible(R.id.group1, false)
        bottomNav.menu.setGroupVisible(R.id.group2, true)
        lifecycleScope.launchWhenStarted {
            val pitanja = PitanjeKvizRepository.getPitanja(kviz.id).map { Pitanje(
                it.naziv,
                it.tekstPitanja,
                it.opcije,
                it.tacan
            ) }
            navController.navigate(
                FragmentKvizoviDirections.actionNavKvizoviToFragmentPokusaj(
                    pitanja.toTypedArray()
                )
            )
            // Zapoceti kviz
        }
    }
}

