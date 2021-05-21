/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innovation.db;

import innovation.models.Registry;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nightm4re
 */
public class RegistryDAO extends Registry {

    public RegistryDAO() {
    }

    public RegistryDAO(String name, String city, String contact) {
        this.name = name;
        this.city = city;
        this.contact = contact;
    }

    public static List<Registry> loadAllFromFile(File dbFile) {
        List<Registry> registros = new ArrayList<Registry>();
        try {   //creates a new file instance  
            Date start = new Date();
            FileReader fr = new FileReader(dbFile);   //reads the file  
            BufferedReader br = new BufferedReader(fr);    //constructs a string buffer with no characters  
            System.out.println("-> Reading from file...");
            String line;

            while ((line = br.readLine()) != null) {

                if (!line.isEmpty()) {
                    registros.add(parseLineToRegistry(line));
                }
            }
            fr.close();
            Date end = new Date();

            System.out.println("-> Data loaded in " + (end.getTime() - start.getTime()) / 1000 + " seconds");
            return registros;//closes the stream and release the resourc/returns 
        } catch (Exception e) {
            System.out.println("-> There was an error loading the file");
            return new ArrayList<Registry>();
        }
    }

    static Registry parseLineToRegistry(String line) {
        String[] data = line.split("\\|");
        return new RegistryDAO(data[0].trim(), data[1].trim(), data[2].trim());
    }
}
