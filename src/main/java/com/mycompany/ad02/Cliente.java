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
public class Cliente {
    private String nome;
    private String apelidos;
    private String email;
    
    
    public Cliente(String _nome,String _apelidos, String _email){
    this.nome = _nome;
    this.apelidos = _apelidos;
    this.email = _email;
    }
    
    public Cliente() {}
     
    public String getNome() {
        return nome;
    }
    
    public String getEmail() {
        return email;
    }
}
