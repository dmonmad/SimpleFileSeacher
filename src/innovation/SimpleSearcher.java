/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innovation;

import innovation.utils.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import innovation.db.RegistryDAO;
import innovation.models.Registry;
import java.util.ArrayList;
import innovation.utils.Utils;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Nightm4re
 */
public class SimpleSearcher {

    List<Registry> registros = new ArrayList<Registry>();

    public void start(String dbPath) {
        if (dbPath != null) {
            loadRegistros(dbPath);
        }

        Scanner sn = new Scanner(System.in);

        boolean stop = false;

        int opcion;

        while (stop != true) {
            System.out.println("");
            System.out.println("");
            System.out.println("##### MAIN MENU #####");
            System.out.println("- Select an action -");
            System.out.println("[1] List all data");
            System.out.println("[2] Query data");
            System.out.println("[3] Load new data file");
            System.out.println("[4] Exit");
            opcion = sn.nextInt();
            sn.nextLine();

            switch (opcion) {
                case 1:
                    Utils.printRegistryAsTable(registros);
                    break;
                case 2:
                    System.out.println("Name:");
                    String name = sn.nextLine();
                    System.out.println("City:");
                    String city = sn.nextLine();
                    System.out.println("Contact:");
                    String contact = sn.nextLine();

                    List<Registry> result = new ArrayList<Registry>();
                    for (Registry element : registros) {
                        if (element.name.contains(name) && element.city.contains(city) && element.contact.contains(contact)) {
                            result.add(element);
                        }
                    }
                    Utils.printRegistryAsTable(result);
                    break;
                case 3:
                    System.out.println("File path:");
                    String newFile = sn.nextLine();
                    loadRegistros(newFile);
                    System.out.println("New data was loaded!");
                    break;
                case 4:
                    stop = true;
                    break;
                default:
                    System.out.println("Selecciona una opción válida");
            }

        }
    }

    void loadRegistros(String dbPath) {
        File dbFile;
        try {
            dbFile = new File(dbPath);
            this.registros = RegistryDAO.loadAllFromDatabase(dbFile);
        } catch (Exception e) {
            System.out.println("Couldn't load DB");
        }
    }
}
