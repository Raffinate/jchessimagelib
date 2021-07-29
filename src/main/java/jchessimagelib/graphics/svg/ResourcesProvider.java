package jchessimagelib.graphics.svg;

import jchessimagelib.chess.Piece;
import jchessimagelib.chess.PieceColor;
import jchessimagelib.chess.PieceType;
import jchessimagelib.chess.SquareColor;
import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.Document;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Map;

public class ResourcesProvider {

    private static final Map<SquareColor, BufferedImage> emptySquares = Map.of(
            SquareColor.DARK, readImage("ed"),
            SquareColor.LIGHT, readImage("el")
    );

    private static final Map<PieceType, BufferedImage> whitePiecesLightSquares = Map.of(
            PieceType.ROOK, readImage("rll"),
            PieceType.KNIGHT, readImage("nll"),
            PieceType.BISHOP, readImage("bll"),
            PieceType.QUEEN, readImage("qll"),
            PieceType.KING, readImage("kll"),
            PieceType.PAWN, readImage("pll")
    );

    private static final Map<PieceType, BufferedImage> whitePiecesDarkSquares = Map.of(
            PieceType.ROOK, readImage("rld"),
            PieceType.KNIGHT, readImage("nld"),
            PieceType.BISHOP, readImage("bld"),
            PieceType.QUEEN, readImage("qld"),
            PieceType.KING, readImage("kld"),
            PieceType.PAWN, readImage("pld")
    );

    private static final Map<PieceType, BufferedImage> blackPiecesLightSquares = Map.of(
            PieceType.ROOK, readImage("rdl"),
            PieceType.KNIGHT, readImage("ndl"),
            PieceType.BISHOP, readImage("bdl"),
            PieceType.QUEEN, readImage("qdl"),
            PieceType.KING, readImage("kdl"),
            PieceType.PAWN, readImage("pdl")
    );

    private static final Map<PieceType, BufferedImage> blackPiecesDarkSquares = Map.of(
            PieceType.ROOK, readImage("rdd"),
            PieceType.KNIGHT, readImage("ndd"),
            PieceType.BISHOP, readImage("bdd"),
            PieceType.QUEEN, readImage("qdd"),
            PieceType.KING, readImage("kdd"),
            PieceType.PAWN, readImage("pdd")
    );

    private static final Map<SquareColor, Map<PieceColor, Map<PieceType, BufferedImage>>> pieceMap = Map.of(
            SquareColor.DARK, Map.of(
                    PieceColor.BLACK, blackPiecesDarkSquares,
                    PieceColor.WHITE, whitePiecesDarkSquares
            ),
            SquareColor.LIGHT, Map.of(
                    PieceColor.BLACK, blackPiecesLightSquares,
                    PieceColor.WHITE, whitePiecesLightSquares
            )
    );

    public static BufferedImage getPiece(Piece piece, SquareColor squareColor) {
        return pieceMap.get(squareColor).get(piece.getColor()).get(piece.getType());
    }

    public static BufferedImage getSquare(SquareColor squareColor) {
        return emptySquares.get(squareColor);
    }

    private static BufferedImage readImage(String imageCode) {

        try {
            String parser = XMLResourceDescriptor.getXMLParserClassName();
            SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
            String uri = "http://www.example.org/diagram.svg";
            Document doc = f.createDocument(uri);
        } catch (IOException ex) {
            // ...
        }
        try {
            URL url =
                    ResourcesProvider.class.getResource(
                            MessageFormat.format("sample/Chess_{0}45.svg", imageCode)
                    );

            return ImageIO.read(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
