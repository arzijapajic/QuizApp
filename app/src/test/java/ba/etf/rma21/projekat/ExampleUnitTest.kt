package ba.etf.rma21.projekat

/*
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val kvizovi = listOf(Kviz(
        "Kviz 1",
        "FWT",
        Date(121, Calendar.JANUARY, 5),
        Date(121, Calendar.JANUARY, 10),
        Date(121, Calendar.JANUARY, 7),
        3,
        "fwt1",
        0f,
        KvizStatus.DONE
    ),
        Kviz(
            "Kviz 1",
            "FWT",
            Date(121, Calendar.JANUARY, 5),
            Date(121, Calendar.JANUARY, 10),
            Date(121, Calendar.JANUARY, 7),
            3,
            "fwt2",
            0f,
            KvizStatus.DONE
        ),
        Kviz(
            "Kviz 1",
            "FWT",
            Date(121, Calendar.JANUARY, 5),
            Date(121, Calendar.JANUARY, 10),
            Date(121, Calendar.JANUARY, 7),
            3,
            "uup1",
            0f,
            KvizStatus.DONE
        )
    )

    @Before
    fun setup() {
        KvizRepository.clear()
        KvizRepository.dodajKvizove(kvizovi)
    }

    @Test
    fun testGetAllQuizes() {
        /*val quizes = KvizRepository.getAll()


        assertThat(quizes, hasItem<Kviz>(hasProperty("nazivPredmeta", Is("FWT"))))
        assertEquals(quizes.size, kvizovi.size)*/

    }

    @Test
    fun testGetMyQuizes() {
        val quizes = KvizRepository.getMyKvizes()
        assertEquals(quizes.size, kvizovi.size)

    }

    @Test
    fun testGetDoneQuizes() {
        val quizes = KvizRepository.getDone()
        assertEquals(quizes.size, kvizovi.size)

    }

    @Test
    fun testGetFutureQuizes() {
        val quizes = KvizRepository.getFuture()
        assertEquals(quizes.size, kvizovi.size)

    }

    @Test
    fun testGetNotTakenQuizes() {
        val quizes = KvizRepository.getNotTaken()
        assertEquals(quizes.size, kvizovi.size)

    }

    @Test
    fun testgetGroupsByPredmet() {
        val grupe = GrupaRepository.getGroupsByPredmet("FWT")
        assertEquals(grupe.size, kvizovi.size)


    }

    @Test
    fun testgetAllPredmeti() {
        val predmeti = PredmetRepository.getAll()
        assertEquals(predmeti.size, kvizovi.size)
        assertThat(predmeti, hasItem<Predmet>(hasProperty("naziv", Is("RMA"))))
        assertThat(predmeti, hasItem<Predmet>(hasProperty("naziv", Is("FWT"))))
        assertThat(predmeti, hasItem<Predmet>(hasProperty("naziv", Is("BWT"))))
    }

    @Test
    fun testgetPredmetByGodina() {
        val predmeti = PredmetRepository.getPredmetsByGodina(2)
        assertEquals(predmeti.size, kvizovi.size)
        assertThat(predmeti, hasItem<Predmet>(hasProperty("naziv", Is("RMA"))))

    }


}

 */

