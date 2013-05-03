
/*******************************************************************************
    BASE DE DATOS DEL PROYECTO
 ******************************************************************************/

CREATE TABLE "PREGUNTAS"(
    "ENUNCIADO"         VARCHAR(500)    NOT NULL,
    "RESPUESTA1"        VARCHAR(500)    NOT NULL,
    "RESPUESTA2"        VARCHAR(500)    NOT NULL,
    "RESPUESTA3"        VARCHAR(500)    NOT NULL,
    "RESPUESTACORRECTA" INTEGER         NOT NULL,  
    "TEMA"              INTEGER         NOT NULL,  
    "IMAGEN"            VARCHAR(40),
    "ID"                INT             NOT NULL PRIMARY KEY
            GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)
);