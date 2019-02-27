class TennisGame(private val playerOneName: String, private val playerTwoName: String) {

    private var playerOneScore = 0
    private var playerTwoScore = 0

    fun getScore(): String {
        if (hasWinner()) {
            return playerWithHighestScore() + " wins"
        }
        if (isDeuce())
            return "Deuce"

        if (playerOneScore == playerTwoScore) {
            return translateScore(playerOneScore) + " all"
        }
        return translateScore(playerOneScore) + "," + translateScore(playerTwoScore)
    }


    private fun playerWithHighestScore(): String {
        return if (playerOneScore > playerTwoScore) {
            playerOneName
        } else {
            playerTwoName
        }
    }

    private fun isDeuce(): Boolean {
        return playerOneScore >= 3 && playerTwoScore == playerOneScore
    }

    private fun hasWinner(): Boolean {
        if (playerTwoScore >= 4 && playerTwoScore >= playerOneScore + 2)
            return true
        return playerOneScore >= 4 && playerOneScore >= playerTwoScore + 2
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
