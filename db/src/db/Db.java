/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.sql.*; 
import java.util.HashMap;
import java.util.Iterator;
/**
 *
 * @author VIMAL
 */

public class Db {
public void add(String tablename,HashMap<String,String> m)
    {
        Connection con=null;
        try{  
        Class.forName("com.mysql.jdbc.Driver");     
        con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Dbname","root","root"); 
        HashMap<String,String> map = m;
        String keystring = "";
        String valuestring = "";
        String[] keyarray = new String[map.size()];
        String[] valuearray = new String[map.size()];
        int i=0;
        for(HashMap.Entry<String,String> entry:map.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            keyarray[i] = key;
            valuearray[i] = value;
            i++;
        }
         keystring = String.join(",", keyarray);
        valuestring = String.join(",",valuearray);   
        String sql = "insert into "+tablename+" ("+keystring+"+) values ("+valuestring+");";
        System.out.println(sql);
        Statement statement = con.createStatement();
        int n=statement.executeUpdate(sql);
        System.out.println(n);
        }
          catch(Exception ex){
            ex.printStackTrace();
        }
        try{
        if(con!=null)
            con.close();
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }       
    }  
