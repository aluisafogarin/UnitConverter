package program;

import converters.CentimetreConverter;
import converters.ProjectClassLoad;
import converters.BaseConverter;

public class ProjectMain extends ClassLoader{
    public static void main (String[] args) throws 
        ClassNotFoundException, 
        IllegalAccessException, 
        InstantiationException {

        ClassLoader parentClassLoader = ProjectClassLoad.class.getClassLoader();
        ProjectClassLoader classLoader = new ProjectClassLoader(parentClassLoader);
        Class myObjectClass = classLoader.loadClass("converters.CentimetreConverter"); 

        CentimetreConverter object1 = (CentimetreConverter) myObjectClass.newInstance();

        //MyObjectSuperClass object2 = (MyObjectSuperClass) myObjectClass.newInstance();

        //CentimetreConverter obj1 = new CentimetreConverter();
        System.out.println(object1.fromBasicUnit(1));

        //create new class loader so classes can be reloaded.
        classLoader = new ProjectClassLoader(parentClassLoader);
        myObjectClass = classLoader.loadClass("converters.CentimetreConverter");

        object1 = (CentimetreConverter) myObjectClass.newInstance();
        //object2 = (MyObjectSuperClass) new myObjectClass();
        //CentimetreConverter obj2 = new CentimetreConverter();


    }
}
