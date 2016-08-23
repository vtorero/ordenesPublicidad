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
           PreparedStatement st = this.getCn().prepareStatement("`C_CLIENTE`,\n" +
"             `RAZON_SOCIAL`,\n" +
"             `CONTACTO`,\n" +
"             `RPT_LEGAL`,\n" +
"             `RPT_DNI`,\n" +
"             `RPT_DIRECCION`,\n" +
"             `RUC`,\n" +
"             `DIRECCION`,\n" +
"             `TELEFONO`,\n" +
"             `F_CREACION`,\n" +
"             `USUARIO`) values(?,?,?,?,?,?,?,?,now(),user)");
           st.setString(1,cli.getContacto());
           st.setString(2, cli.getDireccion());
           st.setString(3, cli.getRazonsocial());
           st.setString(4, cli.getRptdireccion());
           st.setString(5, cli.getRptdni());
           st.setString(6, cli.getRptlegal());
           st.setString(7, cli.getRuc());
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
           PreparedStatement st = this.getCn().prepareCall("SELECT cCod,cRuc,cRzS,cDir,cLug,cMap,cFnc,cTl1,cTl2,cCl1,cCl2,cCe1,cCe2,cFio,cCat,cPds,vCod,cFot FROM cliente");
           rs = st.executeQuery();
           lista = new ArrayList<>();
           while(rs.next()){
         Cliente cli = new Cliente();
         cli.setContacto(rs.getString("cCod"));
          cli.setDireccion(rs.getString("cRuc"));
          cli.setRazonsocial(rs.getString("cRzS"));
          cli.setRptdireccion(rs.getString("cDir"));
          cli.setRptdni(rs.getString("cLug"));
          cli.setRptlegal(rs.getString("cMap"));
          cli.setRuc(rs.getString("cFnc"));
          cli.setTelefono(rs.getString("cTl1"));
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
