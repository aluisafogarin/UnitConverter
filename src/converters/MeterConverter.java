package converters;

/* Basic Unit for lenght*/
public class MeterConverter implements BaseConverter {

    @Override
    public double fromBasicUnit(double value) {
        return value;
    }

    @Override
    public double toBasicUnit(double value) {
        return value;
    }
      
}
