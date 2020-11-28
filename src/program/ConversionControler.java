package program;

import java.util.ArrayList;

public class ConversionControler {
    private String fromUnit;
    private String fromUnitClass;
    private String toUnit;
    private String toUnitClass;
    private ArrayList<String> classInfos = new ArrayList<String>();
    
    public ConversionControler(String fromUnit, String toUnit) {
        this.fromUnit = fromUnit;
        this.fromUnitClass = fromUnit + ".class";
        this.toUnit = toUnit;
        this.toUnitClass = toUnit + ".class";
    }

    public void loadClasses() throws 
        ClassNotFoundException, 
        IllegalAccessException, 
        InstantiationException {
        
        //DynamicLoader.startDynamicClassLoader(DynamicLoader.getClassesName(), DynamicLoader.getClassPath());
    }


}
