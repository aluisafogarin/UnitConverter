package converters;

public class KilometreConverter implements BaseConverter {

    @Override
    public double fromBasicUnit(double value) {
        return (value/1000);
    }

    @Override
    public double toBasicUnit(double value) {
        return (value*1000);
    }
    
}
