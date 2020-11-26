package converters;

public class YardConverter implements BaseConverter {

    @Override
    public double fromBasicUnit(double value) {
        return (value * 1.09361);
    }

    @Override
    public double toBasicUnit(double value) {
        return (value / 1.09361);
    }
    
}