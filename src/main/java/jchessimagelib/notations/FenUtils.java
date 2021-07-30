package jchessimagelib.notations;

import jchessimagelib.chess.Piece;
import jchessimagelib.chess.PieceColor;
import jchessimagelib.chess.PieceType;
import jchessimagelib.chess.Square;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FenUtils {

    private static final Pattern rankPattern = Pattern.compile("[rnbqkpRNBQKP12345678]+");
    private static final Pattern movePattern = Pattern.compile(" [wb] ");

    public final static Map<String, Piece> blackPieceMap = Map.of(
            "r", Piece.from(PieceType.ROOK, PieceColor.BLACK),
            "n", Piece.from(PieceType.KNIGHT, PieceColor.BLACK),
            "b", Piece.from(PieceType.BISHOP, PieceColor.BLACK),
            "q", Piece.from(PieceType.QUEEN, PieceColor.BLACK),
            "k", Piece.from(PieceType.KING, PieceColor.BLACK),
            "p", Piece.from(PieceType.PAWN, PieceColor.BLACK)
    );

    public final static Map<String, Piece> whitePieceMap = Map.of(
            "R", Piece.from(PieceType.ROOK, PieceColor.WHITE),
            "N", Piece.from(PieceType.KNIGHT, PieceColor.WHITE),
            "B", Piece.from(PieceType.BISHOP, PieceColor.WHITE),
            "Q", Piece.from(PieceType.QUEEN, PieceColor.WHITE),
            "K", Piece.from(PieceType.KING, PieceColor.WHITE),
            "P", Piece.from(PieceType.PAWN, PieceColor.WHITE)
    );

    public final static Map<String, Piece> pieceMap = Collections.unmodifiableMap(
            Stream.concat(
                    blackPieceMap.entrySet().stream(),
                    whitePieceMap.entrySet().stream()
            ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
    );


    public static Optional<Piece> getPiece(String fen, Square square) {
        int file = square.getFile();
        int rank = square.getRank();

        String rankFen = getFenRankPart(fen, rank);
        String fileFen = getFenFilePart(rankFen, file);

        return Optional.ofNullable(pieceMap.get(fileFen));
    }

    public static String getFenRankPart(String fen, int rank) {
        Matcher matcher = rankPattern.matcher(fen);
        for (int i = 7; i >= rank; --i) {
            if (!matcher.find()) {
                return "8";
            }
        }
        return matcher.group();
    }

    public static String getFenFilePart(String fenRank, int file) {
        int currentFile = 0;
        for (int i = 0; i < fenRank.length(); ++i) {
            char c = fenRank.charAt(i);
            if (Character.isDigit(c)) {
                int d = Integer.parseInt(Character.toString(c));
                currentFile += d;
            } else {
                currentFile += 1;
            }
            if (currentFile > file) {
                return Character.toString(c);
            }
        }
        return "8";
    }

    public static PieceColor getTurn(String fen) {
        Matcher m = movePattern.matcher(fen);
        if (!m.find()) {
            return PieceColor.WHITE;
        }

        String move = m.group().trim();
        return Objects.equals("b", move) ? PieceColor.BLACK : PieceColor.WHITE;
    }

}
