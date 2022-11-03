package org.example.repository;

import org.example.database.DateBase;
import org.example.dto.Word;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class WordRepository {
    public  boolean isExist(int id) {
        Statement statement = null ;
        try{
            statement= DateBase.makeConnectDataBase().createStatement();
            String sql = String.format("Select  id from dictionary where id= '%s';", id);

           ResultSet result = statement.executeQuery(sql);
            if (result.next()){
                return  true ;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public  boolean isExist (String word) {
        Statement statement = null ;
        try{
            statement= DateBase.makeConnectDataBase().createStatement();
            String sql = String.format
                    ("Select * from dictionary where nameEng ='"+word+"';" );
            ResultSet result = statement.executeQuery(sql);
            if (result.next()){
                return  true ;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public  void deleteByid(int id) {
        Statement statement = null ;
        try{
            statement= DateBase.makeConnectDataBase().createStatement();
            String sql = (
                    "DELETE FROM dictionary WHERE id = '"+id+"';");

           ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                System.out.println("delete word with "+id );
            }if (!resultSet.next()){
                System.out.println("!! don't  delete word with "+id );
            }


        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public  String searching(String searchWord) {
        Statement statement = null;
        try {
            statement = DateBase.makeConnectDataBase().createStatement();
            String sql = String.format(
                    "select *  FROM dictionary WHERE  nameEng = '"
                            + searchWord + "' or nameUzb = '"+searchWord+"';");

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Word word = new Word();
                word.setId(resultSet.getInt("id"));
                word.setNameEn(resultSet.getString("nameEng"));
                word.setNameUz(resultSet.getString("nameUzb"));
                word.setSpellingEn(resultSet.getString("nameSpelling"));

                String result ="uz - "+ word.getNameUz()+ "\n eng - "+ word.getNameEn();
            return  result ;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return  null ;
    }
    public  String spelling(String word) {
        Statement statement = null;
        try {
            statement = DateBase.makeConnectDataBase().createStatement();
            String sql = String.format(
                    "select *  FROM dictionary WHERE  nameEng  ='" + word+"';");

            ResultSet resultSet = statement.executeQuery(sql);
            Word word1 = new Word();
            while (resultSet.next()) {
                word1.setId(resultSet.getInt("id"));
                word1.setNameEn(resultSet.getString("nameEng"));
                word1.setNameUz(resultSet.getString("nameUzb"));
                word1.setSpellingEn(resultSet.getString("nameSpelling"));
            }
            return word1.getSpellingEn();

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
    public  List<Word> getWordList() {
        Statement statement = null;
        try {
            statement = DateBase.makeConnectDataBase().createStatement();
            String sql = (
                    "select *  FROM dictionary " );

            ResultSet resultSet = statement.executeQuery(sql);
            List<Word> wordList = new ArrayList<>();
            while (resultSet.next()) {
                Word word1 = new Word();
                word1.setId(resultSet.getInt("id"));
                word1.setNameEn(resultSet.getString("nameEng"));
                word1.setNameUz(resultSet.getString("nameUzb"));
                word1.setSpellingEn(resultSet.getString("nameSpelling"));
                wordList.add(word1);
            }
                return wordList ;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return  null ;
    }
//    public  Word show(int id) {
//        Statement statement = null ;
//        Word word= new Word() ;
//        try{
//            statement= DateBase.makeConnectDataBase().createStatement();
//            String sql = ("Select  id from dictionary" +
//                    " where id= '"+id+"';");
//
//            ResultSet result = statement.executeQuery(sql);
//            while (result.next()){
//                word.setId(result.getInt("id"));
//                word.setNameEn(result.getString("nameEng"));
//                word.setNameUz(result.getString("nameUzb"));
//                word.setSpellingEn(result.getString("nameSpelling"));
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return word;
////        return null ;
//    }
    public  void addWord(String wordEng, String wordUzb, String wordSpelling) {
        Statement statement = null ;
        try {
            statement = DateBase.makeConnectDataBase().createStatement();
            String sql = String.format("insert into dictionary " +
                    "( nameEng , nameUzb, nameSpelling)" +
                    "values ('%s','%s','%s'); ", wordEng, wordUzb, wordSpelling);
            int result = statement.executeUpdate(sql);
            if (result != 0) {
                System.out.println("saved successfully");
            } else{
                System.out.println("we do not saved this word ");
        }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
