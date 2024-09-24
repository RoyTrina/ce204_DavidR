package Workingcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Spellchecker {
    private final trieNode root;

    //private Node class
    static class trieNode {
        private boolean endWord;
        private final trieNode[] children;

        public trieNode(String word) {
            endWord = false;
            children = new trieNode[26];
        }
    }

    //constructor
    public Spellchecker() {
        root = new trieNode("a"); //this means that it has an empty char
    }

    //addWord method
    public void addWord(String word) {
        trieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            /* The reason that I have done in this way is because the char 'a' has
             a certain decimal value; so if that value gets subtracted from the letter, the remainder becomes the index
             which falls between 0 and 25; The other way would have been to use a map data structure, which complicates
             more than required.
             */

            if (current.children[letter - 'a'] == null) {
                current.children[letter - 'a'] = new trieNode(word);
            }
            current = current.children[letter - 'a'];
        }
        current.endWord = true;

    }

    //this is a helper method that is used find the last word
    private trieNode getNode(String word) {
        trieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (current.children[letter - 'a'] == null) {
                return null;
            }
            current = current.children[letter - 'a'];
        }
        return current;
    }

// --Commented out by Inspection START (01/08/2021 18:07):
//    //containsWord method
//    public boolean containsWord(String word) {
//        trieNode node = getNode(word);
//
//        return node != null && node.endWord;
//    }
// --Commented out by Inspection STOP (01/08/2021 18:07)

    //countWords method
    int countWords() {
        int number = 0;

        if (root.endWord) {
            number++;
        }

        for (int i = 0; i <= 26; i++) {
            if (root.children[i] != null) {
                number += countWords();
            }
        }
        return number;
    }

    //addFile method
    void addFile(String filename) {
        try {
            File newFile = new File("dictionary.txt");
            Scanner reader = new Scanner(newFile);

            String addFileS = "dictionary.txt";
            if (newFile.getPath().equals(addFileS)) {
                filename = newFile.getPath();
            }

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    //checkFile method
    int checkFile(String filename) {
        File newFile = new File("sample.txt");

        String checkFileS = "sample.txt";
        if (newFile.getPath().equals(checkFileS)) {
            filename = newFile.getPath();
        }


        return 0;
    }

    //main method
    public static void main(String[] args) {
        Spellchecker newSpellCheck = new Spellchecker();
        newSpellCheck.addWord("you");
        newSpellCheck.countWords();

        newSpellCheck.addFile("");
        newSpellCheck.checkFile("sample.txt");


    }

}
