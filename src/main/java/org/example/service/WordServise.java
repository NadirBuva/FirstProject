package org.example.service;

import org.example.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordServise {
    @Autowired
    WordRepository wordRepository ;
    public  void deleteById(int id) {
        boolean bool =  wordRepository.isExist(id);
            if (bool){
                wordRepository.deleteByid(id);
                System.out.println("delete word ");
            }else
            {
                System.out.println("! can not delete ");
            }
    }
}
