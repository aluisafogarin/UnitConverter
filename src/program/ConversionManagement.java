package program;

import java.util.ArrayList;

import converters.BaseConverter;
import converters.MeasureType;

/**
 * Class responsible to manage the conversion process.
 */
public class ConversionManagement 
{
    private String fromUnit;
    private String toUnit;
    private String typeConversion;
    private static ArrayList<String> availableClasses = new ArrayList<String>();

    /**
     * Class constructor.
     */
    public ConversionManagement(String fromUnit, String toUnit) {
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
    }

    
    /** 
     * Get input value and makes the conversion process.
     * 
     * @param value Inputvalue.
     * @return double New value after conversion. 
     * @throws ClassNotFoundException In case dynamic class loader don't find a class.
     * @throws IllegalAccessException In case there's no acess to some file.
     * @throws InstantiationException In case dynamic class loader failed.
     */
    public double convert(double value) throws 
            ClassNotFoundException, IllegalAccessException, InstantiationException {
        
        BaseConverter convertFrom = 
            DynamicLoader.singleClassLoader(fromUnit, DynamicLoader.getSingleClassPath(fromUnit));
        
        BaseConverter convertTo = 
            DynamicLoader.singleClassLoader(toUnit, DynamicLoader.getSingleClassPath(toUnit));

        double newValue = convertTo.fromBasicUnit(convertFrom.toBasicUnit(value));
        System.out.println("Convert from: " + convertFrom + " to " + convertTo + "results: " + newValue);
        return newValue;
    }

    
    /** 
     * Class manager to first set classes names and only after that, start loading them and finally,
     * make the conversion.
     * 
     * @param value Input value
     * @return double New value after conversion. 
     * @throws ClassNotFoundException In case dynamic class loader don't find a class.
     * @throws IllegalAccessException In case there's no acess to some file.
     * @throws InstantiationException In case dynamic class loader failed.
     */
    public double manager(double value) throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException {
        DynamicLoader.setClassesName();
        loadClasses();
        return convert(value);
    }

    
    /** 
     * Loadclasses process
     * 
     * @throws ClassNotFoundException In case dynamic class loader don't find a class.
     * @throws IllegalAccessException In case there's no acess to some file.
     * @throws InstantiationException In case dynamic class loader failed.
     */
    public void loadClasses() throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException {

        /* First of all, fromUnit is loaded */
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

    
    /** 
     * Get type of conversion.
     * 
     * @return String Type of conversion.
     */
    public String getTypeConversion() {
        return typeConversion;
    }

    
    /** 
     * Get available classes.
     * 
     * @return ArrayList<String> Array with available classes.
     */
    public static ArrayList<String> getAvailableClasses() {
        return availableClasses;
    }

    
    /**  
     * Set type conversion.
     * 
     * @param classObject Object from just loaded class.
     */
    public void setTypeConversion(BaseConverter classObject) {
        MeasureType measureType = classObject.getMeasureType();
        typeConversion = measureType.name();
    }

    
    /** 
     * Set available classes
     * 
     * @param className Name of available classes
     */
    public void setAvailableClasses(String className) {
        availableClasses.add(className);
    }
}