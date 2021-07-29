package jchessimagelib.chess;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinatesUtils {
    private static final Pattern validPattern = Pattern.compile("^\\p{Lower}\\d+$");
    private static final Pattern standardValidPattern = Pattern.compile("^[a-h][1-8]$");
    private static final Pattern filePattern = Pattern.compile("^\\p{Lower}+");
    private static final Pattern rankPattern = Pattern.compile("\\d+$");

    private static boolean isValidCoordinatesStructure(String coordinates) {
        return Optional.ofNullable(coordinates)
                .filter(validPattern.asMatchPredicate())
                .isPresent();
    }

    public static boolean isValidCoordinates(String coordinates) {
        return isValidCoordinatesStructure(coordinates) && standardValidPattern.asMatchPredicate().test(coordinates);
    }

    public static String getFileString(String coordinates) {
        Matcher matcher = filePattern.matcher(coordinates);
        if (!matcher.find()) {
            return "a";
        }
        return matcher.group();
    }

    public static String getRankString(String coordinates) {
        Matcher matcher = rankPattern.matcher(coordinates);
        if (!matcher.find()) {
            return "1";
        }
        return matcher.group();
    }

    public static int getFile(String coordinates) {
        String file = getFileString(coordinates);
        return file.charAt(0) - 'a';
    }

    public static int getRank(String coordinates) {
        String file = getRankString(coordinates);
        return file.charAt(0) - '1';
    }

    public static String fileToString(int file) {
        return Character.toString((char) ('a' + file));
    }

    public static String rankToString(int rank) {
        return Character.toString((char) ('1' + rank));
    }

    public static String coordinatesToString(int file, int rank) {
        return fileToString(file) + rankToString(rank);
    }

    public static SquareColor getSquareColor(String coordinates) {
        int file = getFile(coordinates);
        int rank = getRank(coordinates);
        return getSquareColor(file, rank);
    }
    public static SquareColor getSquareColor(int file, int rank) {
        int parity = (file + rank) % 2;
        return parity == 0 ? SquareColor.DARK : SquareColor.LIGHT;
    }
}
