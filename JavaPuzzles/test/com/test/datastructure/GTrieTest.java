package com.test.datastructure;

import com.datatructure.GTrie;
import org.junit.Test;

import java.util.function.Supplier;

public class GTrieTest {


    @Test
    public void test() {

        GTrie trie = new GTrie();

        trie.addWord("car");
        trie.addWord("cat");
        trie.addWord("card");
        trie.printAllWords();

        GTrie.SpellChecker spellChecker = trie.spellChecker();

        checkSpelling(spellChecker, "calidoscope");
        checkSpelling(spellChecker, "car");
        checkSpelling(spellChecker, "camel");
        checkSpelling(spellChecker, "card");

    }

    private void checkSpelling(GTrie.SpellChecker spellChecker, String str) {
        spellChecker.reset();

        for(int i=0;i<str.length();i++) {
            boolean isFound = spellChecker.check(str.charAt(i));
            if(!isFound) {
                System.out.println(str+" word not found, break at index "+ (i+1) + ":"+str.charAt(i));
                break;
            }
            if(i == str.length() -1 ) {
                if(spellChecker.done()) {
                    System.out.println("Word "+str+" Found");
                }
            }

        }
    }


}
