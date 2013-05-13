
/*******************************************************************************
    BASE DE DATOS DEL PROYECTO
 ******************************************************************************/


/*******************************************************************************
    CREACION DE TABLAS
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


CREATE TABLE "RESULTADOSEXAMEN"(
    "ID"                INT             NOT NULL PRIMARY KEY
            GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    "FECHAHORA"         TIMESTAMP       NOT NULL,
    "ACERTADAS"         INTEGER         NOT NULL,
    "FALLADAS"          INTEGER         NOT NULL,   
    "BLANCO"            INTEGER         NOT NULL,
    "USUARIO"           VARCHAR(9)      NOT NULL,

    FOREIGN KEY ("USUARIO") REFERENCES ADMINISTRADOR.USUARIOS
);


CREATE TABLE "RESULTADOSPREGUNTAS"(
    "EXAMEN"            INTEGER         NOT NULL,
    "PREGUNTA"          INTEGER         NOT NULL,   
    "RESULTADO"         INTEGER         NOT NULL,
    
    PRIMARY KEY ("EXAMEN","PREGUNTA"), 
    FOREIGN KEY ("EXAMEN") REFERENCES ADMINISTRADOR.RESULTADOSEXAMEN,
    FOREIGN KEY ("PREGUNTA") REFERENCES ADMINISTRADOR.PREGUNTAS
);




/*******************************************************************************
    DATOS DE EJEMPLO
 ******************************************************************************/