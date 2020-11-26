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
        Class myObjectClass = classLoader.loadClass("converters.CentimetreConverter"); 

        CentimetreConverter object1 = (CentimetreConverter) myObjectClass.newInstance();
        BaseConverter object2 = (BaseConverter) myObjectClass.newInstance();

        //CentimetreConverter obj1 = new CentimetreConverter();
        //System.out.println(object1.fromBasicUnit(1));

        //create new class loader so classes can be reloaded.
        classLoader = new ProjectClassLoader(parentClassLoader);
        myObjectClass = classLoader.loadClass("converters.CentimetreConverter");

        object1 = (CentimetreConverter) myObjectClass.newInstance();
        object2 = (BaseConverter) myObjectClass.newInstance();
        //CentimetreConverter obj2 = new CentimetreConverter();
    }
}
