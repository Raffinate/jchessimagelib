package jchessimagelib.notations;

import jchessimagelib.chess.Piece;
import jchessimagelib.chess.PieceColor;
import jchessimagelib.chess.PieceType;
import jchessimagelib.chess.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@SuppressWarnings("OptionalGetWithoutIsPresent")
class FenUtilsTest {

    @Test
    void getPieceA1Initial() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

        Piece actual = FenUtils.getPiece(fen, Square.from("a1")).get();

        Assertions.assertEquals(Piece.from(PieceType.ROOK, PieceColor.WHITE), actual);
    }

    @Test
    void getPieceH1Initial() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

        Piece actual = FenUtils.getPiece(fen, Square.from("h1")).get();

        Assertions.assertEquals(Piece.from(PieceType.ROOK, PieceColor.WHITE), actual);
    }

    @Test
    void getPieceA8Initial() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

        Piece actual = FenUtils.getPiece(fen, Square.from("a8")).get();

        Assertions.assertEquals(Piece.from(PieceType.ROOK, PieceColor.BLACK), actual);
    }

    @Test
    void getPieceH8Initial() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

        Piece actual = FenUtils.getPiece(fen, Square.from("h8")).get();

        Assertions.assertEquals(Piece.from(PieceType.ROOK, PieceColor.BLACK), actual);
    }

    @Test
    void getPieceE1Initial() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

        Piece actual = FenUtils.getPiece(fen, Square.from("e1")).get();

        Assertions.assertEquals(Piece.from(PieceType.KING, PieceColor.WHITE), actual);
    }

    @Test
    void getPieceE8Initial() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

        Piece actual = FenUtils.getPiece(fen, Square.from("e8")).get();

        Assertions.assertEquals(Piece.from(PieceType.KING, PieceColor.BLACK), actual);
    }

    @Test
    void getPieceD4Initial() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

        Optional<Piece> actual = FenUtils.getPiece(fen, Square.from("d4"));

        Assertions.assertEquals(Optional.empty(), actual);
    }

    @Test
    void getPieceA1Empty() {
        String fen = "8/8/8/8/8/8/8/8 w KQkq - 0 1";

        Optional<Piece> actual = FenUtils.getPiece(fen, Square.from("a1"));

        Assertions.assertEquals(Optional.empty(), actual);
    }

    @Test
    void getPieceA8Empty() {
        String fen = "8/8/8/8/8/8/8/8 w KQkq - 0 1";

        Optional<Piece> actual = FenUtils.getPiece(fen, Square.from("a8"));

        Assertions.assertEquals(Optional.empty(), actual);
    }

    @Test
    void getPieceH1Empty() {
        String fen = "8/8/8/8/8/8/8/8 w KQkq - 0 1";

        Optional<Piece> actual = FenUtils.getPiece(fen, Square.from("h1"));

        Assertions.assertEquals(Optional.empty(), actual);
    }

    @Test
    void getPieceH8Empty() {
        String fen = "8/8/8/8/8/8/8/8 w KQkq - 0 1";

        Optional<Piece> actual = FenUtils.getPiece(fen, Square.from("h8"));

        Assertions.assertEquals(Optional.empty(), actual);
    }

    @Test
    void getPieceF6InBetweenEmpty() {
        String fen = "8/8/R1R2R1R/8/8/8/8/8 w KQkq - 0 1";

        Piece actual = FenUtils.getPiece(fen, Square.from("f6")).get();

        Assertions.assertEquals(Piece.from(PieceType.ROOK, PieceColor.WHITE), actual);
    }

    @Test
    void getPieceB3InE4C5Nf3() {
        String fen = "rnbqkbnr/pp1ppppp/8/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R b KQkq - 1 2";

        Optional<Piece> actual = FenUtils.getPiece(fen, Square.from("b3"));

        Assertions.assertTrue(actual.isEmpty());
    }


}