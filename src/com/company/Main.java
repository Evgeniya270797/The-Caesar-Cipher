package com.company;

import java.util.HashMap;
import java.util.Scanner;


public class Main {
    static char[] alphabetRu = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    static HashMap<Character, Integer> alphabetMap = new HashMap<>();

    private static void print() {
        System.out.println("Eсть зашифрованный текст, я буду пытаться расшифровать его." +
                " Когда я покажу тебе корректный вариант напиши 'Yes' или 'No'.");
    }

    private static void fillMap() {
        for (int i = 0; i < alphabetRu.length; i++) {
            alphabetMap.put(alphabetRu[i], i);
        }
    }

    private static char shiftLetter(char letter, int numberOfShifts) {
        int lowerBound = 0;
        int higherBound = alphabetRu.length - 1;
        int index;

        if (alphabetMap.get(letter) + numberOfShifts > higherBound) {
            index = lowerBound + (numberOfShifts - (higherBound - alphabetMap.get(letter)) - 1);
        } else {
            index = alphabetMap.get(letter) + numberOfShifts;
        }
        return alphabetRu[index];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        print();
        System.out.println(" ");
        String text = "Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв. Ъы зёюивй жёхчгюв бюнс ж ъы вдгивъгзхбсгрв аёхкдв. \n" +
                "Зъеъёс вгъ дмъчющгд, мзд гъюэцъьгджзс тздшд аёхкх фчбфъзжф жбъщжзчюъв гъждчъёнъгжзчх мъбдчъмъжадшд югщючющиивх. \n" +
                "Ф юэимюб чхни южздёюу ю чгыж юэвъгъгюф, здмгъъ дзёхэюч еджздфггиу юэвъгмючджзс мъбдчъмъжаюк едёдадч. \n" +
                "Ю зъв гъ въгъъ, еджбъщдчхбх гъищхмх. Ф еёюнъб а чрчдщи, мзд чюгдя чжъви вдя югзъббъаз, х чдэвдьгд, вды мёъэвъёгдъ жзёъвбъгюъ ад чжъви шхёвдгюмгдви. \n" +
                "Гхязю ёънъгюъ вгъ едвдшбх еёдшёхввх югзиюзючгдшд зюех, жеълюхбсгд ждэщхггхф щбф юэимъгюф деёъщъбъггрк жздёдг мъбдчъмъжадя щиню. \n" +
                "Въгф вдьгд гхэчхзс дзлдв Вхзёюлр, х ъы, цъэ еёъичъбюмъгюф, вхзъёсу.";

        int numberOfShifts = 0;

        fillMap();

        while (true) {
            StringBuilder decryptedText = new StringBuilder();

            for (int i = 0; i < text.length(); i++) {
                char letter = text.toLowerCase().charAt(i);

                if (letter != '.' && letter != ',' && letter != ' ' && letter != '\n') {
                    letter = shiftLetter(letter, numberOfShifts);
                }

                String checkLetter = String.valueOf(text.charAt(i));

                if (checkLetter.toUpperCase().equals(checkLetter)) {
                    decryptedText.append(String.valueOf(letter).toUpperCase());
                } else {
                    decryptedText.append(letter);
                }
            }
            System.out.println(decryptedText);
            String answer = scanner.next().toLowerCase();

            if (answer.equals("no")) {
                numberOfShifts++;
                System.out.println("Сдвиг на - " + numberOfShifts);
            } else {
                break;
            }
        }
    }
}
