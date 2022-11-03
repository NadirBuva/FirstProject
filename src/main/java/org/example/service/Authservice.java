package org.example.service;

import org.example.dto.Word;
import org.example.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Service
public class Authservice {
    @Autowired
    WordRepository wordRepository ;
    public  void multiplrChoise() {
        Random random = new Random();
        for (int i = 0; i <1; i++)
        {
            List<Word>  wordList = wordRepository.getWordList() ;
            int index = random.nextInt( wordRepository.getWordList().size()-1);
            System.out.println("Find  correct answer : \n ");
            Word word = wordList.get(index+1);
            String question =wordList.get(index+1).getNameEn();
            System.out.println(question);
            System.out.println();
        }
        for (int i = 0; i <3; i++) {
            List<Word>  wordList = wordRepository.getWordList() ;
            int index = random.nextInt( wordRepository.getWordList().size()-1);
            String question =wordList.get(index+1).getNameUz();
            System.out.println(question);

        }

}
    public  void addWord(String wordEng, String wordUzb, String wordSpelling) {
        wordRepository.addWord(wordEng,wordUzb,wordSpelling);
    }
    public  void spelling(String word) {
        boolean bool=  wordRepository.isExist(word);
        if (bool){
            System.out.println( wordRepository.spelling(word));
        }else if (!bool){
            System.out.println("no such word check word !");
            return;
        }
    }
    public  String searching(String searchWord) {
        return wordRepository.searching(searchWord);
    }

    public String getWordList() {
        return  wordRepository.getWordList().toString();
    }
}
