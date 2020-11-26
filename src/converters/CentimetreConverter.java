package converters;

public class CentimetreConverter implements BaseConverter {

    /* Converts M -> CM*/
    @Override
    public float fromBasicUnit(float value) {
        return (value * 100);
    }

    /* Converts CM -> M*/
    @Override
    public float toBasicUnit(float value) {
        return (value/100);
    }
    
}
