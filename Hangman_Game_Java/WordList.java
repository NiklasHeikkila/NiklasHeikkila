package dev.m3s.programming2.homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordList {

    private List<String> words = new ArrayList<String>();

    public WordList(String name) throws FileNotFoundException {

        File file = new File(name);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
                words.add(sc.nextLine());
                sc.close();
        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    public List<String> giveWords() {

        return this.words;
    }
}
