package jchessimagelib;

import jchessimagelib.chess.PieceColor;
import jchessimagelib.graphics.svg.SampleFenRenderer;
import jchessimagelib.notations.FenNotation;
import jchessimagelib.notations.FenUtils;

import java.awt.image.BufferedImage;

public class FenRenderer {

    public static BufferedImage render(String fen) {
        FenNotation fenNotation = FenNotation.fromString(fen);
        PieceColor move = FenUtils.getTurn(fenNotation.getFen());
        return SampleFenRenderer.renderFen(fenNotation, move);
    }

    public static BufferedImage renderWhite(String fen) {
        return SampleFenRenderer.renderFen(FenNotation.fromString(fen), PieceColor.WHITE);
    }

    public static BufferedImage renderBlack(String fen) {
        return SampleFenRenderer.renderFen(FenNotation.fromString(fen), PieceColor.BLACK);
    }

}
