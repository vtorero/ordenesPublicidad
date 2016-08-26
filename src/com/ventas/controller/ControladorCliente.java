/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.controller;

import com.ordenes.modelo.Cliente;
import com.ordenes.vista.frmClientes;
import com.ventas.dao.ClienteDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vjimenez
 */
public class ControladorCliente implements ActionListener {
    frmClientes vistaCrud= new frmClientes();
    ClienteDao clienteDao = new ClienteDao();
    
    public ControladorCliente(frmClientes vistaCrud,ClienteDao clienteDao){
       this.vistaCrud=vistaCrud; 
       this.clienteDao=clienteDao;
      this.vistaCrud.botonregistrar.addActionListener(this);
      this.vistaCrud.botonnmuevo.addActionListener(this);
    }
    
    public void InicializarCrud(){
    }
    
    public void LlenarTabla(JTable tablaD) throws Exception{
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        modeloT.addColumn("Razon Social");
        modeloT.addColumn("Ruc");
        modeloT.addColumn("Telefono");
        modeloT.addColumn("Dirección");
        Object[] columna = new Object[5];
        int numRegistros = clienteDao.listar().size();
        
        for (int i = 0; i < numRegistros; i++) {
            columna[0] = clienteDao.listar().get(i).getRazonsocial();
            columna[1] = clienteDao.listar().get(i).getRuc();
            columna[2] = clienteDao.listar().get(i).getTelefono();
            columna[3] = clienteDao.listar().get(i).getDireccion();
            modeloT.addRow(columna);
        }
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == vistaCrud.botonregistrar){
            try {
                Cliente c = new Cliente();
                c.setRazonsocial(vistaCrud.txtRazon.getText());
                c.setContacto(vistaCrud.txtContacto.getText());
                c.setRptlegal(vistaCrud.txtRepresentante.getText());
                c.setRptdireccion(vistaCrud.txtDireccionRpt.getText());
                c.setRptdni(vistaCrud.txtDniRpt.getText());
                c.setRuc(vistaCrud.txtRuc.getText());
                c.setTelefono(vistaCrud.txtTelefono.getText());
                clienteDao.registrar(c);
                LlenarTabla(vistaCrud.DataClientes);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vistaCrud,ex.getMessage());
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            //JOptionPane.showMessageDialog(vistaCrud,"eee");
            
        }
        if(e.getSource() == vistaCrud.DataClientes){
            
        JOptionPane.showMessageDialog(vistaCrud,"eee");

    }
    }
}