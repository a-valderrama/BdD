
COMMENT ON TABLE AREAS_ESPARCIMIENTO IS 'informacion de las areas de esparcimiento';
COMMENT ON COLUMN AREAS_ESPARCIMIENTO.ID_AREA_ESP IS 'nos dice cual es el area de esparcimiento';
COMMENT ON COLUMN AREAS_ESPARCIMIENTO.ID_PROPIEDAD IS 'nos dice cual es la propiedad';

COMMENT ON TABLE CASA IS 'informacion de las propiedades de tipo casa';
COMMENT ON COLUMN CASA.ID_PROPIEDAD IS 'id de la propiedad';
COMMENT ON COLUMN CASA.ID_DUEÑO IS 'id del duenio de la propiedad';
COMMENT ON COLUMN CASA.FECHA_COMPRA IS 'fecha en la que se compro la propiedad';
COMMENT ON COLUMN CASA.COSTO IS 'costo de la compra de la propiedad';
COMMENT ON COLUMN CASA.NUM_ESTACIONAMIENTOS IS 'numero de estacionamientos de la casa';
COMMENT ON COLUMN CASA.ESTADO_PROPIEDAD IS 'estado, calidad, de la casa';
COMMENT ON COLUMN CASA.TAMAÑO IS 'tamanio,superficie total, de la casa';
COMMENT ON COLUMN CASA.FECHA_REGISTRO IS 'fecha en la que se registra la propiedad como existente';
COMMENT ON COLUMN CASA.NUM_HABITACIONES IS 'numero total de habitaciones';
COMMENT ON COLUMN CASA.NUM_BAÑOS IS 'numero total de banios';
COMMENT ON COLUMN CASA.VALOR_CATASTRAL IS 'valor catastral de la propiedad';
COMMENT ON COLUMN CASA.TAMAÑO_TOTAL IS 'tamanio total de la casa';
COMMENT ON COLUMN CASA.TAMAÑO_TOTAL_HABITABLE IS 'tamanio total habitable de la casa';
COMMENT ON COLUMN CASA.NUM_NIVELES IS 'numero de niveles de la casa';

COMMENT ON TABLE COLONIA IS 'informacion de las colonias';
COMMENT ON COLUMN COLONIA.ID_COLONIA IS 'id de la colonia';
COMMENT ON COLUMN COLONIA.NOMBRE IS 'nombre de la colonia';
COMMENT ON COLUMN COLONIA.NUM_HABS IS 'numero de habitantes en la colonia';
COMMENT ON COLUMN COLONIA.ID_DISTRITO IS 'id del distrito al cual pertenece la colonia';
COMMENT ON COLUMN COLONIA.ID_MUNICIPIO IS 'id del municipio al cual pertenece la colonia';
COMMENT ON COLUMN COLONIA.ID_ESTADO IS 'id del estado al cual pertenece la colonia';

COMMENT ON TABLE DEPARTAMENTO IS 'informacion de las propiedades de tipo departamento';
COMMENT ON COLUMN DEPARTAMENTO.ID_PROPIEDAD IS 'id de la propiedad';
COMMENT ON COLUMN DEPARTAMENTO.ID_DUEÑO IS 'id del duenio de la propiedad';
COMMENT ON COLUMN DEPARTAMENTO.FECHA_COMPRA IS 'fecha en la que se compro la propiedad';
COMMENT ON COLUMN DEPARTAMENTO.COSTO IS 'costo de la compra de la propiedad';
COMMENT ON COLUMN DEPARTAMENTO.NUM_ESTACIONAMIENTOS IS 'numero de estacionamientos de la casa';
COMMENT ON COLUMN DEPARTAMENTO.ESTADO_PROPIEDAD IS 'estado, calidad, de la casa';
COMMENT ON COLUMN DEPARTAMENTO.TAMAÑO IS 'tamanio,superficie total, de la casa';
COMMENT ON COLUMN DEPARTAMENTO.FECHA_REGISTRO IS 'fecha en la que se registra la propiedad como existente';
COMMENT ON COLUMN DEPARTAMENTO.NUM_HABITACIONES IS 'numero total de habitaciones';
COMMENT ON COLUMN DEPARTAMENTO.NUM_BAÑOS IS 'numero total de banios';
COMMENT ON COLUMN DEPARTAMENTO.VALOR_CATASTRAL IS 'valor catastral de la propiedad';
COMMENT ON COLUMN DEPARTAMENTO.AREA_DE_LAVADO IS 'Cuenta con area de lavado?';
COMMENT ON COLUMN DEPARTAMENTO.BALCON IS 'Cuenta con balcon?';
COMMENT ON COLUMN DEPARTAMENTO.ELEVADOR IS 'Cuenta con elevador?';
COMMENT ON COLUMN DEPARTAMENTO.MANTENIMIENTO IS 'Cuenta con servicio de mantenimiento';
COMMENT ON COLUMN DEPARTAMENTO.NIVEL IS 'nivel en el que se encuentra el departamento';
COMMENT ON COLUMN DEPARTAMENTO.NUM_TOTAL_DEPTOS IS 'numero total de departamentos';

COMMENT ON TABLE DIRECCION IS 'direccion de la propiedad';
COMMENT ON COLUMN DIRECCION.ID_DIRECCION IS 'id de la direccion';
COMMENT ON COLUMN DIRECCION.ID_PROPIEDAD IS 'id de la propiedad a la que esta asociada la direccion';
COMMENT ON COLUMN DIRECCION.ID_MUNICIPIO IS 'id del municipio al que pertenece la direccion';
COMMENT ON COLUMN DIRECCION.ID_DISTRITO IS 'id del distrito al que pertenece la direccion';
COMMENT ON COLUMN DIRECCION.ID_COLONIA IS 'id de la colonia al que pertenece la direccion';
COMMENT ON COLUMN DIRECCION.ID_ESTADO IS 'id del estado al que pertenece la direccion';
COMMENT ON COLUMN DIRECCION.CALLE IS 'calle de la propiedad';
COMMENT ON COLUMN DIRECCION.NUMERO IS 'numero de la calle de la propiedad, numero exterior';
COMMENT ON COLUMN DIRECCION.CP IS 'Codigo postal de la propiedad';

COMMENT ON TABLE DISTRITO IS 'distrito de la propiedad';
COMMENT ON COLUMN DISTRITO.ID_DISTRITO IS 'id del distrito';
COMMENT ON COLUMN DISTRITO.NOMBRE IS 'nombre del distrito';
COMMENT ON COLUMN DISTRITO.ID_ESTADO IS 'estado al cual pertenece el distrito';

COMMENT ON TABLE DUEÑO IS 'duenio de la propiedad';
COMMENT ON COLUMN DUEÑO.ID_DUEÑO IS 'id del duenio';
COMMENT ON COLUMN DUEÑO.NOMBRE IS 'nombre del duenio';
COMMENT ON COLUMN DUEÑO.AP_PATERNO IS 'apellido paterno del duenio';
COMMENT ON COLUMN DUEÑO.AP_MATERNO IS 'apellido materno del duenio';
COMMENT ON COLUMN DUEÑO.FECHA_NACIMIENTO IS 'fecha de nacimiento duenio';

COMMENT ON TABLE EDIFICIO IS 'informacion de las propiedades de tipo edificio';
COMMENT ON COLUMN EDIFICIO.ID_PROPIEDAD IS 'id de la propiedad';
COMMENT ON COLUMN EDIFICIO.ID_DUEÑO IS 'id del duenio de la propiedad';
COMMENT ON COLUMN EDIFICIO.FECHA_COMPRA IS 'fecha en la que se compro la propiedad';
COMMENT ON COLUMN EDIFICIO.COSTO IS 'costo de la compra de la propiedad';
COMMENT ON COLUMN EDIFICIO.NUM_ESTACIONAMIENTOS IS 'numero de estacionamientos del edificio';
COMMENT ON COLUMN EDIFICIO.ESTADO_PROPIEDAD IS 'estado, calidad, del edificio';
COMMENT ON COLUMN EDIFICIO.TAMAÑO IS 'tamanio,superficie total, del edificio';
COMMENT ON COLUMN EDIFICIO.FECHA_REGISTRO IS 'fecha en la que se registra la propiedad como existente';
COMMENT ON COLUMN EDIFICIO.NUM_HABITACIONES IS 'numero total de habitaciones';
COMMENT ON COLUMN EDIFICIO.NUM_BAÑOS IS 'numero total de banios';
COMMENT ON COLUMN EDIFICIO.VALOR_CATASTRAL IS 'valor catastral de la propiedad';

COMMENT ON TABLE ESTADO IS 'estado en el que se encuentra la propiedad';
COMMENT ON COLUMN ESTADO.ID_ESTADO IS 'id del estado';
COMMENT ON COLUMN ESTADO.NOMBRE IS 'nombre del estado';

COMMENT ON TABLE MUNICIPIO IS 'estado en el que se encuentra la propiedad';
COMMENT ON COLUMN MUNICIPIO.ID_MUNICIPIO IS 'id del municipio';
COMMENT ON COLUMN MUNICIPIO.NOMBRE IS 'nombre del municipo';
COMMENT ON COLUMN MUNICIPIO.ID_ESTADO IS 'id del estado al que pertenece el municipio';

COMMENT ON TABLE REGISTRO IS 'registro de las compra de la propiedad';
COMMENT ON COLUMN REGISTRO.ID_TRANSACCION IS 'id de la transaccion';
COMMENT ON COLUMN REGISTRO.ID_DUEÑO IS 'id del duenio que compra la propiedad';
COMMENT ON COLUMN REGISTRO.ID_PROPIEDAD IS 'id de la propiedad comprada';

COMMENT ON TABLE SERVICIO IS 'registro de las compra de la propiedad';
COMMENT ON COLUMN SERVICIO.ID_PROPIEDAD IS 'id de la propiedad en cuestion';
COMMENT ON COLUMN SERVICIO.ID_SERVICIO IS 'id del servicio proporcionado';
COMMENT ON COLUMN SERVICIO.PAGO_ANUAL IS 'costo anual de dicho servicio';
COMMENT ON COLUMN SERVICIO.TIPO IS 'tipo de servicio';

COMMENT ON TABLE TERRENO IS 'informacion de las propiedades de tipo terreno';
COMMENT ON COLUMN TERRENO.ID_PROPIEDAD IS 'id de la propiedad';
COMMENT ON COLUMN TERRENO.ID_DUEÑO IS 'id del duenio de la propiedad';
COMMENT ON COLUMN TERRENO.FECHA_COMPRA IS 'fecha en la que se compro la propiedad';
COMMENT ON COLUMN TERRENO.CONSTRUIDO IS 'conocer si el terreno tiene algo construido';
COMMENT ON COLUMN TERRENO.COSTO IS 'costo de la compra de la propiedad';
COMMENT ON COLUMN TERRENO.NUM_ESTACIONAMIENTOS IS 'numero de estacionamientos del terreno';
COMMENT ON COLUMN TERRENO.ESTADO_PROPIEDAD IS 'estado, calidad, del terreno';
COMMENT ON COLUMN TERRENO.TAMAÑO IS 'tamanio del terreno';
COMMENT ON COLUMN TERRENO.FECHA_REGISTRO IS 'fecha en la que se registra la propiedad como existente';
COMMENT ON COLUMN TERRENO.NUM_HABITACIONES IS 'numero total de habitaciones';
COMMENT ON COLUMN TERRENO.NUM_BAÑOS IS 'numero total de banios';
COMMENT ON COLUMN TERRENO.VALOR_CATASTRAL IS 'valor catastral de la propiedad';

COMMENT ON TABLE TIENDA IS 'tiendas departamentales en la colonia';
COMMENT ON COLUMN TIENDA.ID_TIENDA IS 'id de la tienda';
COMMENT ON COLUMN TIENDA.ID_COLONIA IS 'id de la colonia en la que esta la tienda';

COMMENT ON TABLE TRANSPORTE IS 'tiendas departamentales en la colonia';
COMMENT ON COLUMN TRANSPORTE.ID_TRANSPORTE IS 'id del transporte';
COMMENT ON COLUMN TRANSPORTE.ID_COLONIA IS 'id de la colonia en la que esta el transporte';




