/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innovation;

/**
 *
 * @author Nightm4re
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String filePath = args.length > 0 ? args[0] : null;
        SimpleSearcher program = new SimpleSearcher();
        program.start(filePath);

    }

}
