package program;

import graphic.Infos;
import graphic.MainGUI;

public class projectMain 
{

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

    public void start() throws 
            ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("Starting the program...");

        //ConversionManagement controler = new ConversionManagement("MetreConverter", "CentimetreConverter");
        //controler.manager();

        //System.out.println("All classes: " + DynamicLoader.getClassesNames());
        //System.out.println("The type of conversion is: " + controler.getTypeConversion());
    
        Infos text = new Infos();
        //AntigaGUI.exec();
        MainGUI.mainInterface();
    }

    public void finish() {
        System.out.println("Finishing the program...");
    }

}
