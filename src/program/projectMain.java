package program;

import graphic.Infos;
import graphic.MainGUI;

/**
 *  Main class of the project.
 *  @author Ana Luísa Fogarin, Larissa Correira, Verussa de Alencar and Vinícius Lourenço
 *  @serial V1.0
 *  @since December, 2020
 */
public class projectMain 
{
    /** 
     * Main method of the project.
     * 
     * @param args
     * @throws ClassNotFoundException In case dynamic class loader don't find a class.
     * @throws IllegalAccessException In case there's no acess to some file.
     * @throws InstantiationException In case dynamic class loader failed.
     * @throws ClassCastException Problem during casting class.
     */
    public static void main (String[] args) throws 
            ClassNotFoundException, IllegalAccessException, 
            InstantiationException, ClassCastException { 
        try {
            projectMain execution = new projectMain();
            execution.start();
        } 
        catch(IllegalArgumentException e) {
            System.out.println("Invalid arguments: " + e.getMessage());
        } 
        catch(InstantiationException e) {
            System.out.println("Error to instantiate object: " + e.getMessage());
        } 
        catch(ClassNotFoundException e) {
            System.out.println("Error to load " + e.getClass() + " : " + e.getMessage());
        } 
        catch(ClassCastException e) {
            System.out.println("Error during class cast process: " + e.getMessage());
        }
    }

    
    /** 
     * Starts the GUI.
     * 
     * @throws ClassNotFoundException In case dynamic class loader don't find a class.
     * @throws IllegalAccessException In case there's no acess to some file.
     * @throws InstantiationException In case dynamic class loader failed.
     */
    public void start() throws 
            ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("Starting the program...");
        Infos text = new Infos();
        MainGUI.mainInterface();
    }

    public void finish() {
        System.out.println("Finishing the program...");
    }

}
