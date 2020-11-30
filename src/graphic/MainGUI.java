package graphic;

import javax.print.event.PrintEvent;

public class MainGUI {
    public static void mainInterface() 
    {
        try 
        {
            //MainWindow graphicInterface = new MainWindow(Info.getLongVersion());
            //graphicInterface.go();
        }
        catch (Exception exceptionValue) 
        {
            System.out.println(exceptionValue.getMessage());
            exceptionValue.printStackTrace();
            System.exit(1);
        }
    }
}
