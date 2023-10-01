package edu.jsu.mcis.cs310.coursedb;

import edu.jsu.mcis.cs310.coursedb.dao.*;

public class Main {

    public static void main(String[] args) {
        
        DAOFactory daoFactory = new DAOFactory("coursedb");
        //daoFactory.getRegistrationDAO().create(1, 1, 10002); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        
        if ( !daoFactory.isClosed() ) {
            System.out.println("Connected Successfully!");
            
        }
        
        
    }
    
}