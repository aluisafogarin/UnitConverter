package program;

import converters.BaseConverter;
import converters.CentimetreConverter;

public class DynamicLoader {
    
    public static void startDynamicClassLoader() throws 
        ClassNotFoundException, 
        IllegalAccessException, 
        InstantiationException {

        ClassLoader parentClassLoader = ProjectClassLoader.class.getClassLoader();
        ProjectClassLoader classLoader = new ProjectClassLoader(parentClassLoader);
        Class myClass = classLoader.loadClass("converters.CentimetreConverter"); 

        Thread.currentThread().setContextClassLoader(parentClassLoader);
        //CentimetreConverter object1 = (CentimetreConverter) myClass.newInstance();
        BaseConverter object2 = (BaseConverter) myClass.newInstance();

        //create new class loader so classes can be reloaded.
        classLoader = new ProjectClassLoader(parentClassLoader);
        myClass = classLoader.loadClass("converters.CentimetreConverter");

        //object1 = (CentimetreConverter) myClass.newInstance();
        object2 = (BaseConverter) myClass.newInstance();
        System.out.println(object2.toBasicUnit(100));

        //System.out.println(object1.fromBasicUnit(1));
        //CentimetreConverter obj2 = new CentimetreConverter();
    }
}
