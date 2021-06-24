package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String file = "P:\\___\\amb\\config.cpp";
        String word = "closureShotHomeSilencedAttenuationCurve";

        fillsArray("P:\\___\\amb\\List.txt");
        System.out.println(grepLineNumber(file, word)); //Получить № строки с вхождением слова внутри файла
        deleteLineNumber(file,arrayList);

    }


    public static int grepLineNumber(String file, String word) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(file))));

        String line;
        int lineNumber = 0;
        while ((line = buf.readLine()) != null) {
            lineNumber++;
            if (line.contains(word)) {
                return lineNumber;
            }
        }
        return -1;

    }

    public static void fillsArray(String file) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(file))));

        String line;
        while ((line = buf.readLine()) != null) {
            arrayList.add(Integer.parseInt(line));
        }
        buf.close();
    }

    public static void deleteLineNumber(String file, ArrayList list) throws IOException {
        File sourceFile = new File(file);
        File outputFile = new File("P:\\___\\amb\\config2.cpp");

        //    Записываем в новый файл все данные, кроме удаляемой строки.

        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        String line;
        int lineNumber = 0;
        while ((line = reader.readLine()) != null) {
            lineNumber++;
            if (!list.contains(lineNumber)) {
                writer.write(line);
                writer.newLine();
            }
        }

        //    Затем удаляем исходный файл, а получившийся файл переименовываем.

        reader.close();
        writer.close();
//        sourceFile.delete();
//        outputFile.renameTo(sourceFile);
    }
}
