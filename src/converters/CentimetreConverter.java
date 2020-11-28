package converters;

public class CentimetreConverter implements BaseConverter {
    private MeasureType measureType = MeasureType.LENGHT;
    /* Converts M -> CM*/
    @Override
    public double fromBasicUnit(double value) {
        return (value * 100);
    }

    /* Converts CM -> M */
    @Override
    public double toBasicUnit(double value) {
        return (value / 100);
    }

    @Override
    public MeasureType getMeasureType() {
        return measureType;
    }
    
}
