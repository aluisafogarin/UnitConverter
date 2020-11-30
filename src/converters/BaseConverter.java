package converters;

/**
 * Interface that others converter classes will be based on.
 */
public interface BaseConverter {
    /**
     * Method that puts the value from the basic unit on the class unit.
     * @param value Input value
     */
    double fromBasicUnit(double value);

    /**
     * Methot that puts the value on the basic unit.
     * @param value
     */
    double toBasicUnit(double value);

    /**
     * Enum creator to know basic type.
     */
    MeasureType getMeasureType();
}
