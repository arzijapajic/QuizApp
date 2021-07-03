package ba.etf.rma21.projekat

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import ba.etf.rma21.projekat.UtilTestClass.Companion.hasItemCount
import ba.etf.rma21.projekat.UtilTestClass.Companion.itemTest
import ba.etf.rma21.projekat.data.repositories.KvizRepository
import org.hamcrest.CoreMatchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.CoreMatchers.`is` as Is

@RunWith(AndroidJUnit4::class)
class MySpirala2AndroidTest {

    @get:Rule
    val intentsTestRule = IntentsTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun test1() {
        onView(withId(R.id.bottomNav)).check(matches(isDisplayed()))
        //upis jednog
        val kvizoviPrije = KvizRepository.getMyKvizes()
        val kvizoviPrijeSize = kvizoviPrije.size
        onView(withId(R.id.predmeti)).perform(click())
        onView(withId(R.id.odabirGodina)).perform(click())
        onData(allOf(Is(instanceOf(String::class.java)), Is("2"))).perform(click())
        onView(withId(R.id.odabirPredmet)).perform(click())
        onData(allOf(Is(instanceOf(String::class.java)), Is("BWT"))).perform(click())
        onView(withId(R.id.odabirGrupa)).perform(click())
        onData(allOf(Is(instanceOf(String::class.java)), Is("bwt1"))).perform(click())
        onView(withId(R.id.dodajPredmetDugme)).perform(click())
        //upis drugog
        onView(withId(R.id.predmeti)).perform(click())
        onView(withId(R.id.odabirGodina)).perform(click())
        onData(allOf(Is(instanceOf(String::class.java)), Is("3"))).perform(click())
        onView(withId(R.id.odabirPredmet)).perform(click())
        onData(allOf(Is(instanceOf(String::class.java)), Is("PJP"))).perform(click())
        onView(withId(R.id.odabirGrupa)).perform(click())
        onData(allOf(Is(instanceOf(String::class.java)), Is("pjp1"))).perform(click())
        onView(withId(R.id.dodajPredmetDugme)).perform(click())
        onView(withId(R.id.kvizovi)).perform(click())
        val kvizoviposlije = KvizRepository.getMyKvizes()
        onView(withId(R.id.listaKvizova)).check(hasItemCount(kvizoviposlije.size))
        for (kviz in kvizoviposlije) {
            itemTest(R.id.listaKvizova, kviz)
        }














    }



}