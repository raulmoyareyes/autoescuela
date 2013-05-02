/*
 * .
 */
package Model;

public class Pregunta {

    private String enunciado;
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private int respuestaCorrecta;
    private int tema;
    private String imagen;
    private int id;

    Pregunta() {}

    Pregunta(String _enunciado, String _respuesta1, String _respuesta2, String _respuesta3,
            int _respuestaCorrecta, int _tema) {
        enunciado = _enunciado;
        respuesta1 = _respuesta1;
        respuesta2 = _respuesta2;
        respuesta3 = _respuesta3;
        respuestaCorrecta = _respuestaCorrecta;
        tema = _tema;
    }

    Pregunta(String _enunciado, String _respuesta1, String _respuesta2, String _respuesta3,
            int _respuestaCorrecta, int _tema, String _imagen, int _id) {
        enunciado = _enunciado;
        respuesta1 = _respuesta1;
        respuesta2 = _respuesta2;
        respuesta3 = _respuesta3;
        respuestaCorrecta = _respuestaCorrecta;
        tema = _tema;
        imagen = _imagen;
        id = _id;
    }

    /**
     * @return the enunciado
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * @param enunciado the enunciado to set
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    /**
     * @return the respuesta1
     */
    public String getRespuesta1() {
        return respuesta1;
    }

    /**
     * @param respuesta1 the respuesta1 to set
     */
    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    /**
     * @return the respuesta2
     */
    public String getRespuesta2() {
        return respuesta2;
    }

    /**
     * @param respuesta2 the respuesta2 to set
     */
    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    /**
     * @return the respuesta3
     */
    public String getRespuesta3() {
        return respuesta3;
    }

    /**
     * @param respuesta3 the respuesta3 to set
     */
    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    /**
     * @return the respuestaCorrecta
     */
    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    /**
     * @param respuestaCorrecta the respuestaCorrecta to set
     */
    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    /**
     * @return the tema
     */
    public int getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(int tema) {
        this.tema = tema;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
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
}
