package jchessimagelib;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

class FenRendererTest {

    @Test
    void renderInitial() throws IOException {
        BufferedImage result = FenRenderer.render(
                        "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"
        );

        assertImage("/initial.png", result);
    }

    @Test
    void renderE4C5Nf3() throws IOException {
        BufferedImage result = FenRenderer.render(
                "rnbqkbnr/pp1ppppp/8/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R b KQkq - 1 2"
        );

        assertImage("/e4c5nf3.png", result);
    }

    @Test
    void renderWhiteForced() throws IOException {
        BufferedImage result = FenRenderer.renderWhite(
                "4k3/8/8/8/8/8/8/4K3 b - - 0 1"
        );

        assertImage("/white.png", result);
    }

    @Test
    void renderBlackForced() throws IOException {
        BufferedImage result = FenRenderer.renderBlack(
                "4k3/8/8/8/8/8/8/4K3 w - - 0 1"
        );

        assertImage("/black.png", result);
    }

    @Test
    void renderWhite() throws IOException {
        BufferedImage result = FenRenderer.render(
                "4k3/8/8/8/8/8/8/4K3 w - - 0 1"
        );

        assertImage("/white.png", result);
    }

    @Test
    void renderBlack() throws IOException {
        BufferedImage result = FenRenderer.renderBlack(
                "4k3/8/8/8/8/8/8/4K3 b - - 0 1"
        );

        assertImage("/black.png", result);
    }

    private void assertImage(String expectedImagePath, BufferedImage result) throws IOException {
        InputStream expectedStream = FenRendererTest.class.getResourceAsStream(expectedImagePath);
        byte[] expected = expectedStream.readAllBytes();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(result, "PNG", os);

        byte[] actual = os.toByteArray();

        //ImageIO.write(result, "PNG", new File("result.png"));

        Assertions.assertArrayEquals(expected, actual, "Expected images to be equal");
    }
}