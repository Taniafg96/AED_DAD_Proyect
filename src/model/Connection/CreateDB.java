package model.Connection;

/**
 *
 * @author tania
 */

import java.sql.*;
/**
 *
 * @author Usuario
 */

public class CreateDB{
    private static final String DATABASE = "jdbc:mysql://localhost:3306/";
    private static final String DATABASENAME = "AED_DAD";
    private String user = "root";
    private String password = "admin";
            
    public CreateDB(String user, String password){
        this.user = user;
        this.password = password;
        create();
        createTableAlmacen();
        createTableProductos();
        createTableUsuarios();
        createTableClientes();
        createTableVentas();
        insertValues();
    }
    
    private void create(){
        try (Connection connect = DriverManager.getConnection(DATABASE, user, password);
                Statement db = connect.createStatement();){
            db.executeUpdate("create database " + DATABASENAME);
            System.out.println("La base de Datos se ha creado con exito");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void createTableAlmacen(){
        try (Connection connect = DriverManager.getConnection(DATABASE + DATABASENAME, user, password);
                Statement db = connect.createStatement();){
            db.executeUpdate("CREATE TABLE Almacen(\n" +
                            "	 codigo varchar(10),\n" +
                            "    tamanio int,\n" +
                            "    direccion varchar(200),\n" +
                            "    nEmpleados int,\n" +
                            "    primary key (codigo)\n" +
                            ")");
            System.out.println("La tabla Almacen se ha creado con exito");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void createTableProductos(){
        try (Connection connect = DriverManager.getConnection(DATABASE + DATABASENAME, user, password);
                Statement db = connect.createStatement();){
            db.executeUpdate("CREATE TABLE Productos(\n" +
                            "	 codigo varchar(13),\n" +
                            "    nombre varchar(50),\n" +
                            "    tipo varchar(50),\n" +
                            "    descripcion varchar(200),\n" +
                            "    precio decimal (6,2),\n" +
                            "    cod_almacen varchar(10),\n" +
                            "    primary key (codigo),\n" +
                            "    foreign key (cod_almacen) references Almacen(codigo)\n" +
                            ")");
            System.out.println("La tabla Productos se ha creado con exito");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    private void createTableUsuarios(){
        try (Connection connect = DriverManager.getConnection(DATABASE + DATABASENAME, user, password);
                Statement db = connect.createStatement();){
            db.executeUpdate("CREATE TABLE Usuarios(\n" +
                            "	dni varchar(9),\n" +
                            "    nombre varchar(20),\n" +
                            "    apellidos varchar(50),\n" +
                            "    contrasenia varchar(20),\n" +
                            "    rol varchar(20), \n" +
                            "    permisos  varchar(50),\n" +
                            "    primary key (dni)\n" +
                            ")");
            System.out.println("La tabla Usuarios se ha creado con exito");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void createTableClientes(){
        try (Connection connect = DriverManager.getConnection(DATABASE + DATABASENAME, user, password);
                Statement db = connect.createStatement();){
            db.executeUpdate("CREATE TABLE Clientes(\n" +
                            "	 Id varchar (20),\n" +
                            "    Nombre varchar (50),\n" +
                            "    Direccion varchar (200),\n" +
                            "    Telefono varchar(9),\n" +
                            "    Correo varchar (30),\n" +
                            "    primary key (Id)\n" +
                            ")");
            System.out.println("La tabla Clientes se ha creado con exito");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void createTableVentas(){
        try (Connection connect = DriverManager.getConnection(DATABASE + DATABASENAME, user, password);
                Statement db = connect.createStatement();){
            db.executeUpdate("CREATE TABLE Ventas(\n" +
                            "    Id_Venta int NOT NULL AUTO_INCREMENT,\n" +
                            "	 CantidadProducto int,\n" +
                            "    PrecioTotal decimal (6,2),\n" +
                            "    DNI_Empleado varchar (9),\n" +
                            "    codigo_producto varchar (10),\n" +
                            "    id_cliente varchar (20),\n" +
                            "    primary key (Id_Venta), \n" +
                            "    foreign key (DNI_Empleado) references Usuarios(dni),\n" +
                            "    foreign key (codigo_producto) references Productos (codigo),\n" +
                            "    foreign key (id_cliente) references Clientes (Id)\n" +
                            ")");
            System.out.println("La tabla Ventas se ha creado con exito");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void insertValues(){
        try (Connection connect = DriverManager.getConnection(DATABASE + DATABASENAME, user, password);
            Statement db = connect.createStatement();){
            db.executeUpdate("insert into Almacen values ('QWERTY001', 200, 'C/ Manolo Nº3 Santa Cruz', 20)");
            
            db.executeUpdate("insert into Productos values ('12345678', 'Ratón', 'Electrónico', null, 5,'QWERTY001')");
            db.executeUpdate("insert into Productos values ('23456789', 'Teclado', 'Electrónico', null, 120,'QWERTY001')");
            db.executeUpdate("insert into Productos values ('98349530', 'Monitor', 'Electrónico', null, 250,'QWERTY001')");
            db.executeUpdate("insert into Productos values ('45436222', 'Torre', 'Electrónico', null, 40,'QWERTY001')");
            db.executeUpdate("insert into Productos values ('99485932', 'Silla', 'Mueble', null, 50,'QWERTY001')");
            db.executeUpdate("insert into Productos values ('11233394', 'Aire comprimido', 'Accesorio', null, 5,'QWERTY001')");
            
            
            db.executeUpdate("insert into Usuarios values ('11111111A', 'Administrador', 'root', 'password', 'QAZWSX123', 'administrador')");
            db.executeUpdate("insert into Usuarios values ('22222222B', 'Juan', 'Pérez', '1234', 'PLMOKN123', 'normal')");
            db.executeUpdate("insert into Usuarios values ('33333333C', 'Ana', 'Castillo', '1234', 'PLMOKN123', 'normal')");
            db.executeUpdate("insert into Usuarios values ('44444444D', 'Luca', 'Padrón', '1234', 'PLMOKN123', 'normal')");
            
            db.executeUpdate("insert into Clientes values ('QAZ123', 'María López', 'C/ Random Nº10 La Laguna', '664738283', 'marialopez@gmail.com')");
            db.executeUpdate("insert into Clientes values ('WSX456', 'Juan Piedra', 'C/ Aleatorio Nº4 Santa Cruz', '663090909', 'juanpiedra@gmail.com')");

            
            System.out.println("Se han insertado los valores con exito");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
