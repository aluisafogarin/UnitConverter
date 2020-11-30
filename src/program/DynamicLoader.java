package program;

import java.io.File;

import converters.BaseConverter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Organizes how classes will be loaded.
 */
public class DynamicLoader {
    private static ArrayList<String> classesNames = new ArrayList<String>();

    
    /** 
     * Load every class alone, instead of all of them at once.
     * 
     * @param name Name of the class.
     * @param path Path to .class file
     * @return BaseConverter Returns an object to the loaded class
     * @throws ClassNotFoundException In case dynamic class loader don't find a class.
     * @throws IllegalAccessException In case there's no acess to some file.
     * @throws InstantiationException In case dynamic class loader failed.
     */
    public static BaseConverter singleClassLoader(String name, String path) throws
        ClassNotFoundException, IllegalAccessException, InstantiationException {
        
        ClassLoader parentClassLoader = ProjectClassLoader.class.getClassLoader();
        ProjectClassLoader classLoader = new ProjectClassLoader(parentClassLoader);
        Class myClass = classLoader.loadClass("converters." + name); 
            
        BaseConverter classObject = (BaseConverter) myClass.newInstance();
        classLoader = new ProjectClassLoader(parentClassLoader);
        myClass = classLoader.loadClass("converters." + name, path.toString());

        classObject = (BaseConverter) myClass.newInstance();
        return classObject;
    }

    /** 
     * Set class names based on .class files.
    */
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

    
    /** 
     * Get names of all classes.
     * @return ArrayList<String> Returns an Array with all classes names.
     */
    public static ArrayList<String> getClassesNames() {
        return classesNames;
    }

    
    /** 
     * Get path to all classes.
     * @return String[] Returns an array with all paths.
     */
    public static String[] getAllClassesPath() {
        String sep = System.getProperty("file.separator");
        File file = new File(System.getProperty("user.dir") + sep + "UnitConverter" + sep +
        "bin" + sep + "converters");
        
        File[] fileClassPath = file.listFiles();
        String classesPath[] = 
            Arrays.stream(fileClassPath).map(File::getAbsolutePath).toArray(String[]::new);

        return classesPath;
    }

    
    /** 
     * Get path to a single class.
     * @param className Name of the class.
     * @return String Path to the class file.
     */
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
