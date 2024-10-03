package org.example.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
    public static String readKey(String key){
        Properties properties = new Properties();
        try {           // As working with file io , everything should be in try catch

            FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties"); // copy path from content root
            properties.load(fileInputStream);


        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }


        return properties.getProperty(key);
    }
}
