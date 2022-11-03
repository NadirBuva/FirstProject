package org.example.database.dbcommands;
import org.example.database.DateBase;
import java.sql.Statement;

public class QueryCommands {
    Statement statement;

    {
        try {
            statement = DateBase.makeConnectDataBase().
                    createStatement();
           int n = statement.executeUpdate("create table dictionary " +
                   "(id serial , nameEng varchar , nameUzb varchar  ," +
                   " nameSpelling varchar ) ;") ;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
