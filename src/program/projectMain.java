package program;

//import static program.Control.loadClasses;

public class ProjectMain {
    public static void main (String[] args) throws 
        ClassNotFoundException, 
        IllegalAccessException, 
        InstantiationException {
        ProjectMain execution = new ProjectMain();
        execution.start();
    }

    public void start() throws 
        ClassNotFoundException, 
        IllegalAccessException, 
        InstantiationException {
        System.out.println("Starting the program...");
        Control.loadClasses();
    }

    public void finish() {
        System.out.println("Finishing the program...");
    }

}
