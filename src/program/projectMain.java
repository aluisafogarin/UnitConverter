package program;

import converters.MeasureType;
public class ProjectMain {
    public static void main (String[] args) throws 
        ClassNotFoundException, 
        IllegalAccessException, 
        InstantiationException,
        ClassCastException {
        try {
            ProjectMain execution = new ProjectMain();
            execution.start();

        } catch(IllegalArgumentException e) {
            System.out.println("Invalid arguments: " + e.getMessage());
        } catch(InstantiationException e) {
            System.out.println("Error to instantiate object: " + e.getMessage());
        } catch(ClassNotFoundException e) {
            System.out.println("Error to load " + e.getClass() + " : " + e.getMessage());
        } catch(ClassCastException e) {
            System.out.println("Error during class cast process: " + e.getMessage());
        }
    }

    public void start() throws 
        ClassNotFoundException, 
        IllegalAccessException, 
        InstantiationException {
        System.out.println("Starting the program...");
        DynamicLoader.startDynamicClassLoader(DynamicLoader.getClassesName(), DynamicLoader.getClassPath());
        for (MeasureType m : MeasureType.values()) {
            System.out.println(m.getBasicUnit());
        }
    }

    public void finish() {
        System.out.println("Finishing the program...");
    }

}
