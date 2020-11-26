package program;

//import converters.DynamicLoader;

public class Control {

    public static void loadClasses() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        DynamicLoader.startDynamicClassLoader();
    }
}
