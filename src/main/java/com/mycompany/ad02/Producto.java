/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ad02;

/**
 *
 * @author trorrr
 */
public class Producto {
    private int ID;
    private String descripcion;
    private float precio;
    private int cantidade;
    
    
    public Producto(int _ID,String _descripcion,float _precio,int _cantidade){
        this.ID = _ID;
        this.descripcion = _descripcion;
        this.precio = _precio;
        this.cantidade = _cantidade;
    }
    
    public Producto() {}
    
    public int getID() {
        return ID;
    }
    
}
