package jchessimagelib.chess;

import org.apache.commons.lang3.Validate;

import java.util.Objects;

public final class Square {
    private final int file;
    private final int rank;

    public static Square from(String coordinates) {
        String stripped = coordinates.toLowerCase().strip();

        Validate.isTrue(CoordinatesUtils.isValidCoordinates(stripped));

        return new Square(CoordinatesUtils.getFile(stripped), CoordinatesUtils.getRank(stripped));
    }

    public static Square from(int file, int rank) {
        Validate.inclusiveBetween(0, 7, file);
        Validate.inclusiveBetween(0, 7, rank);

        return new Square(file, rank);
    }

    private Square(int file, int rank) {
        this.file = file;
        this.rank = rank;
    }

    public int getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    public SquareColor getSquareColor() {
        return CoordinatesUtils.getSquareColor(file, rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square that = (Square) o;
        return file == that.file &&
                rank == that.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }

    @Override
    public String toString() {
        return CoordinatesUtils.coordinatesToString(file, rank);
    }
}
