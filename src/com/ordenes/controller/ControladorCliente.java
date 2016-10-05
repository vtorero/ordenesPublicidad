/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ordenes.controller;

import com.ordenes.modelo.Cliente;
import com.ordenes.vista.frmClientes;
import com.ventas.dao.ClienteDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vjimenez
 */
public class ControladorCliente implements ActionListener,KeyListener {
    frmClientes vistaCrud= new frmClientes();
    ClienteDao clienteDao = new ClienteDao();
    
    public ControladorCliente(frmClientes vistaCrud,ClienteDao clienteDao){
      this.vistaCrud=vistaCrud; 
      this.clienteDao=clienteDao;
      this.vistaCrud.botonregistrar.addActionListener(this);
      this.vistaCrud.botonnmuevo.addActionListener(this);
      this.vistaCrud.botonEditar.addActionListener(this);
      this.vistaCrud.botonEliminar.addActionListener(this);
      //this.vistaCrud.txtDniRpt.addKeyListener(this);
      this.vistaCrud.txtBuscar.addKeyListener(this);
      
    }
    
    public void InicializarCrud(){
    }
    
    public void LlenarTabla(JTable tablaD) throws Exception{
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        modeloT.addColumn("Código");
        modeloT.addColumn("Razon Social");
        modeloT.addColumn("Contácto");
        modeloT.addColumn("Representante");
       modeloT.addColumn("DNI");
       modeloT.addColumn("Rpt Dirección");
        modeloT.addColumn("Ruc");
        modeloT.addColumn("Dirección");
        modeloT.addColumn("Telefono");
        Object[] columna = new Object[9];
        int numRegistros = clienteDao.listar().size();
       
        for (int i = 0; i < numRegistros; i++) {
            columna[0] = clienteDao.listar().get(i).getC_cliente();
            columna[1] = clienteDao.listar().get(i).getRazonsocial();
            columna[2] = clienteDao.listar().get(i).getContacto();
            columna[3] = clienteDao.listar().get(i).getRptlegal();
            columna[4] = clienteDao.listar().get(i).getRptdni();
            columna[5] = clienteDao.listar().get(i).getRptdireccion();
            columna[6] = clienteDao.listar().get(i).getRuc();
            columna[7] = clienteDao.listar().get(i).getDireccion();
            columna[8] = clienteDao.listar().get(i).getTelefono();
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
                
                if(vistaCrud.txtRazon.getText().isEmpty() || vistaCrud.txtContacto.getText().isEmpty() || vistaCrud.txtRepresentante.getText().isEmpty()){
                JOptionPane.showMessageDialog(vistaCrud,"Campo necesario vacio");
                }else{
                clienteDao.registrar(c);
                 LlenarTabla(vistaCrud.DataClientes);
                JOptionPane.showMessageDialog(vistaCrud,"Se registro un cliente");
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vistaCrud,ex.getMessage());
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            //JOptionPane.showMessageDialog(vistaCrud,"eee");
            
        }
        if(e.getSource() == vistaCrud.botonEditar){
        int filaEdit = vistaCrud.DataClientes.getSelectedRow();
        int filaCount = vistaCrud.DataClientes.getSelectedRowCount();
        
        if(filaEdit>=0 && filaCount==1){
          vistaCrud.txtCodigo.setText(String.valueOf(vistaCrud.DataClientes.getValueAt(filaEdit, 0)));
          vistaCrud.txtRazon.setText(String.valueOf(vistaCrud.DataClientes.getValueAt(filaEdit, 1)));
          vistaCrud.txtContacto.setText(String.valueOf(vistaCrud.DataClientes.getValueAt(filaEdit, 2)));
          vistaCrud.txtRepresentante.setText(String.valueOf(vistaCrud.DataClientes.getValueAt(filaEdit, 3)));
          vistaCrud.txtDniRpt.setText(String.valueOf(vistaCrud.DataClientes.getValueAt(filaEdit, 4)));
          vistaCrud.txtDireccionRpt.setText(String.valueOf(vistaCrud.DataClientes.getValueAt(filaEdit, 5)));
          vistaCrud.txtRuc.setText(String.valueOf(vistaCrud.DataClientes.getValueAt(filaEdit, 6)));
          vistaCrud.txtDireccion.setText(String.valueOf(vistaCrud.DataClientes.getValueAt(filaEdit, 7)));
          vistaCrud.txtTelefono.setText(String.valueOf(vistaCrud.DataClientes.getValueAt(filaEdit, 8)));
          vistaCrud.botonEditar.setEnabled(false);
          vistaCrud.botonEliminar.setEnabled(false);
          vistaCrud.botonnmuevo.setEnabled(false);
          vistaCrud.btnListar.setEnabled(false);
          vistaCrud.botonregistrar.setText("Guardar");
        }else{
        
        JOptionPane.showMessageDialog(vistaCrud,"Debe seleccionar un cliente");
        }
        

    }
       if(e.getSource()==vistaCrud.botonregistrar){
         
       
       }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}