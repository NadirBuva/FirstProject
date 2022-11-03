package org.example.database;
import java.sql.Connection;
import java.sql.DriverManager;


public class DateBase {
    public static Connection makeConnectDataBase (){
        Connection connection = null ;
        try {
            connection =
                    DriverManager.getConnection("jdbc:postgresql:" +
                                    "//localhost:5432/postgres",
                            "postgres" , "1234" );
        } catch (Exception e) {
            System.out.println(e);
        }
        return  connection ;
    }
}
