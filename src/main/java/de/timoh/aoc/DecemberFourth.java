package de.timoh.aoc;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Timo Hanisch / timohanisch@gmail.com
 * @since 04.12.2015
 */
public class DecemberFourth {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String input = new String(Files.readAllBytes(Paths.get("inputs/input4")));
        leadingZeros(input, 5);
        leadingZeros(input, 6);
    }

    private static void leadingZeros(String input, int count) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        long num = 0;
        byte[] arr;
        while (true) {
            arr = md5.digest((input + num++).getBytes());
            if (startsWithZeros(arr, count)) {
                break;
            }
        }
        System.out.println("Hash: " + DatatypeConverter.printHexBinary(arr));
        System.out.println("Result: " + (num - 1));
    }

    private static boolean startsWithZeros(byte[] arr, int count) {
        boolean odd = count % 2 != 0;
        for (int i = 0; i < count / 2; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return !odd || arr[count / 2] < 0x0f && arr[count / 2] > 0x00;
    }
}
