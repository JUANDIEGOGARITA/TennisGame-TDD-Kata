class TennisGame(val playerOneName: String, val playerTwoName: String) {

    private var playerOneScore = 0
    private var playerTwoScore = 0

    fun getScore(): String {
        if (playerOneScore == playerTwoScore) {
            return translateScore(playerOneScore) + " all"
        }
        return translateScore(playerOneScore) + "," + translateScore(playerTwoScore)
    }

    private fun translateScore(score: Int): String {
        when (score) {
            3 -> return "Forty"
            2 -> return "Thirty"
            1 -> return "Fifteen"
            0 -> return "Love"
        }
        throw IllegalArgumentException("Illegal score: $score")
    }

    fun playerOneScores() {
        playerOneScore++
    }

    fun playerTwoScores() {
        playerTwoScore++
    }



}
