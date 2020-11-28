package program;

import converters.BaseConverter;
import converters.MeasureType;

public class ConversionManagement {
    private String fromUnity;
    private String fromUnityClass;
    private String toUnity;
    private String toUnityClass;

    public ConversionManagement(String fromUnity, String toUnity) {
        this.fromUnity = fromUnity;
        this.fromUnityClass = fromUnity + ".class";
        this.toUnity = toUnity;
        this.toUnityClass = toUnity + ".class";
    }

    public void conversion(double value) throws 
        ClassNotFoundException, 
        InstantiationException, 
        IllegalAccessException {

        BaseConverter objeto = DynamicLoader.startDynamicClassLoader(toUnity, DynamicLoader.getSingleClassPath(toUnity));
        MeasureType measureType = objeto.getMeasureType();
        String basicUnit = measureType.getBasicUnit();
        String type = measureType.getTypeString(); 
        System.out.println("Classe do objeto:" + objeto.getClass());
        System.out.println(objeto.toBasicUnit(value));
        /* ClassLoader parentClassLoader = ProjectClassLoader.class.getClassLoader();
        ProjectClassLoader classLoader = new ProjectClassLoader(parentClassLoader);

        Class myClass = classLoader.loadClass("converters." + toUnity); 
        BaseConverter object = (BaseConverter) myClass.newInstance();

        /* Get information about measure type */ 
        
 

    }
}
