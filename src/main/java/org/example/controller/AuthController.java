package org.example.controller;

import org.example.Utill.ScannerUtil;
import org.example.service.Authservice;
import org.example.service.WordServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthController {
@Autowired
    private Authservice authservice;
    @Autowired
    private WordServise wordServise ;

    private   Integer menu () {
        System.out.print("** Menu **\n" +
                "  1. Add Word\n" +
                "  2. WordList List\n" +
                "  3. Multiple Choice\n" +
                "  4. Spelling\n" +
                "  5. Searching\n" +
                "  6. Delete by id \n" +
                "  Enter command : ");
        return ScannerUtil.getAction();
    }

    public   void enterMENU(){

        while (true)
        { int n = menu();
            switch (n){
            case 1 :
                addWord();
                break;
            case 2 :
                wordlist();
                break;
            case 3:
                multipleChoise();
                break;
                case 4:
                    spelling();
                break;
                case 5:
                    searching();
                break;
                case 6 :
                    deleteByid();
                break;

        }}
    }

    private  void deleteByid() {
        System.out.println("Enter id of word for delete : ");
        int id = ScannerUtil.getAction();
            wordServise.deleteById(id);

//            System.out.println("something is wrong or  no such id ");

    }

    private  void searching() {
        System.out.println("Searching :\n" +
                "enter word in english or Uz : ");
        String searchWord =  ScannerUtil.getWord();
        System.out.println(authservice.searching(searchWord));
    }

    private  void spelling() {
        System.out.println("enter word in english ");
        String word = ScannerUtil.getWord();
        authservice.spelling(word);
    }

    private  void multipleChoise() {
        authservice.multiplrChoise();
    }

    private void wordlist() {
        System.out.println( authservice.getWordList());
    }

    private  void addWord() {
        System.out.println("enter word (Eng):");
        String wordEng =ScannerUtil.getWord() ;
        System.out.println("enter word (Uzb):");
        String wordUzb =ScannerUtil.getWord() ;
        System.out.println("enter word (EngSpelling):");
        String wordSpelling =ScannerUtil.getWord() ;

        authservice.addWord(wordEng,wordUzb, wordSpelling);
    }

}
