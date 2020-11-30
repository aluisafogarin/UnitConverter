package converters;

public class InchConverter implements BaseConverter {
    private MeasureType measureType = MeasureType.LENGHT;

    @Override
    public double fromBasicUnit(double value) {
        return (value / 0.025);
    }

    @Override
    public double toBasicUnit(double value) {
        return (value * 0.025);
    }

    @Override
    public MeasureType getMeasureType() {
        return measureType;
    }
    
}
