package jchessimagelib.notations;

import java.util.Objects;

/**
 *
 */
public class FenNotation {

    private static final FenNotation INITIAL_POSITION =
            new FenNotation("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");

    private final String fen;

    public static FenNotation create() {
        return INITIAL_POSITION;
    }

    public static FenNotation fromString(String fen) {
        return Objects.nonNull(fen) ? new FenNotation(fen) : create();
    }

    private FenNotation(String fen) {
        this.fen = fen;
    }

    public String getFen() {
        return fen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FenNotation that = (FenNotation) o;
        return Objects.equals(fen, that.fen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fen);
    }
}
