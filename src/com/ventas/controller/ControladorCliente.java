/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.controller;

import com.ordenes.vista.frmClientes;
import com.ventas.dao.ClienteDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
      this.vistaCrud.botonregistrar.addActionListener(this);
      this.vistaCrud.botonnmuevo.addActionListener(this);
    }
    
    public void InicializarCrud(){
    }
    
    public void LlenarTabla(JTable tablaD) throws Exception{
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        modeloT.addColumn("Razon Social");
        modeloT.addColumn("RUC");
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
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==vistaCrud.botonregistrar){
        
        
        
        }
    }
}
