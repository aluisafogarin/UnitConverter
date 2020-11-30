package program;

import java.io.File;
import java.lang.invoke.MethodHandles.Lookup.ClassOption;

import converters.BaseConverter;
import converters.MeasureType;

import java.util.ArrayList;
import java.util.Arrays;

public class DynamicLoader {
    private static ArrayList<String> classesNames = new ArrayList<String>();
    private static ArrayList<String> typeClass = new ArrayList<String>();

    //public static void startDynamicClassLoader(String[] classNames, String[] classPath) throws 
    public static BaseConverter singleClassLoader(String name, String path) throws
        ClassNotFoundException, IllegalAccessException, InstantiationException {
        
        ClassLoader parentClassLoader = ProjectClassLoader.class.getClassLoader();
        ProjectClassLoader classLoader = new ProjectClassLoader(parentClassLoader);
        
        //System.out.println("Tentando iniciar a classe: " + name);
        //System.out.println("Estou usando o path para a classe: " + path);
        Class myClass = classLoader.loadClass("converters." + name); 

        //Thread.currentThread().setContextClassLoader(parentClassLoader);
            
        BaseConverter classObject = (BaseConverter) myClass.newInstance();

        //create new class loader so classes can be reloaded.
        classLoader = new ProjectClassLoader(parentClassLoader);
        myClass = classLoader.loadClass("converters." + name, path.toString());

        classObject = (BaseConverter) myClass.newInstance();

        System.out.println("Class Loaded: " + name);
        return classObject;
    }

    /* Gets every .class file name */
    public static void setClassesName() {
        String sep = System.getProperty("file.separator");
        File file = new File(System.getProperty("user.dir") + sep + "UnitConverter" + sep +
        "bin" + sep + "converters");
        String[] classNames = file.list();
        /* Removes .class from every class name */
        for (int i = 0; i < classNames.length; i++) {
            String name = classNames[i];
            if (name.length() > 0)
                name = name.substring(0, name.length() - 6);
            classNames[i] = name;
            classesNames.add(name);
        }
    }

    public static ArrayList<String> getClassesNames() {
        return classesNames;
    }

    /* Gets the path to the .class */
    public static String[] getAllClassesPath() {
        String sep = System.getProperty("file.separator");
        File file = new File(System.getProperty("user.dir") + sep + "UnitConverter" + sep +
        "bin" + sep + "converters");
        
        File[] fileClassPath = file.listFiles();
        String classesPath[] = 
            Arrays.stream(fileClassPath).map(File::getAbsolutePath).toArray(String[]::new);

        return classesPath;
    }

    /* Get path to a single class */
    public static String getSingleClassPath(String className) {
        String[] classPath = getAllClassesPath();
        String path = "";

        for (String p: classPath) {
            if (p.contains(className))
                path = p;
        }
       
        return path;
    }
}
