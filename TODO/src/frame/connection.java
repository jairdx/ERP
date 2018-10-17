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
                + "//DESKTOP-5QLATER\\SQLEXPRESS:1433;"
                + "databaseName=Agroquimic;"
                + "user=admin;password=Admin123";
        
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
//METODOS PARA ACTUALIZAR UN LABORATORIO
    public void consultaLabTo1(JTable tabla) {
        limpiarTabla(tabla);
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Laboratorios ";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String id = rs.getString("idLaboratorio");
                String nombre = rs.getString("nombre");
                String origen  = rs.getString("origen");
                String estatus = rs.getString("estatus");
                Object datosRenglon[] = {id,nombre,origen,estatus};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificaLaboratorio(String name, int ID,String origen, String estatus, JTable tabla) {
        try {
            cadenaSQL = "update Laboratorios set nombre ='" + name + "', origen ='" + origen + "' , estatus= '" + estatus+ "' where idLaboratorio=" + ID + "";
           
            try {
                stn = (Statement) con.createStatement();
                stn.execute(cadenaSQL);

            } catch (SQLException ex) {
                Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
        }
        limpiarConsultarM(tabla);
    }
    public void limpiarConsultarM(JTable tabla) {
        DefaultTableModel tablaT = (DefaultTableModel) tabla.getModel();
        for (int i = tablaT.getRowCount() - 1; i > -1; i--) {
            tablaT.removeRow(i);
        }
        consultaLabTo1(tabla);
    }
    //METODOS PARA ACTUALIZAR UN EMPAQUE
    public void consultaEmpTo1(JTable tabla) {
        limpiarTabla(tabla);
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Empaques ";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String id = rs.getString("idEmpaque");
                String nombre = rs.getString("nombre");
                String capacidad  = rs.getString("capacidad");
                String estatus = rs.getString("estatus");
                String idUnidad= rs.getString("idUnidad");
                Object datosRenglon[] = {id,nombre,capacidad,estatus,idUnidad};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificaEmpaque(String name, int ID,String capacidad, String estatus,int idUnidad, JTable tabla) {
        try {
            cadenaSQL = "update Empaques set nombre ='" + name + "', capacidad ='" + capacidad + "' , estatus= '" + estatus+"' , idUnidad= '" + idUnidad+ "' where idEmpaque=" + ID + "";
           
            try {
                stn = (Statement) con.createStatement();
                stn.execute(cadenaSQL);

            } catch (SQLException ex) {
                Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
        }
        limpiarConsultarEmp(tabla);
    }
    public void limpiarConsultarEmp(JTable tabla) {
        DefaultTableModel tablaT = (DefaultTableModel) tabla.getModel();
        for (int i = tablaT.getRowCount() - 1; i > -1; i--) {
            tablaT.removeRow(i);
        }
        consultaEmpTo1(tabla);
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
//----------------------------------------------------------------------------------------
    
    public void consultaTodosProductos(JTable tabla) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "select idProducto, nombre, descripcion, puntoReorden, precioCompra, precioVenta, ingredienteActivo, "
                + "bandaToxicologica, aplicacion, uso, idLaboratorio, idCategoria from Productos where estatus = '1'";
        
        tablaTemp.addColumn("Id de unidad");
        tablaTemp.addColumn("Nombre");
        tablaTemp.addColumn("Descripcion");
        tablaTemp.addColumn("Punto de Reorden");
        tablaTemp.addColumn("Precio de Compra");
        tablaTemp.addColumn("Precio de Venta");
        tablaTemp.addColumn("Ingrediente Activo");
        tablaTemp.addColumn("Banda Toxicologica");
        tablaTemp.addColumn("Aplicacion");
        tablaTemp.addColumn("Uso");
        tablaTemp.addColumn("ID Laboratorio");
        tablaTemp.addColumn("ID Categoria");
        
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String a = rs.getString("idProducto");
                String b = rs.getString("nombre");
                String c = rs.getString("descripcion");
                String d = rs.getString("puntoReorden");
                String e = rs.getString("precioCompra");
                String f = rs.getString("precioVenta");
                String g = rs.getString("ingredienteActivo");
                String h = rs.getString("bandaToxicologica");
                String i = rs.getString("aplicacion");
                String j = rs.getString("idLaboratorio");
                String k = rs.getString("idCategoria");
                
                Object datosRenglon[] = {a, b, c, d, e, f, g, h, i, j, k};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int consultaidProducto() {
        int id = 0;
        cadenaSQL = "select top(1) idProducto from Productos order by idProducto desc";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                id = rs.getInt("idProducto");
            }
        } catch (Exception ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public void insertarProductos(Object datos[]) {
        cadenaSQL = 
                "insert into Productos values (" + datos[0] + ",'" + datos[1] + "','" + datos[2] + "'," + datos[3] + ","
                + datos[4] + "," + datos[5] + ",'" + datos[6] + "','" + datos[7] + "','" + datos[8] + "','" + datos[9] + "',"
                + datos[10] + "," + datos[11] + "," + datos[12] + ")";

        try {
            stn = (Statement) con.createStatement();
            stn.executeUpdate(cadenaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultaPro(JTable tabla) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Productos where estatus='1'";
        
        tablaTemp.addColumn("Id de unidad");
        tablaTemp.addColumn("Nombre");
        tablaTemp.addColumn("Descripcion");
        tablaTemp.addColumn("Punto de Reorden");
        tablaTemp.addColumn("Precio de Compra");
        tablaTemp.addColumn("Precio de Venta");
        tablaTemp.addColumn("Ingrediente Activo");
        tablaTemp.addColumn("Banda Toxicologica");
        tablaTemp.addColumn("Aplicacion");
        tablaTemp.addColumn("Uso");
        tablaTemp.addColumn("ID Laboratorio");
        tablaTemp.addColumn("ID Categoria");
        
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String a = rs.getString("idProducto");
                String b = rs.getString("nombre");
                String c = rs.getString("descripcion");
                String d = rs.getString("puntoReorden");
                String e = rs.getString("precioCompra");
                String f = rs.getString("precioVenta");
                String g = rs.getString("ingredienteActivo");
                String h = rs.getString("bandaToxicologica");
                String i = rs.getString("aplicacion");
                String j = rs.getString("idLaboratorio");
                String k = rs.getString("idCategoria");
                
                Object datosRenglon[] = {a, b, c, d, e, f, g, h, i, j, k};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultaProAct(JTable tabla) {
        limpiarTabla(tabla);
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Productos where estatus='1'";
        
        tablaTemp.addColumn("Id de unidad");
        tablaTemp.addColumn("Nombre");
        tablaTemp.addColumn("Descripcion");
        tablaTemp.addColumn("Punto de Reorden");
        tablaTemp.addColumn("Precio de Compra");
        tablaTemp.addColumn("Precio de Venta");
        tablaTemp.addColumn("Ingrediente Activo");
        tablaTemp.addColumn("Banda Toxicologica");
        tablaTemp.addColumn("Aplicacion");
        tablaTemp.addColumn("Uso");
        tablaTemp.addColumn("ID Laboratorio");
        tablaTemp.addColumn("ID Categoria");
        
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String a = rs.getString("idProducto");
                String b = rs.getString("nombre");
                String c = rs.getString("descripcion");
                String d = rs.getString("puntoReorden");
                String e = rs.getString("precioCompra");
                String f = rs.getString("precioVenta");
                String g = rs.getString("ingredienteActivo");
                String h = rs.getString("bandaToxicologica");
                String i = rs.getString("aplicacion");
                String j = rs.getString("idLaboratorio");
                String k = rs.getString("idCategoria");
                
                Object datosRenglon[] = {a, b, c, d, e, f, g, h, i, j, k};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultaProIna(JTable tabla) {
        limpiarTabla(tabla);
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Productos where estatus='0'";
        
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String a = rs.getString("idProducto");
                String b = rs.getString("nombre");
                String c = rs.getString("descripcion");
                String d = rs.getString("puntoReorden");
                String e = rs.getString("precioCompra");
                String f = rs.getString("precioVenta");
                String g = rs.getString("ingredienteActivo");
                String h = rs.getString("bandaToxicologica");
                String i = rs.getString("aplicacion");
                String j = rs.getString("idLaboratorio");
                String k = rs.getString("idCategoria");
                
                Object datosRenglon[] = {a, b, c, d, e, f, g, h, i, j, k};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultaProBuscada(JTable tabla, String nomb) {
        limpiarTabla(tabla);
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Productos where nombre ='" + nomb + "'";
        
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String a = rs.getString("idProducto");
                String b = rs.getString("nombre");
                String c = rs.getString("descripcion");
                String d = rs.getString("puntoReorden");
                String e = rs.getString("precioCompra");
                String f = rs.getString("precioVenta");
                String g = rs.getString("ingredienteActivo");
                String h = rs.getString("bandaToxicologica");
                String i = rs.getString("aplicacion");
                String j = rs.getString("idLaboratorio");
                String k = rs.getString("idCategoria");
                
                Object datosRenglon[] = {a, b, c, d, e, f, g, h, i, j, k};
                tablaTemp.addRow(datosRenglon);
                
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultaProTod(JTable tabla) {
        limpiarTabla(tabla);
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Productos ";
        
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String a = rs.getString("idProducto");
                String b = rs.getString("nombre");
                String c = rs.getString("descripcion");
                String d = rs.getString("puntoReorden");
                String e = rs.getString("precioCompra");
                String f = rs.getString("precioVenta");
                String g = rs.getString("ingredienteActivo");
                String h = rs.getString("bandaToxicologica");
                String i = rs.getString("aplicacion");
                String j = rs.getString("idLaboratorio");
                String k = rs.getString("idCategoria");
                
                Object datosRenglon[] = {a, b, c, d, e, f, g, h, i, j, k};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultaProductoID(JTable tabla, int id) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from Productos where estatus = '1' and idProducto = " + id;        
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String a = rs.getString("idProducto");
                String b = rs.getString("nombre");
                String c = rs.getString("descripcion");
                String d = rs.getString("puntoReorden");
                String e = rs.getString("precioCompra");
                String f = rs.getString("precioVenta");
                String g = rs.getString("ingredienteActivo");
                String h = rs.getString("bandaToxicologica");
                String i = rs.getString("aplicacion");
                String j = rs.getString("idLaboratorio");
                String k = rs.getString("idCategoria");
                
                Object datosRenglon[] = {a, b, c, d, e, f, g, h, i, j, k};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void EliminarProducto(String id) {
        cadenaSQL = "update Productos set estatus = '0' where idProducto = " + id;
        try {
            stn = (Statement) con.createStatement();
            stn.executeUpdate(cadenaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void ActualizarProducto(Object datos[]) {
        //cadenaSQL = "update Productos set nombre='" + datos[1].toString() + "',origen='" + datos[2].toString() + "',estatus='" + datos[3].toString() + "' where idLaboratorio=" + datos[0].toString();
        cadenaSQL = "update Productos set nombre = '" + datos[1] + "', descripcion = '" + datos[2].toString() + "', puntoReorden = " + datos[3].toString() + ", precioCompra = " + datos[4].toString() + 
                ", precioVenta = " + datos[5].toString() + ", ingredienteActivo = '" + datos[6].toString() + "', bandaToxicologica = '" + datos[7].toString() + "', aplicacion = '" + datos[8].toString() + 
                "', idLaboratorio = " + datos[9].toString() + ", idCategoria = " + datos[10].toString() + " where idProducto = " + datos[0].toString();
        try {
            stn = (Statement) con.createStatement();
            stn.executeUpdate(cadenaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //------------------------------------------------------------------------------------
    
    public void insertarPago(Object datos[]) {
        cadenaSQL = 
                "insert into Pagos values (" + datos[0] + ",'" + datos[1] + "', " + datos[2] + " ," + datos[3] + ","
                + datos[4] + "," + datos[5] + " )";

        try {
            stn = (Statement) con.createStatement();
            stn.executeUpdate(cadenaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultaTodosPagos(JTable tabla) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "select * From Pagos ";
        
        tablaTemp.addColumn("ID Pago");
        tablaTemp.addColumn("Fecha");
        tablaTemp.addColumn("Importe");
        tablaTemp.addColumn("ID Pedido");
        tablaTemp.addColumn("ID Forma de Pago");
        tablaTemp.addColumn("ID Cuenta Proveedor");
        
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String a = rs.getString("idPagos");
                String b = rs.getString("fecha");
                String c = rs.getString("importe");
                String d = rs.getString("idPedido");
                String e = rs.getString("idFormaPago");
                String f = rs.getString("idCuentaProveedor");
                
                Object datosRenglon[] = {a, b, c, d, e, f};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int consultaidPago() {
        int id = 0;
        cadenaSQL = "select top(1) idPagos from Pagos order by idPagos desc";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                id = rs.getInt("idPagos");
            }
        } catch (Exception ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
     //  ------------------------------------------consultas-----------------------------------------------
 public void consultaprov(JTable tabla) {
        limpiarTabla(tabla);
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "Select * from proveedores ";
        tablaTemp.addColumn("ID Proveedor");
        tablaTemp.addColumn("Nombre");
        tablaTemp.addColumn("Telefono");
        tablaTemp.addColumn("E-mail");
        tablaTemp.addColumn("Direccion");
        tablaTemp.addColumn("Colonia");
        tablaTemp.addColumn("Codigo posal");
        tablaTemp.addColumn("ID Ciudad");
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String idProveedor = rs.getString("idProveedor");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String direccion = rs.getString("direccion");
                String colonia = rs.getString("colonia");
                String codigopostar = rs.getString("codigopostar");
                String idCiudad = rs.getString("idCiudad");
                Object datosRenglon[] = {idProveedor, nombre, telefono, email,direccion,colonia,codigopostar,idCiudad};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 
  public void consultaPedidos(JTable tabla) {
        limpiarTabla(tabla);
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "select * from pedidos ";
        tablaTemp.addColumn("ID Pedido");
        tablaTemp.addColumn("Fecha de registro");
        tablaTemp.addColumn("Fecha de recepcion");
        tablaTemp.addColumn("Total a pagar");
        tablaTemp.addColumn("Cant. pagada");
        tablaTemp.addColumn("Estatus");
        tablaTemp.addColumn("ID Proveedor");
        tablaTemp.addColumn("ID Sucursal");
        tablaTemp.addColumn("ID Empleado");
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String idPedido = rs.getString("idPedido");
                String FechaRegistro = rs.getString("FechaRegistro");
                String FechaRecepcion = rs.getString("FechaRecepcion");
                String totalPagar = rs.getString("totalPagar");
                String cantidadPagada = rs.getString("cantidadPagada");
                String estatus = rs.getString("estatus");
                String idProveedor = rs.getString("idProveedor");
                String idSucursal = rs.getString("idSucursal");
                String idEmpleado = rs.getString("idEmpleado");
                Object datosRenglon[] = {idPedido, FechaRegistro, FechaRecepcion, totalPagar, cantidadPagada,estatus,idProveedor,idSucursal,idEmpleado
                };
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
      public int consultaIDPedidos() {
        int idPedido = 0;
        cadenaSQL = "select top(1) idPedido from Pedidos order by idPedido desc ";
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                idPedido = rs.getInt("idPedido");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idPedido;
    }
 
    public void consultaPedidosEstatus(JTable tabla) {
        limpiarTabla(tabla);
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        cadenaSQL = "select * from pedidos where estatus='D' ";
        tablaTemp.addColumn("ID Pedido");
        tablaTemp.addColumn("Fecha de registro");
        tablaTemp.addColumn("Fecha de recepcion");
        tablaTemp.addColumn("Total a pagar");
        tablaTemp.addColumn("Cant. pagada");
        tablaTemp.addColumn("Estatus");
        tablaTemp.addColumn("ID Proveedor");
        tablaTemp.addColumn("ID Sucursal");
        tablaTemp.addColumn("ID Empleado");
        try {
            stn = (Statement) con.createStatement();
            rs = stn.executeQuery(cadenaSQL);
            while (rs.next()) {
                String idPedido = rs.getString("idPedido");
                String FechaRegistro = rs.getString("FechaRegistro");
                String FechaRecepcion = rs.getString("FechaRecepcion");
                String totalPagar = rs.getString("totalPagar");
                String cantidadPagada = rs.getString("cantidadPagada");
                String estatus = rs.getString("estatus");
                String idProveedor = rs.getString("idProveedor");
                String idSucursal = rs.getString("idSucursal");
                String idEmpleado = rs.getString("idEmpleado");
                Object datosRenglon[] = {idPedido, FechaRegistro, FechaRecepcion, totalPagar, cantidadPagada,estatus,idProveedor,idSucursal,idEmpleado
                };
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    //-----------------------Para Insetar datos------------------------------------------
    
        public void insertarPedido(Object datos[],JTable tabla) {
        cadenaSQL = "INSERT into Pedidos  VALUES ("+ datos[0].toString() + ",'" //int
                + datos[1].toString() + "','" //varchar
                + datos[2].toString() + "',"//Varchar
                + datos[3].toString() + "," //float
                + datos[4].toString() + ",'"  //float
                + datos[5].toString() + "',"  //char
                + datos[6].toString() + ","   //int
                + datos[7].toString() + ","   //int
                + datos[8].toString() + ",)"; //int
      
        try {
            stn = (Statement) con.createStatement();
            stn.executeUpdate(cadenaSQL);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pueden ingresar los datos");
        }
    }

//            public void insertarPedido( int iIdPedido, String sFechaDeregistro, String sFechaRecepcion,float fTotalApagar,float fCantidadPagada, char chEstatus,int iIdProveedor,int iIdSucursal, int IidEmpleado) {
//    cadenaSQL= "exec InsertPedi "+iIdPedido",'"+sFechaDeregistro+"','"+sFechaRecepcion+"',"+fTotalApagar","+fCantidadPagada",'"+chEstatus+"',"+iIdProveedor","+iIdSucursal","+IidEmpleado",";
////            +  Integer.parseInt(String.valueOf(datos[0])) + ",'"
////            + datos[1] + "','"
////            + datos[2] + "','"
////            + datos[3] + "'" ;
//        
//        try {
//            con=DriverManager.getConnection(conexionURL);
//            stn = (Statement) con.createStatement();
//            rs = stn.executeQuery(cadenaSQL);
//            JOptionPane.showMessageDialog(null, "Datos Ingresados");
//        }catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "EL LABORATORIO YA EXISTE" + ex);
//        }
//    
//            }   
}
