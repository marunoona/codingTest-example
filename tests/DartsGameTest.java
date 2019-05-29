package tests;

import org.junit.Test;
import question02.DartsGame;

import static org.junit.Assert.*;

public class DartsGameTest {
    @Test
    public void splitString() {
        DartsGame dartsGame = new DartsGame();
        assertEquals(37,dartsGame.splitString("1S2D*3T"));
        assertEquals(9,dartsGame.splitString("1D2S#10S"));
        assertEquals(3,dartsGame.splitString("1D2S0T"));
        assertEquals(23,dartsGame.splitString("1S*2T*3S"));
        assertEquals(5,dartsGame.splitString("1D#2S*3S"));
        assertEquals(-4,dartsGame.splitString("1T2D3D#"));
        assertEquals(59,dartsGame.splitString("1D2S3T*"));

    }
}