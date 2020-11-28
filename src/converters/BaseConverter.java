package converters;

public interface BaseConverter {
    /* Da medida específica para o padrão do tipo (metro -> tipo) */
    double fromBasicUnit(double value);
    /* Do padrão do tipo para a medida específica (tipo -> metro) */
    double toBasicUnit(double value);
    MeasureType getMeasureType();
}
