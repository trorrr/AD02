/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ad02;
import java.util.ArrayList;
/**
 *
 * @author trorrr
 */
public class Tenda {
    private String nome;
    private String cidade;
    private ArrayList<Producto> productos;
    private ArrayList<Empregado> empregados;
    
    
    public Tenda(String _nome,String _cidade){
    this.nome = _nome;
    this.cidade = _cidade;
    this.productos = new ArrayList<Producto>();
    this.empregados = new ArrayList<Empregado>();
    }
    
    public Tenda() {}
    
    public String getNome() {
        return nome;
    }
  
    public String getCidade() {
        return cidade;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public ArrayList<Empregado> getEmpregados() {
        return empregados;
    }
}
