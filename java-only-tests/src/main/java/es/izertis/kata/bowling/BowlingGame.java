package es.izertis.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Integer> rolls = new ArrayList<>();

    /**
     * Adds the number of pins knocked down in a roll to the list of rolls.
     * 
     * @param pins The number of pins knocked down in a roll.
     */
    public void roll(int pins) {
        rolls.add(pins);
    }

    /**
     * Calculates the score of a bowling game based on the rolls made by the player.
     *
     * @return The total score of the bowling game.
     */
    public int getScore() {
        int score = 0;
        int rollIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rollIndex)) {
                score += 10 + strikeBonus(rollIndex);
                rollIndex++;
            } else if (isSpare(rollIndex)) {
                score += 10 + spareBonus(rollIndex);
                rollIndex += 2;
            } else {
                score += rolls.get(rollIndex) + rolls.get(rollIndex + 1);
                rollIndex += 2;
            }
        }

        return score;
    }

    /**
     * Checks if a roll in a bowling game is a strike.
     *
     * @param rollIndex The index of the roll to check.
     * @return true if the roll at the specified index is a strike, false otherwise.
     */
    private boolean isStrike(int rollIndex) {
        int roll = rolls.get(rollIndex);
        return roll == 10;
    }

    /**
     * Checks if a roll in a bowling game is a spare.
     *
     * @param rollIndex The index of the roll to check.
     * @return true if the roll at the specified index and the next roll have a sum of 10, indicating a spare. false otherwise.
     */
    private boolean isSpare(int rollIndex) {
        int currentRoll = rolls.get(rollIndex);
        int nextRoll = rolls.get(rollIndex + 1);
        int sum = currentRoll + nextRoll;
        return sum == 10;
    }

    /**
     * Calculates the bonus score for a strike in a bowling game.
     *
     * @param rollIndex The index of the roll for which to calculate the strike bonus.
     * @return The bonus score for a strike in a bowling game.
     */
    private int strikeBonus(int rollIndex) {
        return rolls.get(rollIndex + 1) + rolls.get(rollIndex + 2);
    }

    /**
     * Calculates the bonus score for a spare in a bowling game.
     *
     * @param rollIndex The index of the roll for which to calculate the spare bonus.
     * @return The bonus score for a spare in a bowling game.
     */
    private int spareBonus(int rollIndex) {
        return rolls.get(rollIndex + 2);
    }
}

