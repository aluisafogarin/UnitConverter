package converters;

public class MilimetreConverter implements BaseConverter {

    @Override
    public double fromBasicUnit(double value) {
        return (value*1000);
    }

    @Override
    public double toBasicUnit(double value) {
        return (value/1000);
    }

    @Override
    public MeasureType getMeasureType() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
