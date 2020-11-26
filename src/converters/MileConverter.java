package converters;

public class MileConverter implements BaseConverter {

    @Override
    public double fromBasicUnit(double value) {
        return (value * 0.006213689);
    }

    @Override
    public double toBasicUnit(double value) {
        return (value / 0.006213689);
    }

    @Override
    public MeasureType getMeasureType() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
