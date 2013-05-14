
/*******************************************************************************
    BASE DE DATOS DEL PROYECTO
******************************************************************************/


/*******************************************************************************
    CREACION DE TABLAS
******************************************************************************/

CREATE TABLE USUARIOS(
    "NOMBRE"        VARCHAR(20)     NOT NULL,
    "APELLIDOS"     VARCHAR(30)     NOT NULL,
    "DNI"           VARCHAR(9)      NOT NULL PRIMARY KEY,
    "DIRECCION"     VARCHAR(50),
    "TELEFONO"        VARCHAR(15),
    "PASSWORD"        VARCHAR(30)     NOT NULL,
    "GRUPO"           NUMERIC          NOT NULL
);

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

    FOREIGN KEY ("USUARIO") REFERENCES ADMINISTRADOR.USUARIOS ON DELETE CASCADE
);


CREATE TABLE "RESULTADOSPREGUNTAS"(
    "EXAMEN"            INTEGER         NOT NULL,
    "PREGUNTA"          INTEGER         NOT NULL,   
    "RESULTADO"         INTEGER         NOT NULL,
    
    PRIMARY KEY ("EXAMEN","PREGUNTA"), 
    FOREIGN KEY ("EXAMEN") REFERENCES ADMINISTRADOR.RESULTADOSEXAMEN ON DELETE CASCADE,
    FOREIGN KEY ("PREGUNTA") REFERENCES ADMINISTRADOR.PREGUNTAS ON DELETE CASCADE
);


/*******************************************************************************
    DATOS DE EJEMPLO
******************************************************************************/
INSERT INTO USUARIOS VALUE ("Raúl","Moya Reyes","11111111A","C/Rio Duero nº12","666525111","123456",1);
INSERT INTO USUARIOS VALUE ("Manuel José","Castro Damas","22222222B","C/Molinillo nº1","666555111","123456",1);