package converters;

/* Basic Unit for Volume */
public class CubicMetreConverter implements BaseConverter{

    @Override
    public double fromBasicUnit(double value) {
        return value;
    }

    @Override
    public double toBasicUnit(double value) {
        return value;
    }

    @Override
    public MeasureType getMeasureType() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
