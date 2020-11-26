package converters;

public class HectometreConverter implements BaseConverter {

    @Override
    public double fromBasicUnit(double value) {
        return (value/100);
    }

    @Override
    public double toBasicUnit(double value) {
        return (value*100);
    }

    @Override
    public MeasureType getMeasureType() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
