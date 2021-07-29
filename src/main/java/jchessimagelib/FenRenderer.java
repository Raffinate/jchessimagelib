package jchessimagelib;

import jchessimagelib.graphics.svg.SampleFenRenderer;
import jchessimagelib.notations.FenNotation;

import java.awt.image.BufferedImage;

public class FenRenderer {

    public static BufferedImage render(String fen) {
        return SampleFenRenderer.renderFen(FenNotation.fromString(fen));
    }

}
