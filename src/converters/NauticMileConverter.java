package converters;

public class NauticMileConverter implements BaseConverter {
    private MeasureType measureType = MeasureType.LENGHT;

    @Override
    public double fromBasicUnit(double value) {
        return (value / 1852); 
    }

    @Override
    public double toBasicUnit(double value) {
        return (value * 1852);
    }

    @Override
    public MeasureType getMeasureType() {
        return measureType;
    }
    
}
