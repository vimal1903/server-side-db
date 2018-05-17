/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author VIMAL
 */
public class del 
        {
    public void delete(String tablename,HashMap<String,String> m)
    {
    Connection con=null;
        try{  
        Class.forName("com.mysql.jdbc.Driver");     
        con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Dbname","root","root"); 
        HashMap<String,String> map = m;
        String keystring = "";
        String valuestring = "";
        String somestring = "";
        String[] keyarray = new String[map.size()];
        String[] valuearray = new String[map.size()];
        String[] somearray = new String[map.size()];
        int i=0;
        for(HashMap.Entry<String,String> entry:map.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            keyarray[i] = key;
            valuearray[i] = value;
            somearray[i] = keyarray[i] + "=" + valuearray[i];
            i++;
        }
        somestring = String.join(" OR ",somearray);
        String sql = "delete from "+tablename+" where "+somestring+";";
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
