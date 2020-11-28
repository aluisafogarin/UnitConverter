package converters;

public class MilimetreConverter implements BaseConverter {
    private MeasureType measureType = MeasureType.LENGHT;

    @Override
    public double fromBasicUnit(double value) {
        return (value*1000);
    }

    @Override
    public double toBasicUnit(double value) {
        return (value/1000);
    }

    @Override
    public MeasureType getMeasureType() {
        return measureType;
    }
    
}
