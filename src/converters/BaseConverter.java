package converters;

public interface BaseConverter {
 
    /* Da medida específica para o padrão do tipo (metro -> tipo) */
    float fromBasicUnit(float value);
    /* Do padrão do tipo para a medida específica (tipo -> metro) */
    float toBasicUnit(float value);
}
