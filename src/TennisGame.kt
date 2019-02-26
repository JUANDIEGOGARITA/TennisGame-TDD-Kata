class TennisGame(val playerOneName: String, val playerTwoName: String) {

    private var playerOneScore = 0
    private val playerTwoScore = 0

    fun getScore(): String {
        if (playerOneScore == playerTwoScore) {
            return translateScore(playerOneScore) + " all"
        }
        return translateScore(playerOneScore) + "," + translateScore(playerTwoScore)
    }

    fun playerOneScores() {
        playerOneScore++
    }

    private fun translateScore(score: Int): String {
        when (score) {
            1 -> return "Fifteen"
            0 -> return "Love"
        }
        throw IllegalArgumentException("Illegal score: $score")
    }
}
