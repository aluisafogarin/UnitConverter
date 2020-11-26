package converters;

public class CentimetreConverter implements BaseConverter {

    /* Converts M -> CM*/
    @Override
    public double fromBasicUnit(double value) {
        return (value * 100);
    }

    /* Converts CM -> M*/
    @Override
    public double toBasicUnit(double value) {
        return (value/100);
    }
    
}
