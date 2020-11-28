package converters;

public class YardConverter implements BaseConverter {
    private MeasureType measureType = MeasureType.LENGHT;
    
    @Override
    public double fromBasicUnit(double value) {
        return (value * 1.09361);
    }

    @Override
    public double toBasicUnit(double value) {
        return (value / 1.09361);
    }

    @Override
    public MeasureType getMeasureType() {
<<<<<<< HEAD
        return measureType;
=======
        // TODO Auto-generated method stub
        return null;
>>>>>>> 09ea3b35ea3f3efb4ec305a359a2be69e54b107a
    }
    
}
