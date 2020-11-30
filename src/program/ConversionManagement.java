package program;

import java.util.ArrayList;

import converters.BaseConverter;
import converters.MeasureType;

public class ConversionManagement 
{
    private String fromUnit;
    private String fromUnitClass;
    private String toUnit;
    private String toUnitClass;
    private String typeConversion;
    private static ArrayList<String> availableClasses = new ArrayList<String>();

    public ConversionManagement(String fromUnit, String toUnit) {
        this.fromUnit = fromUnit;
        this.fromUnitClass = fromUnit + ".class";
        this.toUnit = toUnit;
        this.toUnitClass = toUnit + ".class";
    }

    public void manager() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        DynamicLoader.setClassesName();
        loadClasses();
    }

    public void loadClasses() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        /* First of all, fromUnity is loaded */
        BaseConverter fromUnitObject = DynamicLoader.singleClassLoader(fromUnit,
                DynamicLoader.getSingleClassPath(fromUnit));
        setTypeConversion(fromUnitObject);

        for (String className : DynamicLoader.getClassesNames()) {
            if (!className.equals("BaseConverter") && !className.equals("MeasureType")) {
                for (String classPath : DynamicLoader.getAllClassesPath()) {
                    if (classPath.contains(className)) {
                        BaseConverter classObject = DynamicLoader.singleClassLoader(className, classPath);
                        MeasureType typeClass = classObject.getMeasureType();

                        if ((typeConversion).contains(typeClass.name()))
                            setAvailableClasses(className);
                    }
                }
            }
        }
    }

    public String getTypeConversion() {
        return typeConversion;
    }

    public static ArrayList<String> getAvailableClasses() {
        return availableClasses;
    }

    public void setTypeConversion(BaseConverter classObject) {
        MeasureType measureType = classObject.getMeasureType();
        typeConversion = measureType.name();
    }

    public void setAvailableClasses(String className) {
        availableClasses.add(className);
    }
}