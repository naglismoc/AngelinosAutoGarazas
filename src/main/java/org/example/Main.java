package org.example;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import org.example.handlers.VehicleHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
//    public static List<Vehicle> vehicles = new ArrayList<>();
    public static Gson gson = new Gson();
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
        server.createContext("/createVehicle",new VehicleHandler());
        server.createContext("/getVehicles",new VehicleHandler());
        server.createContext("/getVehicle",new VehicleHandler());
        server.createContext("/updateVehicle",new VehicleHandler());
        server.createContext("/deleteVehicle",new VehicleHandler());
        server.setExecutor(null);
        server.start();
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