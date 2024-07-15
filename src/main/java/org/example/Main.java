package org.example;

import org.example.models.Vehicle;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(Vehicle.selectAll());
    }

    public static Connection connect(){
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/angelinos_auto_servisas","root","");
        }catch (Exception e){
            e.printStackTrace();
        }

        return con;
    }
}