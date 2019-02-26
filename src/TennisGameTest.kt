import org.junit.Before
import org.junit.Test
import java.lang.Exception
import kotlin.test.assertNotNull

class TennisGameTest {

    private var tennisGame: TennisGame? = null

    @Before
    @Throws(Exception::class)
    fun setup() {
        tennisGame = TennisGame()
    }

    @Test
    fun verifyGameExists() {
        assertNotNull(tennisGame, "the game exists")
    }
}