package converters;

public class MileConverter implements BaseConverter {
    private MeasureType measureType = MeasureType.LENGHT;

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
        return measureType;
    }
    
}
