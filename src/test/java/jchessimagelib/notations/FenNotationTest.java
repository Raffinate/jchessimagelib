package jchessimagelib.notations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FenNotationTest {

    @Test
    void fromStringNonNull() {
        String expected = "fen";

        FenNotation notation = FenNotation.fromString(expected);

        Assertions.assertNotNull(notation, "Fen notation should be created");
        Assertions.assertEquals(expected, notation.getFen(), "Fen should not be changed");
    }

    @Test
    void fromStringNull() {
        FenNotation notation = FenNotation.fromString(null);

        Assertions.assertEquals(
                "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1",
                notation.getFen(),
                "Fen notation from null should create initial position");
    }

    @Test
    void create() {
        FenNotation notation = FenNotation.create();

        Assertions.assertEquals(
                "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1",
                notation.getFen(),
                "Fen notation should be initial position");
    }

    @Test
    void testEquals() {
        String position = "fen";
        FenNotation notation1 = FenNotation.fromString(position);
        FenNotation notation2 = FenNotation.fromString(new String(position));

        Assertions.assertEquals(notation1, notation2, "Fen notations should be equal");
    }

    @Test
    void testHashCode() {
        String position = "fen";
        FenNotation notation1 = FenNotation.fromString(position);
        FenNotation notation2 = FenNotation.fromString(new String(position));

        Assertions.assertEquals(notation1.hashCode(), notation2.hashCode(), "Fen notations hashcodes should be equal");
    }
}