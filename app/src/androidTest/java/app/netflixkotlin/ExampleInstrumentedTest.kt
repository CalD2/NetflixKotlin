package app.netflixkotlin

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.netflixkotlin.dataObject.Films
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("app.netflixkotlin", appContext.packageName)
    }

//    @Test
//    fun test_001_insertFilmBdd() {
//        val a = MainActivity()
//
//        val myScope = GlobalScope
//        runBlocking {
//            myScope.launch {
//                a.getRepo().deleteAll()
//                var results : List<Films> = a.getRepo().getHistorical()
//                Assert.assertEquals(0, results)
//            }
//
//        }
//    }



}