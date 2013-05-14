
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
/********************************************USUARIOS**********************************************/
INSERT INTO ADMINISTRADOR.USUARIOS (NOMBRE, APELLIDOS, DNI, DIRECCION, TELEFONO, PASSWORD, GRUPO) 
	VALUES ('Manuel José', 'Castro Damas', '77362439F', 'C/Molinillo nº1', '680532097', '123456', 1);
INSERT INTO ADMINISTRADOR.USUARIOS (NOMBRE, APELLIDOS, DNI, DIRECCION, TELEFONO, PASSWORD, GRUPO) 
	VALUES ('Raul', 'Moya Reyes', '11111111A', 'C/Rio Duero nº3', '688555111', '123456', 1);
INSERT INTO ADMINISTRADOR.USUARIOS (NOMBRE, APELLIDOS, DNI, DIRECCION, TELEFONO, PASSWORD, GRUPO) 
	VALUES ('Agustín', 'Ruiz Linares', '33333333C', 'C/Rector nº4', '688885544', '123456', 1);
INSERT INTO ADMINISTRADOR.USUARIOS (NOMBRE, APELLIDOS, DNI, DIRECCION, TELEFONO, PASSWORD, GRUPO) 
	VALUES ('Gabriel', 'Fernández Moral', '44444444D', 'Av/ Granada nº 23', '622332233', '123456', 1);
INSERT INTO ADMINISTRADOR.USUARIOS (NOMBRE, APELLIDOS, DNI, DIRECCION, TELEFONO, PASSWORD, GRUPO) 
	VALUES ('Alberto', 'Téllez Aguallo', '12222222A', 'C/Legaspi nº 5', '679511222', '123456', 0);
INSERT INTO ADMINISTRADOR.USUARIOS (NOMBRE, APELLIDOS, DNI, DIRECCION, TELEFONO, PASSWORD, GRUPO) 
	VALUES ('Francisco Javier', 'Castro Ramirez', '23333333B', 'C/Moral nº 5', '633223322', '123456', 0);
INSERT INTO ADMINISTRADOR.USUARIOS (NOMBRE, APELLIDOS, DNI, DIRECCION, TELEFONO, PASSWORD, GRUPO) 
	VALUES ('Juan', 'Chica Estrella', '24444444F', 'Av/ Andalucia nº3 Bajo', '655655655', '123456', 0);
INSERT INTO ADMINISTRADOR.USUARIOS (NOMBRE, APELLIDOS, DNI, DIRECCION, TELEFONO, PASSWORD, GRUPO) 
	VALUES ('Manuel', 'Pancorbo Peinado', '25555555G', 'C/ Torres Altas nº 9', '699699699', '123456', 0);
INSERT INTO ADMINISTRADOR.USUARIOS (NOMBRE, APELLIDOS, DNI, DIRECCION, TELEFONO, PASSWORD, GRUPO) 
	VALUES ('Rosa', 'Ramirez Fanca', '26666666R', 'C/Moya nº 5', '688688688', '123456', 0);
INSERT INTO ADMINISTRADOR.USUARIOS (NOMBRE, APELLIDOS, DNI, DIRECCION, TELEFONO, PASSWORD, GRUPO) 
	VALUES ('María', 'Castillo Torres', '27777777T', 'C/Rio Tajo ', '658658658', '123456', 0);
INSERT INTO ADMINISTRADOR.USUARIOS (NOMBRE, APELLIDOS, DNI, DIRECCION, TELEFONO, PASSWORD, GRUPO) 
	VALUES ('Daniel', 'Peinado Pestaña', '28888888C', 'Av/ Andalucia nº9', '632632652', '123456', 0);
INSERT INTO ADMINISTRADOR.USUARIOS (NOMBRE, APELLIDOS, DNI, DIRECCION, TELEFONO, PASSWORD, GRUPO) 
	VALUES ('Nuria', 'Barranco Ureña', '31111111L', 'C/Legaspi nº 4', '654654698', '123456', 0);
INSERT INTO ADMINISTRADOR.USUARIOS (NOMBRE, APELLIDOS, DNI, DIRECCION, TELEFONO, PASSWORD, GRUPO) 
	VALUES ('Jose Ramón', 'Ureña Ureña', '32222222W', 'Av/ Norte nº3 1º B', '953558899', '123456', 0);






/********************************************PREGUNTAS**********************************************/
INSERT INTO ADMINISTRADOR.PREGUNTAS (ENUNCIADO, RESPUESTA1, RESPUESTA2, RESPUESTA3, RESPUESTACORRECTA, TEMA, IMAGEN) 
	VALUES ('En una vía fuera de poblado con arcén suficiente y transitable, ¿por qué parte de la vía circulará con un cuadriciclo ligero?', 'Por el arcén derecho.', 'Por el carril derecho de la calzada, sin invadir el arcén.', 'Por el carril derecho de la calzada, aunque deberé desplazarme al arcén cuando obstaculice la marcha normal del resto de los vehículos.', 1, 1, 'no_image.png');