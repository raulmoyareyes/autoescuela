/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class ResultadoExamen {

    private int id;
    private int fechaHora;
    private int acertadas;
    private int falladas;
    private int blanco;
    private String usuario;

    public ResultadoExamen() {
        id = 0;
        fechaHora = 0;
        acertadas = 0;
        falladas = 0;
        blanco = 0;
        usuario = "";
    }

    public ResultadoExamen(int _id, int _fechaHora, int _acertadas, int _falladas, int _blanco, String _usuario) {
        id = _id;
        fechaHora = _fechaHora;
        acertadas = _acertadas;
        falladas = _falladas;
        blanco = _blanco;
        usuario = _usuario;
    }
    
    public ResultadoExamen(int _acertadas, int _falladas, int _blanco, String _usuario) {
        acertadas = _acertadas;
        falladas = _falladas;
        blanco = _blanco;
        usuario = _usuario;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fechaHora
     */
    public int getFechaHora() {
        return fechaHora;
    }

    /**
     * @param fechaHora the fechaHora to set
     */
    public void setFechaHora(int fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * @return the acertadas
     */
    public int getAcertadas() {
        return acertadas;
    }

    /**
     * @param acertadas the acertadas to set
     */
    public void setAcertadas(int acertadas) {
        this.acertadas = acertadas;
    }

    /**
     * @return the falladas
     */
    public int getFalladas() {
        return falladas;
    }

    /**
     * @param falladas the falladas to set
     */
    public void setFalladas(int falladas) {
        this.falladas = falladas;
    }

    /**
     * @return the blanco
     */
    public int getBlanco() {
        return blanco;
    }

    /**
     * @param blanco the blanco to set
     */
    public void setBlanco(int blanco) {
        this.blanco = blanco;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
