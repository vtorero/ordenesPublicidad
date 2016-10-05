/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.dao;

import com.ordenes.modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vjimenez
 */
public class ClienteDao extends Dao {  
     
    public void registrar(Cliente cli) throws Exception{
       try {
       this.Conectar();
           PreparedStatement st = this.getCn().prepareStatement("INSERT INTO ORD_CLIENTES(RAZON_SOCIAL,CONTACTO,RPT_LEGAL,RPT_DNI,RPT_DIRECCION,RUC" +
            ",DIRECCION,TELEFONO,F_CREACION,USUARIO) values(?,?,?,?,?,?,?,?,now(),'USUARIO')");
           st.setString(1, cli.getRazonsocial());
           st.setString(2,cli.getContacto());
           st.setString(3, cli.getRptlegal());
           st.setString(4, cli.getRptdni());
           st.setString(5, cli.getRptdireccion());
           st.setString(6, cli.getRuc());
           st.setString(7, cli.getDireccion());
           st.setString(8, cli.getTelefono());
           
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
       }
   }
     
public List<Cliente> listar() throws Exception{
   List<Cliente> lista;
   ResultSet rs;
   
       try {
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("SELECT C_CLIENTE,RAZON_SOCIAL,CONTACTO,RPT_LEGAL,RPT_DNI,RPT_DIRECCION,RUC,DIRECCION,TELEFONO,F_CREACION,USUARIO FROM ord_clientes");
           rs = st.executeQuery();
           lista = new ArrayList<>();
           while(rs.next()){
         Cliente cli = new Cliente();
         cli.setC_cliente(rs.getString("C_CLIENTE"));
         cli.setRazonsocial(rs.getString("RAZON_SOCIAL"));
         cli.setContacto(rs.getString("CONTACTO"));
         cli.setRptlegal(rs.getString("RPT_LEGAL"));
         cli.setRptdni(rs.getString("RPT_DNI"));
         cli.setRptdireccion(rs.getString("RPT_DIRECCION"));
         cli.setRuc(rs.getString("RUC"));
         cli.setDireccion(rs.getString("DIRECCION"));
         cli.setTelefono(rs.getString("TELEFONO"));
          lista.add(cli);
           }
       } catch (Exception e) {
           throw e;
           
             
       }
       finally{
       this.Cerrar();
       }
       return lista;
   }
            
                   
public int modificar(String razon,String contacto,String rpt_legal,String dni,String rpt_direccion,String ruc ,String direccion,String telefono,int codigo) throws Exception{
     int numFa = 0;
       try {
           
       this.Conectar();
           PreparedStatement st = this.getCn().prepareStatement("UPDATE ord_clientes SET RAZON_SOCIAL=?,CONTACTO=?,RPT_LEGAL=?,RPT_DNI=?,RPT_DIRECCION=?,RUC=?" +
            ",DIRECCION=?,TELEFONO=? WHERE C_CLIENTE = ?");
           st.setString(1, razon);
           st.setString(2,contacto);
           st.setString(3, rpt_legal);
           st.setString(4, dni);
           st.setString(5, rpt_direccion);
           st.setString(6, ruc);
           st.setString(6, direccion);
           st.setString(7, telefono);
           st.setInt(8,codigo);
           numFa =st.executeUpdate();
       } catch (Exception e) {
   
        throw e;
       }finally{
           this.Cerrar();
        
       }
    return numFa;
   } 
           

    public void eliminar(Cliente cli) throws Exception{
       try {
       this.Conectar();
           PreparedStatement st = this.getCn().prepareStatement("DELETE FROM ord_cliente  WHERE C_CLIENTE = ?");
          st.setString(1,cli.getC_cliente());
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
        
       }
   
   }
    
            
            
}
