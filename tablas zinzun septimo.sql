
 ----------------------------------DE NUEVO--------------------------------------------------
 create database Agroquimic
 use Agroquimic
 use master
create table Laboratorios (
idLaboratorio int,
nombre varchar(50),
origen varchar(30),
estatus char
constraint Marcas_PK primary key (idLaboratorio) 
)
go

create table Categorias (
idCategoria int,
nombre varchar(30),
estatus char
constraint Categorias1_PK primary key (idCategoria) 
)
go

select * from usuarios

create table Empaques (
idEmpaque int,
nombre varchar(80),
capacidad float,
estatus char,
idUnidad int
constraint Presentaciones_PK primary key (idEmpaque) 
)
go

create table UnidadMedida (
idUnidad int,
nombre varchar(80),
siglas varchar(20),
estatus char
constraint UnidadMedida_PK primary key (idUnidad) 
)
go

CREATE TABLE Productos(
    idProducto int,  
    nombre varchar(50),  
    descripcion varchar(100),
	puntoReorden int,
	precioCompra Float,
	precioVenta Float,
	ingredienteActivo varchar(100),
	bandaToxicologica varchar(80),
	aplicacion varchar(200),
	uso varchar(200),
	estatus char,
	idLaboratorio int,
	idCategoria int
	constraint Productos_PK primary key(idProducto)
	) 
go

select * from Productos

CREATE TABLE PresentacionesProducto(
idPresentacion int,
precioCompra float,
precioVenta float,
puntoReorden float,
idProducto int,
idEmpaque int,
constraint PresentacionesProducto_PK PRIMARY KEY (idPresentacion)
)
go

create table ExistenciasSucursal(
idPresentacion int,
idSucursal int,
Cantidad float
constraint Categorias_PK primary key (idPresentacion,idSucursal) 
)
go

CREATE TABLE Sucursales(
    idSucursal int, 
    nombre varchar(50),
	telefono varchar(15),
	direccion varchar(80),
	colonia varchar(50),
	codigoPostal varchar(5),
	presupuesto float,
	estatus char,
	idCiudad int
	constraint Sucursales_PK primary key(idSucursal),
    ) 
go

CREATE TABLE ImagenesProducto(
idImagen int,
nombreImagen varchar(100),
imagen Varbinary,
principal char,
idProducto INT
constraint ImagenesProducto_PK primary key(idImagen),
)
go

CREATE TABLE ProductosProveedor(
idProveedor int,
idPresentacion int,
diasRetardo int,
precioEstandar float,
precioUltimaCompra float,
cantMinPedir int,
cantMaxPedir int
constraint ProductosProveedor_PK primary key(idProveedor,idPresentacion)
)
go
----------------------------------------------------------------------------------
CREATE TABLE PedidoDetalle(
idPedidoDetalle int,
cantPedida int,
precioCompra float,
subtotal float,
cantRecibida int,
cantRechazada int,
cantAceptada float,
idPedido int,
idPresentacion int,
constraint PedidoDetalle_PK PRIMARY KEY (idPedidoDetalle),
)
go

CREATE TABLE Pedidos(
idPedido int,
FechaRegistro date,
FechaRecepcion date,
totalPagar float,
cantidadPagada float,
estatus char,
idProveedor int,
idSucursal int,
idEmpleado int
constraint Pedidos_PK primary key(idPedido)
)
go

CREATE TABLE ContactosProveedor(
idContacto int,
nombre varchar(80),
telefono char(12),
email varchar(100),
idProveedor int,
constraint ContactosProveedor_PK primary key (idContacto),
)
go

CREATE TABLE Proveedores(
idProveedor int,
nombre varchar(80),
telefono char(12),
email varchar(100),
direccion varchar(80),
colonia varchar(50),
codigopostar varchar(5),
idCiudad int
constraint Proveedores_PK primary key (idProveedor)
)
go

create table CuentasProveedor(
idCuentaProveedor int,
idProveedor int,
noCuenta varchar(10),
banco varchar(30)
constraint CuentasProveedores_PK primary key (idCuentaProveedor)
)
go

CREATE TABLE Pagos(
idPagos int,
fecha date,
importe float,
idPedido int,
idFormaPago int,
idCuentaProveedor int
constraint Pagos_PK primary key(idPagos)
)
go

Create table Ciudades(
idCiudad int,
nombre varchar(80),
idEstado int,
estatus char
constraint Ciudades_PK primary key(idCiudad)
)
go

create table FormasPago(
idFormaPago int,
nombre varchar(50),
Estatus char
constraint FormasPago_PK primary key(idFormaPago)
)
go

create table Estados(
idEstado int,
nombre varchar(60),
siglas varchar(10),
estatus char
constraint Estados_PK primary key(idEstado)
)
go

create table Empleados(
idEmpleado int,
nombre varchar(30),
apaterno varchar(30),
amaterno varchar(30),
sexo char,
fechaContratacion date,
fechaNacimiento date,
salario float,
nss varchar(10),
estadoCivil varchar(20),
diasVacaciones int,
diasPermiso int,
fotografia varchar(100),
direccion varchar(80),
colonia varchar(50),
codigoPostal varchar(5),
escolaridad varchar(80),
porcentajeComision float,
estatus char,
idDepartamento int,
idPuesto int,
idCiudad int,
idSucursal int,
constraint Empleados_PK primary key(idEmpleado)
)
go

create table Horarios(
idHorario int,
horaInicio date,
horaFin date,
dias varchar(30),
idEmpleado int
constraint Horarios_PK primary key(idHorario)
)
go

create table Incapacidades(
idIncapacidad int,
fechaInicio date,
fechaFin date,
enfermedad varchar(150),
evidencia varchar(100),
idEmpleado int
constraint Incapacidades_PK primary key(idIncapacidad)
)
go

create table Departamentos(
idDepartamento int,
nombre varchar(50),
estatus Char,
constraint Departamentos_PK primary key(idDepartamento)
)
go

Create table AusenciasJustificadas(
idAusencia int,
fechaSolicitud date,
fechaInicio date,
fechaFin date,
tipo char,
idEmpleadoS int,
idEmpleadoA int
constraint AusenciasJustificadas_PK primary key (idAusencia) 
)
go

create table Deduccciones(
idDeducciones int,
nombre varchar(30),
descripcion varchar(80)
constraint  DeducccionesJustificadas_PK primary key (idDeducciones) 
)
go

create table Percepciones(
idPercepcion int,
nombre varchar(30),
descripcion varchar(80),
diasPagar int
constraint Percepciones_PK primary key (idPercepcion) 
)
go

create table nominasPercepciones(
idNomina int,
idPercepcion int,
importe float
constraint NominasPercepciones_PK primary key (idPercepcion,idNomina) 
)
go

create table nominasDeducciones(
idNomina int,
idDeducciones int,
importe float
constraint nominaDeducciones_PK primary key (idnomina,idDeducciones) 
)
go

create table TiposUsuarios(
idTipoUsuario int,
nombre varchar(80),
estatus char 
constraint TiposUsuarios_PK primary key(idTipoUsuario)
)
go

create table Usuarios(
nombre varchar(30),
contrasenia varchar(20),
estatus char,
idEmpleado int,
idTipoUsuario int
constraint Usuarios_PK primary key(nombre)
)
go

create table Puestos(
idPuesto int,
nombre varchar(60),
salarioMinimo float,
salarioMaximo float,
estatus char
constraint Puestos_PK primary key(idPuesto)
)
go

create table HistorialPuestos(
idEmpleado int,
idPuesto int,
idDepartamento int,
fechaInicio date,
fechaFin date,
salario float
constraint HistorialPuestos_PK primary key(idEmpleado,idPuesto,idDepartamento,fechaInicio)
)
go

create table Nominas(
idNominas int,
fechaPago date,
totalP float,
totalD float,
cantidadNeta float,
diasTrabajados int,
faltas int,
fechaInicio date,
fechaFin date,
idEmpleado int,
idFormaPago int
constraint Nominas_PK primary key(idNominas)
)
go

create table DocumentacionEmpleado(
idDocumento int,
nombreDocumento varchar(80),
fechaEntrega date,
documento varchar(100),
idEmpleado int,
constraint DocumentacionEmpleado_PK primary key(idDocumento)
)
go

create table Ofertas(
idOfertas int,
nombre varchar(50),
descripcion varchar(100),
porDescuento float,
fechaInicio date,
fechaFin date,
canMinProducto int,
estatus char,
idProducto int
constraint Ofertas_PK primary key(idOfertas)
)
go

create table OfertasAsociacion(
idAsociacion int,
idOfertas int,
estatus char
constraint OfertasAsociacion_PK primary key(idAsociacion,idOfertas)
)
go

create table Asociaciones(
idAsociacion int,
nombre varchar(100),
estatus char
constraint Asociaciones_PK primary key(idAsociacion)
)
go

create table Miembros(
idCliente int,
idAsociacion int,
estatus char,
fechaIncorporacion date
constraint Miembros_PK primary key(idAsociacion,idCliente)
)
go

create table cultivos(
idCultivo int, 
nombre varchar(100),
costoAsesoria float,
estatus char
constraint cultivos_PK primary key(idCultivo)
)
go

create table VentasDetalle(
idVentaDetalle int,
precioVenta float,
cantidad float,
subtotal float,
idVenta int,
idPresentacion int,
constraint VentasDetalle_PK primary key(idVentaDetalle)
)
go

create table clientes(
idCliente int,
nombre varchar(100),
razonSocial varchar(100),
limiteCredito float,
dirrecion varchar(80),
codigoPostal char(5),
rfc varchar(13),
telefono char(12),
email varchar(100),
tipo char,
idCiudad int
constraint cliente_PK primary key(idCliente)
)
go

create table clientesCultivos(
idClienteCultivo int,
extension float,
ubicacion varchar(100),
idCliente int,
idCultivo int,
idCiudad int,
constraint clientesCultivos_PK primary key(idClienteCultivo)
)
go

create table Ventas(
idVentas int,
fecha date,
totalPagar float,
cantPagada float,
comentarios varchar(100),
estatus char,
tipo char,
idCliente int,
idSucursal int,
idEmpleado int
constraint Ventas_PK primary key(idVentas)
)
go

create table Facturas(
folio char,
subtotal float,
iva float,
total float,
nombreDocXML varchar(100),
documentoXML varchar(100),
nombreDocPDF varchar(100),
documentoPDF varchar(100),
idVenta int
constraint Facturas_PK primary key(folio)
)
go

create table Visitas(
idVisita int,
fechaPlaneada date,
fechaReal date,
comentarios varchar(200),
estatus char,
costo float,
idClienteCultivo int,
idEmpleado int,
idUnidadTransporte int
constraint visitas_PK primary key(idVisita)
)
go

create table Tripulacion(
idEmpleado int,
idEnvio int,
rol varchar(50)
constraint Tripulacion_PK primary key(idEmpleado,idEnvio,rol)
)
go

create table Cobros(
idCobro int,
fecha date,
importe float,
idVenta int,
idFormaPago int,
constraint cobros_PK primary key(idCobro)
)
go

create table UnidadesTransporte(
idUnidadTransporte int,
placas varchar(10),
marca varchar(80),
modelo varchar(80),
anio int,
capacidad int
constraint UnidadesTransporte_PK primary key(idUnidadTransporte)
)
go

create table Mantenimientos(
idMantenimiento int,
fecha date ,
taller varchar(100),
costo float, 
comentarios varchar(200),
tipo varchar(30),
idUnidadTransporte int,
constraint mantenimientos_PK primary key(idMantenimiento)
)
go

create table Envios(
idEnvio int,
fechaEntregaPlaneada date,
fechaEntregaReal date,
direccion  varchar(100),
codigoPostal varchar(5),
idVenta int,
idUnidadTransporte int,
idCiudad int
constraint EnviosVentas_PK primary key(idEnvio)
)
go
------------------------------------LLAVES FORANEAS--------------------------------------------
alter table Empaques add
constraint FK_Unidad1 foreign key (idUnidad) references UnidadMedida(idUnidad)
alter table Productos add
constraint idLaboratorio_FK foreign key (idLaboratorio) references Laboratorios (idLaboratorio)
alter table Productos add
constraint idCategoria_FK foreign key (idCategoria) references Categorias(idCategoria)
alter table PresentacionesProducto add
constraint idProducto_FK foreign key (idProducto) references Productos(idProducto)
alter table PresentacionesProducto add 
constraint idEmpaques_FK foreign key (idEmpaque) references Empaques(idEmpaque)
alter table Sucursales add 
constraint idCiudad_FK foreign key (idCiudad) references Ciudades (idCiudad)
alter table ImagenesProducto add
constraint idProducto1_FK foreign key (idProducto) references Productos (idProducto)
alter table PedidoDetalle add
constraint idPedido_FK foreign key (idPedido) references Pedidos(idPedido),
constraint idPresentacion_FK foreign key (idPresentacion) references PresentacionesProducto(idPresentacion)
alter table Pedidos add
constraint idProveedor_FK foreign key (idProveedor) references Proveedores(idProveedor),
constraint idSucursal_FK foreign key (idSucursal) references Sucursales (idSucursal),
constraint idEmpleado_FK foreign key (idEmpleado) references Empleados(idEmpleado)
alter table ContactosProveedor add
constraint idProveedor1_FK foreign key (idProveedor) references Proveedores(idProveedor)
alter table Proveedores add
constraint idCiudad1_FK foreign key (idCiudad) references Ciudades (idCiudad)
alter table Pagos add
constraint idPedido1_FK foreign key (idPedido) references Pedidos (idPedido),
constraint idFormaPago_FK foreign key (idFormaPago) references FormasPago (idFormaPago),
constraint idCuentaProveedor_FK foreign key (idCuentaProveedor) references CuentasProveedor(idCuentaProveedor)
alter table Ciudades add
Constraint idEstado_FK foreign key(idEstado)references Estados(idEstado)
alter table Empleados add
Constraint idDepartamento_FK foreign key(idDepartamento)references Departamentos(idDepartamento),
Constraint idPuesto_FK foreign key(idPuesto)references Puestos(idPuesto),
Constraint idCiudad2_FK foreign key(idCiudad)references Ciudades(idCiudad),
Constraint idSucursales_FK foreign key(idSucursal)references sucursales(idSucursal)
alter table Horarios add
Constraint idEmpleado2_FK foreign key(idEmpleado)references Empleados(idEmpleado)
alter table Incapacidades add
Constraint idEmpleado1_FK foreign key(idEmpleado)references Empleados(idEmpleado)
alter table Usuarios add
Constraint EmpleadoUser_FK foreign key (idEmpleado) references Empleados (idEmpleado),
Constraint TipoUsuarios_FK foreign key (idTipoUsuario) references TiposUsuarios (idTipoUsuario) 
alter table Nominas add
Constraint idEmpleado3_FK foreign key(idEmpleado)references Empleados(idEmpleado),
Constraint idFormaPago1_FK foreign key(idFormaPago)references FormasPago(idFormaPago)
alter table DocumentacionEmpleado add
Constraint idEmpleado4_FK foreign key(idEmpleado)references Empleados(idEmpleado)
alter table Ofertas add
Constraint idProducto3_FK foreign key(idProducto)references Productos(idProducto)
alter table VentasDetalle add
Constraint idPresentacion3_FK foreign key(idPresentacion)references PresentacionesProducto(idPresentacion)
alter table clientesCultivos add
Constraint idclientes2_FK foreign key(idCliente)references clientes(idCliente),
Constraint idcultivos2_FK foreign key(idCultivo)references cultivos(idCultivo),
Constraint idciudad4_FK foreign key(idCiudad)references Ciudades(idCiudad)
alter table Ventas add
Constraint idclientes3_FK foreign key(idCliente)references clientes(idCliente),
Constraint idSucursal3_FK foreign key(idSucursal)references Sucursales(idSucursal),
Constraint idEmpleado5_FK foreign key(idEmpleado)references Empleados(idEmpleado)
alter table Facturas add
Constraint idVentas2_FK foreign key(idVenta)references Ventas(idVentas)
alter table Visitas add
Constraint idclientesCultivos1_FK foreign key(idClienteCultivo)references clientesCultivos(idClienteCultivo),
Constraint idEmpleados1_FK foreign key(idEmpleado)references Empleados(idEmpleado),
Constraint idunidadTrasporte_FK foreign key(idUnidadTransporte)references UnidadesTransporte(idUnidadTransporte)
alter table Cobros add
Constraint idventas4_FK foreign key(idVenta)references Ventas(idVentas),
Constraint idFormaPagos_FK foreign key(idFormaPago)references FormasPago(idFormaPago)
alter table Mantenimientos add
Constraint idUnidadTransporte3_FK foreign key(idUnidadTransporte)references UnidadesTransporte(idUnidadTransporte)
alter table Envios add
Constraint idVenta5_FK foreign key(idVenta)references Ventas(idVentas),
Constraint UnidadesTransporte5_FK foreign key(idUnidadTransporte)references UnidadesTransporte(idUnidadTransporte),
Constraint Ciudades5_FK foreign key(idCiudad)references Ciudades(idCiudad)
alter table Tripulacion add
Constraint idEmpleados2_FK foreign key(idEmpleado)references Empleados(idEmpleado),
Constraint idEnvio_FK foreign key(idEnvio)references Envios(idEnvio)
alter table ExistenciasSucursal add
Constraint idPresentacio_FK foreign key(idPresentacion)references PresentacionesProducto(idPresentacion),
Constraint idsucursa_FK foreign key(idSucursal)references Sucursales(idSucursal)
alter table HistorialPuestos add
Constraint idEmpleados3_FK foreign key(idEmpleado)references Empleados(idEmpleado),
Constraint idPuesto2_FK foreign key(idPuesto)references Puestos(idPuesto),
Constraint idDepartamento1_FK foreign key(idDepartamento)references Departamentos(idDepartamento)
alter table nominasDeducciones add
Constraint idnomina_FK foreign key(idNomina)references Nominas(idNominas),
Constraint idsucursal5_FK foreign key(idDeducciones)references Deduccciones(idDeducciones)
alter table nominasPercepciones add
Constraint idnomina1_FK foreign key(idNomina)references Nominas(idNominas),
Constraint idPercepcion_FK foreign key(idPercepcion)references Percepciones(idPercepcion)
alter table Miembros add
Constraint idclientes6_FK foreign key(idCliente)references clientes(idCliente),
Constraint idasso_FK foreign key(idAsociacion)references Asociaciones(idAsociacion)
alter table OfertasAsociacion add
Constraint idasso1_FK foreign key(idAsociacion)references Asociaciones(idAsociacion),
Constraint idOfertas_FK foreign key(idAsociacion)references Ofertas (idOfertas)
alter table Miembros add
Constraint idCliente01_FK foreign key(idCliente)references Clientes(idCliente),
Constraint idasso01_FK foreign key(idAsociacion)references Asociaciones(idAsociacion)
alter table ProductosProveedor add
Constraint idProveedor001_FK foreign key(idProveedor)references Proveedores(idProveedor),
Constraint idPresentacio001n_FK foreign key(idPresentacion)references PresentacionesProducto(idPresentacion)

alter table AusenciasJustificadas add
Constraint iidEmpleadoS_FK foreign key(idEmpleadoS)references Empleados(idEmpleado)
create procedure asp_insertarUnidadMedida
@idUnidad int,
@nombre varchar(80),
@siglas varchar(20),
@status char
as 
begin 
insert into UnidadMedida values(@idUnidad,@nombre,@siglas,@status)
end

select * from EMPLEADOS
insert into Categorias
select * from Categorias
insert into UnidadMedida values(1,'mililitros','ml','A')
insert into UnidadMedida values(2,'kilos','kl','A')
insert into UnidadMedida values(3,'pulgada','plg','A')
insert into UnidadMedida values(4,'metros','mt','A')

insert into Estados values(1,'Michoacan','mich','A')
insert into Estados values(2,'Jalisco','jal','A')
insert into Estados values(3,'Ciudad De Mexico','Cdmx','A')
insert into Estados values(4,'Monterrey','Mty','A')

insert into CIUDADES values(1,'Jacona',1,'A')
insert into CIUDADES values(2,'Iztapalapa',3,'A')
insert into CIUDADES values(3,'nuevo leon',4,'A')
insert into CIUDADES values(4,'Zapopan',2,'A')

	insert into Sucursales values(1, 'Pinosuárez',    '5176940', 'Pinosuárez #83 Nte.', 'Centro', '59689', 10000, 'A', 1)
	insert into Sucursales values(2, 'Madero',        '5179560', 'Madero #300 Nte.', 'Centro', '59680', 20000, 'A', 2)
	insert into Sucursales values(3, '5 de Mayo',     '5184663', '5 de Mayo #601 Sur.', 'Jardines de Catedral', '59600', 30000, 'I', 3)
	insert into Sucursales values(4, 'Virrey de Mendoza', '5145890', 'Virrey de Mendoza #1260 Ote.', 'Jardinadas', '59689', 10000, 'A', 4)

	select* from EMPLEADOS
	insert into TiposUsuarios values(1,'Administrador','A')
	insert into TiposUsuarios values(2,'Empleado','A')

	insert into Usuarios values('jairdx','cindy','A',5,1)
	insert into Usuarios values('ragged','516','A',1,2)
	insert into Usuarios values('fernando','123','A',3,2)

	select * from Usuarios

	update Usuarios set estatus='I' where nombre='ragged'

	insert into Empleados values(5,'jair','elias','arroyo','M','07/07/2017','07/01/1997',1500.00,'1Q2W3E4R5T','Soltero',10,3,'1','shangari','el opeño','59833','Universidad',1.5,'A',1,1,1,1)
	insert into Empleados values(1,'carlos','gerardo','del rio pulido','M','08/01/2012','04/01/1977',1564.00,'1QBEARR5T','Casado',9,2,'10','Jesus carranza','el carmen','59620','Universidad',1.6,'A',2,2,2,2)
	--insert into EMPLEADOS(5,''


	select name from sys.tables where name like 'Emp%'


	-----------pruebas

	select * from Productos