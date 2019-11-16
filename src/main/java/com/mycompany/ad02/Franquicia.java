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
public class Franquicia {
    public ArrayList<Tenda> tendas;
    public ArrayList<Cliente> clientes;
    
    public Franquicia () {
    this.tendas = new ArrayList<Tenda>();
    this.clientes = new ArrayList<Cliente>();
    };
    
    /*public ArrayList<Tenda> getTendas() {
        return tendas;
    }*/
}
