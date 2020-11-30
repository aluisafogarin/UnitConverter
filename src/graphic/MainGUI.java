package graphic;

public class MainGUI {
    public static void mainInterface() 
    {
        try 
        {
            ProgramWindow graphicInterface = new ProgramWindow(Infos.getLongVersion());
            graphicInterface.start();
        }
        catch (Exception exceptionValue) 
        {
            System.out.println(exceptionValue.getMessage());
            exceptionValue.printStackTrace();
            System.exit(1);
        }
    }
}
