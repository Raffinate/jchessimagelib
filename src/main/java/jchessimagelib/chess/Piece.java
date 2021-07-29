package jchessimagelib.chess;

import java.util.Objects;

public class Piece {
    private final PieceType type;
    private final PieceColor color;

    public static Piece from(PieceType type, PieceColor color) {
        return new Piece(type, color);
    }

    private Piece(PieceType type, PieceColor color) {
        this.type = type;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return type == piece.type &&
                color == piece.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color);
    }

    public PieceType getType() {
        return type;
    }

    public PieceColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "[" + color + ", " + type + "]";
    }
}
