package converters;

/* Basic Unit for lenght*/
public class MetreConverter implements BaseConverter {
    private MeasureType measureType = MeasureType.LENGHT;

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
