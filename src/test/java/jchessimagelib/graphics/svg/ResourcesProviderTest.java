package jchessimagelib.graphics.svg;

import jchessimagelib.chess.Piece;
import jchessimagelib.chess.PieceColor;
import jchessimagelib.chess.PieceType;
import jchessimagelib.chess.SquareColor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class ResourcesProviderTest {

    @Test
    void getPiece() throws IOException {
        BufferedImage data = ResourcesProvider.getPiece(Piece.from(PieceType.BISHOP, PieceColor.WHITE), SquareColor.DARK);

        Assertions.assertNotNull(data);

    }

    @Test
    void getSquare() {
        BufferedImage data = ResourcesProvider.getSquare(SquareColor.LIGHT);

        Assertions.assertNotNull(data);
    }
}