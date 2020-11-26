package converters;

public class DecametreConverter implements BaseConverter {

    @Override
    public double fromBasicUnit(double value) {
        return (value/10);
    }

    @Override
    public double toBasicUnit(double value) {
        return (value*10);
    }

    @Override
    public MeasureType getMeasureType() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
