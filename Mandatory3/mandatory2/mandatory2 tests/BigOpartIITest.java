package no.uib.ii.inf102.f18.mandatory2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Torstein Strømme
 */
public class BigOpartIITest {

    private BigOpartII bigO;

    @BeforeEach
    void createArray() {
        this.bigO = new BigOpartII();
    }

    @Test
    void testA() {
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                this.bigO.a(i, j);
                assertEquals(funcA(i, j), this.bigO.tally());
            }
        }
    }

    private int funcA(int n, int m) {
        return 2 * n + m;
    }

}
