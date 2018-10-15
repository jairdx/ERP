package frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jairdx
 */
public class connection {

    String conexionURL;
    Connection con = null;
    Statement stn = null;
    ResultSet rs = null;
    String cadenaSQL;
    int tipo1 = 0;
    public static String idUsuariol;
    DefaultTableModel m, n;
    String nom;

    public connection() {
        conexionURL = "jdbc:sqlserver:"
                + "//RAGGED516\\SQLEXPRESS:1033;"
                + "databaseName=Agroquimic;"
                + "user=adminOtro;password=admin";
        
//        conexionURL = "jdbc:sqlserver:"
//                + "//DESKTOP-C1F48VC\\SQLEXPRESS:1433;"
//                + "databaseName=Agroquimicaprueba;"
//                + "user=admin;password=admin1";
    }
    
    public void abreConexion() {
        try {
            con = DriverManager.getConnection(conexionURL);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*-----------------------------------------------------------
    Categorias todo lo referente a categorias esta a continuacion 
    ------------------------------------------------------------*/
    public void consultaCategorias(JTable tabla) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Categorias where estatus='A'";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String idCategoria = rs.getString("idCategoria");
                String nombre = rs.getString("nombre");
                String estatus = rs.getString("estatus");
                Object datosRenglon[] = {idCategoria, nombre, estatus};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultaCatAct(JTable tabla) {
        limpiarTabla(tabla);
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Categorias where estatus='A'";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String idCategoria = rs.getString("idCategoria");
                String nombre = rs.getString("nombre");
                String estatus = rs.getString("estatus");
                Object datosRenglon[] = {idCategoria, nombre, estatus};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultaCatIna(JTable tabla) {
        limpiarTabla(tabla);
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Categorias where estatus='I'";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String idCategoria = rs.getString("idCategoria");
                String nombre = rs.getString("nombre");
                String estatus = rs.getString("estatus");
                Object datosRenglon[] = {idCategoria, nombre, estatus};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultaBuscada(JTable tabla, String nomb) {
        limpiarTabla(tabla);
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Categorias where nombre ='" + nomb + "'";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String idCategoria = rs.getString("idCategoria");
                String nombre = rs.getString("nombre");
                String estatus = rs.getString("estatus");
                Object datosRenglon[] = {idCategoria, nombre, estatus};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultaCatTod(JTable tabla) {
        limpiarTabla(tabla);
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Categorias ";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String idCategoria = rs.getString("idCategoria");
                String nombre = rs.getString("nombre");
                String estatus = rs.getString("estatus");
                Object datosRenglon[] = {idCategoria, nombre, estatus};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultaCatTo1(JTable tabla) {
        limpiarTabla(tabla);
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Categorias ";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String idCategoria1 = rs.getString("idCategoria");
                String nombre1 = rs.getString("nombre");
                String estatus1 = rs.getString("estatus");
                Object datosRenglon[] = {idCategoria1, nombre1, estatus1};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertaCategoria(Object datos[], JTable tabla) {
        cadenaSQL = "insert into Categorias values ("
                + datos[0] + ",'"
                + datos[1] + "','"
                + datos[2] + "')";
        try {
            stn = (Statement) con.createStatement();
            stn.executeUpdate(cadenaSQL);
            limpiarConsultar(tabla);
            } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limpiarConsultar(JTable tabla) {
        DefaultTableModel tablaT = (DefaultTableModel) tabla.getModel();
        for (int i = tablaT.getRowCount() - 1; i > -1; i--) {
            tablaT.removeRow(i);
        }
        consultaCategorias(tabla);
    }

    public void limpiarConsultarMod(JTable tabla) {
        DefaultTableModel tablaT = (DefaultTableModel) tabla.getModel();
        for (int i = tablaT.getRowCount() - 1; i > -1; i--) {
            tablaT.removeRow(i);
        }
        consultaCatTo1(tabla);
    }

    public void limpiarTabla(JTable tabla) {
        DefaultTableModel tablaT = (DefaultTableModel) tabla.getModel();
        for (int i = tablaT.getRowCount() - 1; i > -1; i--) {
            tablaT.removeRow(i);
        }
    }

    public int consultaCategoriaID() {
        int idCategoria = 0;
        cadenaSQL = "select top(1) idCategoria from Categorias order by idCategoria desc";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                idCategoria = rs.getInt("idCategoria");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idCategoria;
    }

    public void EliminaFila(JTable tabla, String nombre) {
        int fsel, resp;
        try {
            fsel = tabla.getSelectedRow();
            if (fsel == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la categoria que desea desactivar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                resp = JOptionPane.showConfirmDialog(null, "¿Seguro que desea desactivar esta categoria?", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_OPTION) {
                    m = (DefaultTableModel) tabla.getModel();
                    m.removeRow(fsel);
                }
                cadenaSQL = "update Categorias set estatus='I' where nombre='" + nombre + "'";
                try {
                    stn = (Statement) con.createStatement();
                    stn.execute(cadenaSQL);
                    limpiarConsultar(tabla);
                } catch (SQLException ex) {
                    Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception e) {
            
        }
    }

    public void modificaCategoria(String name, int ID, String estatus, JTable tabla) {
        try {
            cadenaSQL = "update Categorias set nombre ='" + name + "', estatus ='" + estatus + "' where idCategoria=" + ID + "";
            try {
                stn = (Statement) con.createStatement();
                stn.execute(cadenaSQL);

            } catch (SQLException ex) {
                Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
        }
        limpiarConsultarMod(tabla);
    }

    public void traerDatoTextfield(JTable tabla, String nombre) {
        int fsel = tabla.getSelectedRow();
        try {
            String nombreCat, estatus;
            int ID;
            if (fsel == -1) {
                JOptionPane.showMessageDialog(null, "Debe de seleccionar un producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                m = (DefaultTableModel) tabla.getModel();
                ID = Integer.parseInt((String.valueOf(tabla.getValueAt(fsel, 0))));
                nombreCat = tabla.getValueAt(fsel, 1).toString();
                estatus = tabla.getValueAt(fsel, 2).toString();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Verificar seleccion de producto", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    //----------------------------------------------
    //METODOS PARA ACTUALIZAR UNA UNIDAD DE MEDIDA
    public void consultaUniTo1(JTable tabla) {
        limpiarTabla(tabla);
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from UnidadMedida ";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String nombre = rs.getString("idUnidad");
                String capacidad = rs.getString("nombre");
                String siglas = rs.getString("siglas");
                String unidad = rs.getString("estatus");
                Object datosRenglon[] = {nombre,capacidad,siglas, unidad};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificaUnidad(String name, int ID,String siglas, String estatus, JTable tabla) {
        try {
            cadenaSQL = "update UnidadMedida set nombre ='" + name + "', siglas ='" + siglas + "' , estatus= '" + estatus+ "' where idUnidad=" + ID + "";
           
            try {
                stn = (Statement) con.createStatement();
                stn.execute(cadenaSQL);

            } catch (SQLException ex) {
                Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
        }
        limpiarConsultarMo(tabla);
    }
public void limpiarConsultarMo(JTable tabla) {
        DefaultTableModel tablaT = (DefaultTableModel) tabla.getModel();
        for (int i = tablaT.getRowCount() - 1; i > -1; i--) {
            tablaT.removeRow(i);
        }
        consultaUniTo1(tabla);
    }

    // el siguiente metodo busca al usuario que se conecto al login para poder saber quien fue el que inicio sesion 
    public String consultaUser(String ID) {
        cadenaSQL = "select e.Nombre,e.Apaterno,e.Amaterno from EMPLEADOS e "
                + " inner join Usuarios u on e.idEmpleado=u.idEmpleado where u.Nombre= '" + ID
                + "' and e.estatus='A'";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String Apaterno = rs.getString("Apaterno");
                String Amaterno = rs.getString("Amaterno");
                nom = nombre + " " + Apaterno + " " + " " + Amaterno;
            }
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nom;
    }
    //el siguiente metodo sirve para buscar al usuario y hacer comprobaciones de a que menu ira dependiendo que en un futuro nos pidan esa opcion 
    public int login(String user, String pass) {
        int resultado = 0, encontro = 0, tipo = 0;

        cadenaSQL = "Select * from Usuarios where nombre= '" + user + "' and contrasenia= '" + pass + "'";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                idUsuariol = rs.getString("nombre");
                String contraseña = rs.getString("contrasenia");
                tipo = rs.getInt("idTipoUsuario");
                encontro = 1;
            }
            if (encontro == 1) {
                if (tipo == 1) {
                    resultado = 1;
                    tipo1 = 1;
                } else if (tipo == 2) {
                    resultado = 2;
                    tipo1 = 1;
                }
                JOptionPane.showMessageDialog(null, "Bienvenido");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no localizado ");
                resultado = 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    //Trae el ultimo ID de el empaque almacenado
    public int consulaEmpaque() {
        int idEmpaque = 0;
        cadenaSQL = "select top(1) idEmpaque from empaques order by idEmpaque desc";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                idEmpaque = rs.getInt("idEmpaque");
            }
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idEmpaque;
    }
    //inserta empaques en su tabla 
    public void insertaEmpaques(Object datos[]) {
        cadenaSQL = "insert into empaques values("
                + datos[0] + ",'"
                + datos[1] + "',"
                + datos[2] + ",'"
                + datos[3] + "',"
                + datos[4] + ")";
        try {
            stn = (Statement) con.createStatement();
            stn.executeUpdate(cadenaSQL);
            JOptionPane.showMessageDialog(null, "Dato Insertado");
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //hace un eliminado logico de la tabla en cuestion 
    public void EliminarEmpaque(String id) {
        cadenaSQL = "update empaques set estatus= 'I' where idEmpaque=" + id;
        try {
            stn = (Statement) con.createStatement();
            stn.executeUpdate(cadenaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void EliminarLab(String id) {
        cadenaSQL = "update laboratorios set estatus= 'I' where idLaboratorio=" + id;
        try {
            stn = (Statement) con.createStatement();
            stn.executeUpdate(cadenaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteUnidadMedia(String nombre) {
        cadenaSQL = "update UnidadMedida set Status='I' where nombre="
                + "'" + nombre.toString() + "'";
        try {
            stn = (Statement) con.createStatement();
            stn.executeUpdate(cadenaSQL);
            JOptionPane.showMessageDialog(null, "i done babe");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "i can't do it babe :(");
        }
    }
   //------------------------------------------------------
    //actualizar general de la tablas 
    public void Actualizar(Object datos[]) {
        cadenaSQL = "update empaques set nombre='" + datos[1].toString() + "',capacidad=" + datos[2].toString() + ",estatus='" + datos[3].toString() + "' where idEmpaque=" + datos[0].toString();
        try {
            stn = (Statement) con.createStatement();
            stn.executeUpdate(cadenaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ActualizarLab(Object datos[]) {
        cadenaSQL = "update laboratorios set nombre='" + datos[1].toString() + "',origen='" + datos[2].toString() + "',estatus='" + datos[3].toString() + "' where idLaboratorio=" + datos[0].toString();
        try {
            stn = (Statement) con.createStatement();
            stn.executeUpdate(cadenaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//---------------------------------------------------
    //--consulta unicamente los empaques activos 
    public void consultaTodosEmpaquesActivos(JTable tabla) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "select e.idEmpaque,e.nombre,e.capacidad,UM.nombre as unidad,e.estatus from empaques e "
                + "inner join UnidadMedida UM on e.idUnidad=UM.idUnidad where e.estatus='A'";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String idEmpaque = rs.getString("idEmpaque");
                String nombreE = rs.getString("nombre");
                String Capacidad = rs.getString("capacidad");
                String NombreU = rs.getString("unidad");
                String estatus = rs.getString("estatus");
                Object datosRenglon[] = {idEmpaque, nombreE, Capacidad, NombreU, estatus};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//consulta id ultimo de unidad medida 
    public int consultaidUnidadMedia() {
        int id = 0;
        cadenaSQL = "select top(1) idUnidad from UnidadMedida order by idUnidad desc";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                id = rs.getInt("idUnidad");
            }
        } catch (Exception ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
//inserta laboratorios 
    public void insertaLaboratorio(Object datos[]) {
        cadenaSQL = "insert into Laboratorios values ("
                + datos[0] + ",'"
                + datos[1] + "','"
                + datos[2] + "','"
                + datos[3] + "')";

        try {
            stn = (Statement) con.createStatement();
            stn.executeUpdate(cadenaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//consulta ultima id de laboratorio
    public int consultaLaboID() {
        int idLaboratorio = 0;
        cadenaSQL = "select top(1) idLaboratorio from Laboratorios order by idLaboratorio desc";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                idLaboratorio = rs.getInt("idLaboratorio");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idLaboratorio;
    }
//consulta TODOS los laboratorios en la base
    public void consultaLaboratorios(JTable tabla) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Laboratorios";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String idLaboratorio = rs.getString("idLaboratorio");
                String nombre = rs.getString("nombre");
                String origen = rs.getString("origen");
                String estatus = rs.getString("estatus");
                Object datosRenglon[] = {idLaboratorio, nombre, origen, estatus};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//consulta labos activos
    public void consultaLaboratoriosActivos(JTable tabla) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Laboratorios where estatus='A'";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String idLaboratorio = rs.getString("idLaboratorio");
                String nombre = rs.getString("nombre");
                String origen = rs.getString("origen");
                String estatus = rs.getString("estatus");
                Object datosRenglon[] = {idLaboratorio, nombre, origen, estatus};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//consulta labos activos donde el usuario te diga el numero del labo
    public void consultaLaboratorioActivo(JTable tabla, int id) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Laboratorios where estatus='A' and idLaboratorio= " + id;
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String idLaboratorio = rs.getString("idLaboratorio");
                String nombre = rs.getString("nombre");
                String origen = rs.getString("origen");
                String estatus = rs.getString("estatus");
                Object datosRenglon[] = {idLaboratorio, nombre, origen, estatus};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//inserta en la tabla de unidad medida
    public void insertUnidadMedida(Object datos[]) {
        cadenaSQL = "execute asp_insertarUnidadMedida "
                + datos[0].toString() + ",'"
                + datos[1].toString() + "','"
                + datos[2].toString() + "','"
                + datos[3].toString() + "'";
        try {
            stn = (Statement) con.createStatement();
            stn.executeUpdate(cadenaSQL);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pueden ingresar los datos");
        }
    }
//consulta todos en unidad medida
    public void consultaALLUnidadMedida(JTable tabla) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "select* from UnidadMedida ";
        tablaTemp.addColumn("Id de unidad");
        tablaTemp.addColumn("Nombre");
        tablaTemp.addColumn("Siglas");
        tablaTemp.addColumn("Status");
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String a = rs.getString("idUnidad");
                String b = rs.getString("nombre");
                String c = rs.getString("siglas");
                String d = rs.getString("estatus");
                Object datosRenglon[] = {a, b, c, d};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//consulta todos activos en unidad medida
    public void consultaTodosUnidadMedida(JTable tabla) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "select idUnidad,nombre,siglas from UnidadMedida where estatus='A'";
        tablaTemp.addColumn("Id de unidad");
        tablaTemp.addColumn("Nombre");
        tablaTemp.addColumn("Siglas");
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String a = rs.getString("idUnidad");
                String b = rs.getString("nombre");
                String c = rs.getString("siglas");
                Object datosRenglon[] = {a, b, c};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//y actualiza todo en unidad medida 
    public void UpdateUnidadMedia(Object datos[]) {
        cadenaSQL = "update UnidadMedida set nombre='" + datos[1].toString() + "', siglas='" + datos[2].toString() + "', Status='" + datos[3].toString() + "' where idUnidad=" + datos[0].toString();
        try {
            stn = (Statement) con.createStatement();
            stn.executeUpdate(cadenaSQL);
            JOptionPane.showMessageDialog(null, "i done babe");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "i can't do it babe :(");
        }
    }
//consulta todos los empaques que esten inactivos por si el usuario quiere regresar uno
    public void consultaTodosEmpaquesInabilitados(JTable tabla) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "select e.idEmpaque,e.nombre,e.capacidad,UM.nombre as unidad,e.estatus from empaques e "
                + "inner join UnidadMedida UM on e.idUnidad=UM.idUnidad where e.estatus='I'";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String idEmpaque = rs.getString("idEmpaque");
                String nombreE = rs.getString("nombre");
                String Capacidad = rs.getString("capacidad");
                String NombreU = rs.getString("unidad");
                String Estatus = rs.getString("estatus");
                Object datosRenglon[] = {idEmpaque, nombreE, Capacidad, NombreU, Estatus};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//consulta empaques especificos que esten activos
    public void consultaEmpaques(JTable tabla, int ID) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "select e.idEmpaque,e.nombre,e.capacidad,e.estatus,UM.nombre as unidad from empaques e "
                + "inner join UnidadMedida UM on e.idUnidad=UM.idUnidad where e.idEmpaque= " + ID
                + "and e.estatus='A'";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String idEmpaque = rs.getString("idEmpaque");
                String nombreE = rs.getString("nombre");
                String Capacidad = rs.getString("capacidad");
                String Estatus = rs.getString("estatus");
                String NombreU = rs.getString("unidad");
                Object datosRenglon[] = {idEmpaque, nombreE, Capacidad, Estatus, NombreU};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//consulta todos los empaques con un inner join
    public void consultaTodosEmpaquesTodes(JTable tabla) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "select e.idEmpaque,e.nombre,e.capacidad,UM.nombre as unidad,e.estatus from empaques e "
                + "inner join UnidadMedida UM on e.idUnidad=UM.idUnidad";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String idEmpaque = rs.getString("idEmpaque");
                String nombreE = rs.getString("nombre");
                String Capacidad = rs.getString("capacidad");
                String NombreU = rs.getString("unidad");
                String Estatus = rs.getString("estatus");
                Object datosRenglon[] = {idEmpaque, nombreE, Capacidad, NombreU, Estatus};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
