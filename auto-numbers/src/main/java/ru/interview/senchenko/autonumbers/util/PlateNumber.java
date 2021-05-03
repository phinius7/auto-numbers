package ru.interview.senchenko.autonumbers.util;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

public class PlateNumber {
    private static final short MAX_VALUE = 1000;
    private static final String ZERO = "000";
    private static final String OVERFLOW = "NUMBERS IS OVERFLOW";
    private static final String REGION = " 116 RUS";
    private static final String[] litters = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
    private static final TreeSet<String> allNumbers = new TreeSet<>();
    private static String lastIssuedNumber = "А000АА";

    public String getRandomPlateNumber() {
        String result = generatePlateNumber();
        if (!allNumbers.contains(result)) {
            allNumbers.add(result);
        } else {
            return getRandomPlateNumber();
        }
        return result + REGION;
    }

    public String getNextPlateNumber() {
        String result = generateNextPlateNumber();
        if (!allNumbers.contains(result)) {
            allNumbers.add(result);
        } else {
            return getNextPlateNumber();
        }
        return result + REGION;
    }

    private String generatePlateNumber() {
        Random random = new Random();
        String firstLitter = litters[random.nextInt(litters.length)];
        String number;
        short n = (short) random.nextInt(MAX_VALUE);
        if (n < MAX_VALUE / 100) {
            number = "00" + n;
        } else if (n < MAX_VALUE / 10) {
            number = "0" + n;
        } else {
            number = "" + n;
        }
        String secondLitter = litters[random.nextInt(litters.length)];
        String thirdLitter = litters[random.nextInt(litters.length)];
        return firstLitter + number + secondLitter + thirdLitter;
    }

    private String generateNextPlateNumber() {
        String result = lastIssuedNumber;
        if (allNumbers.size() > 0) {
            String firstLitter = lastIssuedNumber.substring(0, 1);
            String numbers = lastIssuedNumber.substring(1, 4);
            String secondLitter = lastIssuedNumber.substring(4, 5);
            String thirdLitter = lastIssuedNumber.substring(5, 6);
            short parseNum = Short.parseShort(numbers);
            String prefix;
            if (parseNum < MAX_VALUE - 1) {
                if (parseNum < MAX_VALUE / 100) {
                    prefix = "00";
                } else if (parseNum < MAX_VALUE / 10) {
                    prefix = "0";
                } else {
                    prefix = "";
                }
                result = firstLitter + prefix + (parseNum + 1) + secondLitter + thirdLitter;
            } else {
                if (!thirdLitter.equals(litters[litters.length - 1])) {
                    int index = Arrays.asList(litters).indexOf(thirdLitter);
                    result = firstLitter + ZERO + secondLitter + litters[index + 1];
                } else {
                    if (!secondLitter.equals(litters[litters.length - 1])) {
                        int index = Arrays.asList(litters).indexOf(secondLitter);
                        result = firstLitter + ZERO + litters[index + 1] + litters[0];
                    } else {
                        if (!firstLitter.equals(litters[litters.length - 1])) {
                            int index = Arrays.asList(litters).indexOf(firstLitter);
                            result = litters[index + 1] + ZERO + litters[0] + litters[0];
                        } else {
                            return OVERFLOW;
                        }
                    }
                }
            }
        }
        lastIssuedNumber = result;
        return result;
    }
}
