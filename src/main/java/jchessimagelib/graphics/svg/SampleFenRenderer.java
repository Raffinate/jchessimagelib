package jchessimagelib.graphics.svg;

import jchessimagelib.chess.Piece;
import jchessimagelib.chess.Square;
import jchessimagelib.chess.SquareColor;
import jchessimagelib.notations.FenNotation;
import jchessimagelib.notations.FenUtils;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.util.Optional;

import static java.awt.image.AffineTransformOp.TYPE_NEAREST_NEIGHBOR;

public class SampleFenRenderer {

    public static BufferedImage renderFen(FenNotation fen) {
        BufferedImage result = new BufferedImage(8 * 45, 8 * 45, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = result.createGraphics();
        for (int f = 0; f < 8; ++f) {
            for (int r = 0; r < 8; ++r) {
                Square square = Square.from(f, r);
                Optional<Piece> piece = FenUtils.getPiece(fen.getFen(), square);
                piece.ifPresentOrElse(
                        (p) -> renderPiece(g2d, square, p),
                        () -> renderSquare(g2d, square)
                );
            }
        }
        return result;
    }

    public static void renderPiece(Graphics2D g2d, Square square, Piece piece) {
        SquareColor squareColor = square.getSquareColor();
        BufferedImage squareImage = ResourcesProvider.getPiece(piece, squareColor);

        AffineTransform at = new AffineTransform();
        BufferedImageOp op = new AffineTransformOp(at, TYPE_NEAREST_NEIGHBOR);
        int[] canvasCoordinates = getCanvasCoordinates(square);

        g2d.drawImage(squareImage, op, canvasCoordinates[0], canvasCoordinates[1]);
    }

    public static void renderSquare(Graphics2D g2d, Square square) {
        SquareColor squareColor = square.getSquareColor();
        BufferedImage squareImage = ResourcesProvider.getSquare(squareColor);

        AffineTransform at = new AffineTransform();
        BufferedImageOp op = new AffineTransformOp(at, TYPE_NEAREST_NEIGHBOR);
        int[] canvasCoordinates = getCanvasCoordinates(square);

        g2d.drawImage(squareImage, op, canvasCoordinates[0], canvasCoordinates[1]);
    }

    private static int[] getCanvasCoordinates(Square square) {
        return new int[] {square.getFile() * 45, (7 - square.getRank()) * 45};
    }
}
