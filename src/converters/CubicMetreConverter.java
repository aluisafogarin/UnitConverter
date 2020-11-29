package converters;

/* Basic Unit for Volume */
public class CubicMetreConverter implements BaseConverter{
    private MeasureType measureType = MeasureType.VOLUME;

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
        return measureType;
    }
    
}
