package converters;

public class FootConverter implements BaseConverter {
    private MeasureType measureType = MeasureType.LENGHT;

    @Override
    public double fromBasicUnit(double value) {
        return (value / 0.3048);
    }

    @Override
    public double toBasicUnit(double value) {
        return (value * 0.3048);
    }

    @Override
    public MeasureType getMeasureType() {
        return measureType;
    }
    
}
