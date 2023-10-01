package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class DAOUtility {
    
    public static final int TERMID_FA23 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        ResultSetMetaData rsmd = null;
        
        try {
        
            if (rs != null) {

                // INSERT YOUR CODE HERE
                
                rsmd = rs.getMetaData();      
                int cols = rsmd.getColumnCount();
                
                while(rs.next()){
                    //JsonObject jObject = new JsonObject();
                    LinkedHashMap<String, String> jObject = new LinkedHashMap<>();
                    
                    for(int i = 1; i<= cols;i++){
                        jObject.put(rsmd.getColumnLabel(i), rs.getString(i));
                    }
                        
                records.add(jObject);
                }
                

            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
