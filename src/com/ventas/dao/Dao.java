
package com.ventas.dao;
import java.sql.Connection;
import java.sql.DriverManager;


public class Dao {
    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
   public void Conectar() throws Exception{
   
       try {
           Class.forName("com.mysql.jdbc.Driver");
           
           //cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordenespublicidad?user=root");
           cn = DriverManager.getConnection("jdbc:mysql://67.23.231.144:3306/cualesmi_ordenes?user=cualesmi_web&password=vji2002");
           
       } catch (Exception e) {
           
           throw e;
       }
   }
    public void Cerrar() throws Exception{
        try {
            if(cn!=null){
            if(cn.isClosed()==false){
            cn.close();
            }
            }
        } catch (Exception e) {
            throw e;
        }
  
  
    }
            
}