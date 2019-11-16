/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ad02;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.net.URL;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author trorrr
 */
public class AD02 {
    public static void main(String args[]) 
    { 
        
        String opcion = "";
        String param1 = "";
        String param2 = "";
        String param3 = "";
        String param4 = "";
        String tenda_elixida = "";
        Franquicia franquicia = new Franquicia();
        franquicia = cargarJSON();
        Scanner input = new Scanner(System.in);
        while(true) {
        System.out.println(" "); 
        System.out.println("Menú xestión tendas"); 
        System.out.println(" 1. Engadir unha tenda"); 
        System.out.println(" 2. Eliminar unha tenda"); 
        System.out.println(" 3. Engadir un producto a tenda"); 
        System.out.println(" 4. Eliminar un producto a tenda"); 
        System.out.println(" 5. Engadir un empregado a tenda"); 
        System.out.println(" 6. Eliminar un empregado a tenda"); 
        System.out.println(" 7. Engadir un cliente"); 
        System.out.println(" 8. Eliminar un cliente");
        System.out.println(" C. Crear copia de seguridade"); 
        System.out.println(" E. Ler os titulares de El País"); 
        System.out.println(" F. Ler os titulares online de El País"); 
        System.out.println(" L. Debug: Mostrar JSON en pantalla"); 
        System.out.println(" S. Saír"); 

        opcion = input.next();
        
        switch(opcion) {
            case "1":
                System.out.print("  Nome da tenda: ");
                param1 = input.next();
                System.out.print("  Cidade: ");
                param2 = input.next();
                franquicia.tendas.add(new Tenda(param1,param2));
                guardarJSON(franquicia);
                break;
            case "2":
                System.out.print("  Nome da tenda a eliminar: ");
                param1 = input.next();
                Tenda aBorrarTenda = new Tenda();
                for (Tenda tenda : franquicia.tendas) {
                    if (tenda.getNome().equals(param1)) {
                        aBorrarTenda=tenda;
                        break;
                    }
                }
                franquicia.tendas.remove(aBorrarTenda);
                guardarJSON(franquicia);
                break;
            case "3":
                System.out.print("Tenda á que engadir o producto: ");
                tenda_elixida = input.next();
                System.out.print("  ID do producto: ");
                param1 = input.next();
                System.out.print("  Descripción: ");
                param2 = input.next();
                System.out.print("  Precio: ");
                param3 = input.next();                
                System.out.print("  Cantidade: ");
                param4 = input.next();
                for (Tenda tenda : franquicia.tendas) {
                    if (tenda.getNome().equals(tenda_elixida)) {
                        tenda.getProductos().add(new Producto(parseInt(param1),param2,parseFloat(param3),parseInt(param4)));
                    }
                }
                guardarJSON(franquicia);
                break;
            case "4":
                System.out.print("Tenda da que eliminar o producto: ");
                tenda_elixida = input.next();
                System.out.print("  ID do producto: ");
                param1 = input.next();
                Producto aBorrarProducto = new Producto();
                Tenda aBorrarProductoenTenda = new Tenda();
                 for (Tenda tenda : franquicia.tendas) {
                    if (tenda.getNome().equals(tenda_elixida)) {
                        for (Producto producto : tenda.getProductos()) {
                            if (producto.getID() == parseInt(param1)) {
                                aBorrarProducto = producto;
                                aBorrarProductoenTenda = tenda;
                                break;
                            }
                        }
                    }
                }               
                aBorrarProductoenTenda.getProductos().remove(aBorrarProducto);
                break;        
            case "5":
                System.out.print("Tenda á que engadir o empregado: ");
                tenda_elixida = input.next();
                System.out.print("  Nome do empregado: ");
                param1 = input.next();
                System.out.print("  Apelidos: ");
                param2 = input.next();
                for (Tenda tenda : franquicia.tendas) {
                    if (tenda.getNome().equals(tenda_elixida)) {
                        tenda.getEmpregados().add(new Empregado(param1,param2));
                    }
                }
                guardarJSON(franquicia);                
                break;
            case "6":
                System.out.print("Tenda da que eliminar o empregado: ");
                tenda_elixida = input.next();
                System.out.print("  Nome do empregado: ");
                param1 = input.next();
                Empregado aBorrarEmpregado = new Empregado();
                Tenda aBorrarEmpregadoenTenda = new Tenda();
                 for (Tenda tenda : franquicia.tendas) {
                    if (tenda.getNome().equals(tenda_elixida)) {
                        for (Empregado empregado : tenda.getEmpregados()) {
                            if (empregado.getNome().equals(param1)) {
                                aBorrarEmpregado = empregado;
                                aBorrarEmpregadoenTenda = tenda;
                                break;
                            }
                        }
                    }
                }                     
                aBorrarEmpregadoenTenda.getEmpregados().remove(aBorrarEmpregado);
                break;   
            case "7":
                System.out.print("  Nome do cliente: ");
                param1 = input.next();
                System.out.print("  Apelidos: ");
                param2 = input.next();
                System.out.print("  Email: ");
                param3 = input.next();
                franquicia.clientes.add(new Cliente(param1,param2,param3));
                guardarJSON(franquicia);                
                break;
            case "8":
                System.out.print("  Email do cliente a eliminar: ");
                param1 = input.next();
                Cliente aBorrarCliente = new Cliente();
                for (Cliente cliente : franquicia.clientes) {
                    if (cliente.getEmail().equals(param1)) {
                        aBorrarCliente=cliente;
                        break;
                    }
                }
                franquicia.clientes.remove(aBorrarCliente);
                guardarJSON(franquicia);                
                break;                
            case "C":
                try {
                    File arquivo_orixe = new File("franquicia.json");
                    File arquivo_destino = new File("franquicia.json.backup");
                    FileInputStream fluxoDatos_orixe;
                    FileOutputStream fluxoDatos_destino;
                    fluxoDatos_orixe = new FileInputStream(arquivo_orixe);
                    fluxoDatos_destino = new FileOutputStream(arquivo_destino);
                    
                    int datobyte;
                    while ((datobyte=fluxoDatos_orixe.read()) != -1) {
                        fluxoDatos_destino.write(datobyte);
                    }
            
                    fluxoDatos_orixe.close();
                    fluxoDatos_destino.close();
            
                } catch (FileNotFoundException e) {
                   System.out.println("Non se atopa o archivo");
                } catch (IOException e){
                   System.out.println("Non se poido escribir no arquivo");
                }                  
                break;
            case "E":
                XMLReader procesadorXML = null;
                try {
                    procesadorXML = XMLReaderFactory.createXMLReader();
                    ChannelsXML channelsXML = new ChannelsXML();
                    procesadorXML.setContentHandler(channelsXML);
                    InputSource arquivo = new InputSource("portada.xml");
                    procesadorXML.parse(arquivo);
                } catch (SAXException e) {
                    System.out.println("Ocurriu un erro ao ler o arquivo XML");
                } catch (IOException e) {
                    System.out.println("Ocurriu un erro ao ler o arquivo XML");
                } 
                break; 
            case "F":
                XMLReader procesadorXML_online = null;
                try {
                    procesadorXML_online = XMLReaderFactory.createXMLReader();
                    ChannelsXML channelsXML = new ChannelsXML();
                    procesadorXML_online.setContentHandler(channelsXML);
                    //InputSource arquivo = new InputSource("portada.xml");
                    procesadorXML_online.parse(new InputSource(new URL("http://ep00.epimg.net/rss/elpais/portada.xml").openStream()));
                } catch (SAXException e) {
                    System.out.println("Ocurriu un erro ao ler o arquivo XML");
                } catch (IOException e) {
                    System.out.println("Ocurriu un erro ao ler o arquivo XML");
                } 
                break; 

            case "S":
                System.out.println("Saíndo");
                System.exit(0);
                break;  
            case "L":
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(franquicia);
                System.out.println(json);
                break;  
            default:
                System.out.println("Opción non recoñecida");
        }
        }
    } 
    public static void guardarJSON(Franquicia franquicia) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(franquicia);
        
        File arquivo = new File("franquicia.json");
        try {
            //Creamos o fluxo de saida
            FileWriter fluxoDatos = new FileWriter(arquivo);
            BufferedWriter buferSaida = new BufferedWriter(fluxoDatos);

            buferSaida.write(json);

            //Cerramos o arquivo
            buferSaida.close();
        } catch (IOException e) {
            System.out.println("Error al escribir json: " + e.toString());
        }
    }
    
    public static Franquicia cargarJSON() {
        File arquivo = new File("franquicia.json");
        Franquicia franquicia = new Franquicia();
        try {
            FileReader fluxoDatos;
            fluxoDatos = new FileReader(arquivo);        
            BufferedReader buferEntrada = new BufferedReader(fluxoDatos);
            
            StringBuilder jsonBuilder = new StringBuilder();
            String linea;
            while ((linea=buferEntrada.readLine()) != null) {
                jsonBuilder.append(linea).append("\n");
            }
            
            buferEntrada.close();
            String json = jsonBuilder.toString();
            Gson gson = new Gson();
            franquicia = gson.fromJson(json, Franquicia.class);
            
        } catch (FileNotFoundException e) {
            System.out.println("Non se encontra o arquivo");
        } catch (IOException e) {
            System.out.println("Erro de entrada saída");        
        }
        return franquicia;
    }
}
