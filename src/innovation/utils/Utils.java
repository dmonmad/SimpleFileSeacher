package innovation.utils;

import innovation.models.Registry;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
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
//        Date start = new Date();
//        System.out.println("-----------------------------------------------------------------------------------------------");
//        System.out.printf("%30s %20s %20s", "NAME", "CITY", "CONTACT");
//        System.out.println();
//        System.out.println("-----------------------------------------------------------------------------------------------");
//        for (Registry registro : registros) {
//            System.out.format("%30s %20s %20s", registro.name, registro.city, registro.contact);
//            System.out.println();
//        }
//        Date end = new Date();
//        
//        System.out.format("%50s", "Total results: " + registros.size() + " in " + (end.getTime() - start.getTime()) / 1000 + " seconds");
//        System.out.println();
//        System.out.println("-----------------------------------------------------------------------------------------------");
        try {
            Date start = new Date();
            BufferedWriter output = new BufferedWriter(
                    new OutputStreamWriter(System.out));
            output.write("-----------------------------------------------------------------------------------------------\n");
            output.write(String.format("%30s %20s %10s", "NAME", "CITY", "CONTACT\n"));
            output.write("-----------------------------------------------------------------------------------------------\n");
            StringBuilder sb = new StringBuilder();
            for (Registry registro : registros) {
                sb.append(String.format("%30s %20s %10s", registro.name, registro.city, registro.contact + '\n'));
            }
            output.write(sb.toString());
            output.write("\n");
            Date end = new Date();
            long time = (end.getTime() - start.getTime()) / 1000;
            output.write(String.format("%35s", "Total results: " + registros.size() + " in " + time + " seconds\n"));
            output.write("-----------------------------------------------------------------------------------------------\n");
            output.flush();
        } catch (Exception e) {
            System.out.println("-> Data couldn't be displayed");
        }

    }
}
