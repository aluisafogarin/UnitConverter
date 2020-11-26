package program;

import java.io.File;

import converters.BaseConverter;

public class DynamicLoader {
    
    public static void startDynamicClassLoader(String[] classNames, File[] classPath) throws 
        ClassNotFoundException, 
        IllegalAccessException, 
        InstantiationException {
        
        ClassLoader parentClassLoader = ProjectClassLoader.class.getClassLoader();
        ProjectClassLoader classLoader = new ProjectClassLoader(parentClassLoader);

        for (String name : classNames) {
            /* The interface can't be dynamically loaded */
            if (!name.equals("BaseConverter")) {
                for (File path : classPath) {
                    System.out.println("Tentando iniciar a classe: " + name);
                    System.out.println("Estou usando o path para a classe: " + path);
                    Class myClass = classLoader.loadClass("converters." + name); 

                    Thread.currentThread().setContextClassLoader(parentClassLoader);
                    //CentimetreConverter object1 = (CentimetreConverter) myClass.newInstance();
                    BaseConverter object2 = (BaseConverter) myClass.newInstance();

                    //create new class loader so classes can be reloaded.
                    classLoader = new ProjectClassLoader(parentClassLoader);
                    myClass = classLoader.loadClass("converters." + name, path.toString());

                    //object1 = (CentimetreConverter) myClass.newInstance();
                    object2 = (BaseConverter) myClass.newInstance();
                    System.out.println(object2.toBasicUnit(100));
                }
            }
        }
    }

    /* Gets every .class file name */
    public static String[] getClassesName() {
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
        }
        return classNames;
    }

    /* Gets the path to the .class */
    public static File[] getClassPath() {
        String sep = System.getProperty("file.separator");
        File file = new File(System.getProperty("user.dir") + sep + "UnitConverter" + sep +
        "bin" + sep + "converters");

        File[] classPath = file.listFiles();
        return classPath;
    }
}
