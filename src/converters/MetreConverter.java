package converters;

/* Basic Unit for lenght*/
public class MetreConverter implements BaseConverter {
<<<<<<< HEAD:src/converters/MetreConverter.java
    private MeasureType measureType = MeasureType.LENGHT;
=======
    private static MeasureType measureType = MeasureType.LENGHT;
>>>>>>> 09ea3b35ea3f3efb4ec305a359a2be69e54b107a:src/converters/MeterConverter.java

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
