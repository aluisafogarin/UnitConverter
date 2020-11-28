package converters;

public class HectometreConverter implements BaseConverter {
    private MeasureType measureType = MeasureType.LENGHT;

    @Override
    public double fromBasicUnit(double value) {
        return (value/100);
    }

    @Override
    public double toBasicUnit(double value) {
        return (value*100);
    }

    @Override
    public MeasureType getMeasureType() {
        return measureType;
    }
    
}
