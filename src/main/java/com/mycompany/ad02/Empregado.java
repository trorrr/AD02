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
public class Empregado {
    private String nome;
    private String apelidos;
    
    
    public Empregado(String _nome,String _apelidos){
    this.nome = _nome;
    this.apelidos = _apelidos;
    }
    
    public Empregado() {}
    
    public String getNome() {
        return nome;
    }
}
