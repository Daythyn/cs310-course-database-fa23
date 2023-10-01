package edu.jsu.mcis.cs310.coursedb.dao;

import com.github.cliftonlabs.json_simple.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class SectionDAO {
    
    // INSERT YOUR CODE HERE
    private static final String QUERY_FIND = "SELECT * FROM section WHERE subjectid = ? AND num = ? ORDER BY ?";
    
    private final DAOFactory daoFactory;
    
    SectionDAO(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
        //find(1,"ACC","200"); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }
    
    public String find(int termid, String subjectid, String num) {
        
        String result = "[]";
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            Connection conn = daoFactory.getConnection();
            
            if (conn.isValid(0)) {
                
                // INSERT YOUR CODE HERE
                ps = conn.prepareStatement(QUERY_FIND);
                ps.setNString(1, subjectid);
                ps.setNString(2,num);
                ps.setInt(3, termid);
                
                boolean hasresults = ps.execute();
                
                if(hasresults){
                    rs = ps.getResultSet();
                    result = DAOUtility.getResultSetAsJson(rs);
                }
            }
            
        }
        
        catch (Exception e) { e.printStackTrace(); }
        
        finally {
            
            if (rs != null) { try { rs.close(); } catch (Exception e) { e.printStackTrace(); } }
            if (ps != null) { try { ps.close(); } catch (Exception e) { e.printStackTrace(); } }
            
        }
        
        return result;
        
    }
    
}