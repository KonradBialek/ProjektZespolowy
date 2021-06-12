package com.example.projektzespolowy;

import android.net.Uri;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Klasa zawiera informacje przechowywane w aplikacji.
 */
public class Storage {
    // Addphoto2
    public static String plant_description = "opis";
    public static String plant_species = "gatunek";
    public static String plant_name = "nazwa";
    public static Uri plant_photo;
    // LogIn
    public static byte[] passwordhash;
    public static byte[] salt;
    public static String username = "python";
    public static String usernamedefault = "python";
    // Recognition4
    public static String plants_name = "nazwa";
    public static Date watering_date;
    public static int water_freq = 5;
    public static Date fertilizing_date;
    public static int fertilizing_freq = 5;

    static {
        try {
            watering_date = (new SimpleDateFormat("dd-MM-YYYY")).parse ("19-11-2020");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            fertilizing_date = (new SimpleDateFormat("dd-MM-YYYY")).parse ("19-11-2020");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            salt = new byte[] { 50, 111, 8, 53, 86, 35, -19, -47 };
            SecureRandom random = new SecureRandom();
            random.nextBytes(salt);
            passwordhash = Hash("python123");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    /**
     * Hashowanie hasła w celu porównania haseł wprowadzonego przez użytkownika i przechowywanego w
     * aplikacji.
     * @param password Hasło wprowadzone przez użytkownika lub przechowywane w aplikacji.
     * @return Zahashowane hasło.
     * @throws NoSuchAlgorithmException Wyrzucany, gdy podano nieprawidłowy algorytm szyfrowania.
     * @throws InvalidKeySpecException Wyrzucany, gdy kod dostarczony lub wygenerowany do
     * szyfrowania hasła jest nieprawidłowy.
     */
    public static byte[] Hash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return factory.generateSecret(spec).getEncoded();
    }
}
