package tests;

import org.junit.Test;
import question12.NumberGame;

import static org.junit.Assert.*;

public class NumberGameTest {

    @Test
    public void solution() {
        NumberGame numberGame = new NumberGame();
        assertEquals("0111", numberGame.solution(2, 4, 2, 1));
        assertEquals("02468ACE11111111", numberGame.solution(16, 16, 2, 1));
        assertEquals("13579BDF01234567", numberGame.solution(16, 16, 2, 2));

    }
}