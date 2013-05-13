/*
 * 
 */
package Model;

public class ResultadoPregunta {

    private int examen;
    private int pregunta;
    private int resultado;

    public ResultadoPregunta() {
        examen = 0;
        pregunta = 0;
        resultado = -1;
    }
    
    public ResultadoPregunta( int _examen, int _pregunta, int _resultado) {
        examen = _examen;
        pregunta = _pregunta;
        resultado = _resultado;
    }

    /**
     * @return the examen
     */
    public int getExamen() {
        return examen;
    }

    /**
     * @param examen the examen to set
     */
    public void setExamen(int examen) {
        this.examen = examen;
    }

    /**
     * @return the pregunta
     */
    public int getPregunta() {
        return pregunta;
    }

    /**
     * @param pregunta the pregunta to set
     */
    public void setPregunta(int pregunta) {
        this.pregunta = pregunta;
    }

    /**
     * @return the resultado
     */
    public int getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
}
