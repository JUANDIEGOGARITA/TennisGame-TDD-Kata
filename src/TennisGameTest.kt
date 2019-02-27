import org.junit.Before
import org.junit.Test
import java.lang.Exception
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class TennisGameTest {

    private var game: TennisGame? = null

    @Before
    @Throws(Exception::class)
    fun setup() {
        game = TennisGame("Foster", "Nik")
    }

    @Test
    fun verifyGameExists() {
        assertNotNull(game, "the game exists")
    }

    @Test
    fun testNewGameShouldReturnLoveAll() {
        val score = game?.getScore()
        assertEquals("Love all", score)
    }

    @Test
    fun testPlayerOneWinsFirstBall() {
        game?.playerOneScores()

        val score = game?.getScore()
        assertEquals("Fifteen,Love", score)
    }

    @Test
    fun testFifteenAll() {
        game?.playerOneScores()
        game?.playerTwoScores()

        val score = game?.getScore()
        assertEquals("Fifteen all", score)
    }

    @Test
    fun testPlayerTwoWinsFirstTwoBalls() {
        createScore(0, 2)

        val score = game?.getScore()
        assertEquals("Love,Thirty", score)
    }

    @Test
    fun testPlayerOneWinsFirstThreeBalls() {
        createScore(3, 0)
        val score = game?.getScore()
        assertEquals("Forty,Love", score)
    }

    @Test
    fun testPlayersAreDeuce() {
        createScore(3, 3)

        val score = game?.getScore()
        assertEquals("Deuce", score)
    }

    @Test
    fun testPlayerOneWinsGame() {
        createScore(4, 0)

        val score = game?.getScore()
        assertEquals("Foster wins", score)
    }

    @Test
    fun testPlayerTwoWinsGame() {
        createScore(1, 4)

        val score = game?.getScore()
        assertEquals("Nik wins", score)
    }

    private fun createScore(playerOneBalls: Int, playerTwoBalls: Int) {
        for (i in 0 until playerOneBalls) {
            game?.playerOneScores()
        }
        for (i in 0 until playerTwoBalls) {
            game?.playerTwoScores()
        }
    }
}