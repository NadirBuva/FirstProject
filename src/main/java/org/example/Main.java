package org.example;
import org.example.config.Config;
import org.example.controller.AuthController;
import org.example.database.dbcommands.QueryCommands;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;


public class Main {
    public static void main(String[] args){

//        QueryCommands queryCommands = new QueryCommands();
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
//        AuthController authController =(AuthController) applicationContext.getBean("authController");
        //AuthController authController ;
        //authController.enterMENU();
//
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        AuthController authController = (AuthController) applicationContext.getBean("authController");
        authController.enterMENU();
    }
}