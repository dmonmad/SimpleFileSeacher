package innovation.utils;

import innovation.models.Registry;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nightm4re
 */
public class Utils {

    public static void printRegistryAsTable(List<Registry> registros) {
        Date start = new Date();
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("%30s %20s %20s", "NAME", "CITY", "CONTACT");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (Registry registro : registros) {
            System.out.format("%30s %20s %20s", registro.name, registro.city, registro.contact);
            System.out.println();
        }
        Date end = new Date();
        
        System.out.format("%50s", "Total results: " + registros.size() + " in " + (end.getTime() - start.getTime()) / 1000 + " seconds");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------");
    }
}
