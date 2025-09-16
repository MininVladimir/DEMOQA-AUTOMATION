package core.generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Generator {
    public static String stringGenerator(int lowercaseLettersCount,
                                         int uppercaseLettersCount,
                                         int digitsCount,
                                         int symbolsCount) {
      String alphabet = "abcdefghijklmnopqrstuvwxyz";
      String digits = "1234567890";
      String symbols = "!@#$%^&*";
      Random random = new Random();
      StringBuilder myString = new StringBuilder();
      for (int i = 0; i < lowercaseLettersCount; i++) {
        myString.append(alphabet.charAt(random.nextInt(alphabet.length())));
      }
      for (int i = 0; i < uppercaseLettersCount; i++) {
        myString.append(Character.toUpperCase(alphabet.charAt(random.nextInt(alphabet.length()))));
      }
      for (int i = 0; i < digitsCount; i++) {
        myString.append(digits.charAt(random.nextInt(digits.length())));
      }
      for (int i = 0; i < symbolsCount; i++) {
        myString.append(symbols.charAt(random.nextInt(symbols.length())));
      }
      List<String> list = Arrays.asList(myString.toString().split(""));
      Collections.shuffle(list);
      return String.join("", list);
    }
  }