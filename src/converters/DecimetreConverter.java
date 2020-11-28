package converters;

public class DecimetreConverter implements BaseConverter {
    private MeasureType measureType = MeasureType.LENGHT;

    @Override
    public double fromBasicUnit(double value) {
        return (value*10);
    }

    @Override
    public double toBasicUnit(double value) {
        return (value/10);
    }

    @Override
    public MeasureType getMeasureType() {
        return measureType;
    }

    
}
