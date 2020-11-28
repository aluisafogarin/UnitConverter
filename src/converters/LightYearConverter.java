package converters;

public class LightYearConverter implements BaseConverter {
    private MeasureType measureType = MeasureType.LENGHT;

    @Override
    public double fromBasicUnit(double value) {
        return 0;
    }

    @Override
    public double toBasicUnit(double value) {
        return 0;
    }

    @Override
    public MeasureType getMeasureType() {
        return measureType;
    }
    
}
