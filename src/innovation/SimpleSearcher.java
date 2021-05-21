/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innovation;

import java.io.File;
import innovation.db.RegistryDAO;
import innovation.models.Registry;
import java.util.ArrayList;
import innovation.utils.Utils;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
            System.out.println("####### ACTIONS #######");
            System.out.println("- Select an action -");
            System.out.println("[1] List all data");
            System.out.println("[2] Query data");
            System.out.println("[3] Load new data file");
            System.out.println("[4] Exit");
            try {
                opcion = sn.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Select an option inserting a number between 1 and 4");
                opcion = 0;
            }
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
                    System.out.println("Insert new file path:");
                    String newFile = sn.nextLine();
                    loadRegistros(newFile);
                    System.out.println("New data was loaded!");
                    break;
                case 4:
                    stop = true;
                    break;
                default:
                    break;
            }

        }
    }

    void menu() {

    }

    void loadRegistros(String dbPath) {
        File dbFile;
        try {
            dbFile = new File(dbPath);
            this.registros = RegistryDAO.loadAllFromFile(dbFile);
        } catch (Exception e) {
            System.out.println("Couldn't load DB");
        }
    }
}
