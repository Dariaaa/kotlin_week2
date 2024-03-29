package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    val rightPositions = secret.zip(guess).count { pair -> pair.first==pair.second }

    val commonLetters = "ABCDEF".sumBy { ch ->

        Math.min(secret.count { it==ch },
                guess.count { it==ch })
    }
    return Evaluation(rightPositions, commonLetters - rightPositions)
}
