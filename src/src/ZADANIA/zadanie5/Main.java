package src.ZADANIA.zadanie5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("src/ZADANIA/zadanie5/lorem_Ipsum.txt");

        List<String> stringListOfReadFile = readFile(file);

        List<String> listOfSeparateWords = listOfSeparateWordsSortedByLength(stringListOfReadFile);
        for (String listOfSeparateWord : listOfSeparateWords) {
            System.out.println(listOfSeparateWord);
        }
//        String secondLongestWordInList = findSecondLongestWordInList(listOfSeparateWords);
//        System.out.println(secondLongestWordInList);
//        String wordWithSpecificLength = findWordWithSpecificLength(listOfSeparateWords, 3);
//        System.out.println(wordWithSpecificLength);

    }

    private static String findWordWithSpecificLength(List<String> stringList,int length) {
        List<String> list = new ArrayList<>();
        for (String s : stringList) {
            if (s.length() == length) {
                list.add(s);
            }
        }
        return list.get(1);
    }

    private static String findSecondLongestWordInList(List<String> stringList) {
        List<String> resultStringList = listOfSeparateWordsSortedByLength(stringList);
        return resultStringList.get(resultStringList.size() - 2);
    }

    private static List<String> listOfSeparateWordsSortedByLength(List<String> stringListLines) {
        List<String> stringList = new ArrayList<>();
        for (String s : stringListLines) {
            String[] s1 = s.split(" ");
            stringList.addAll(Arrays.asList(s1));
        }
        return stringList.stream()
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    private static List<String> readFile(File file) throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();

            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }
        }
        return result;
    }
}
