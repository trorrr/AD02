/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ad02;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author trorrr
 */
public class ChannelsXML extends DefaultHandler {
    
    private boolean dentroItem = false;
    private boolean titulo = false;
    
    public ChannelsXML(){
        super();
    }
    
    public void startDocument() throws SAXException {}    
    
    public void endDocument() throws SAXException {}
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
/*        if(localName == "channel"){
            this.channels = new ArrayList<Channel>();
        }
        else if(localName == "item"){
            this.itemAux = new Item();
        }
        else if(localName == "image"){
            this.imageAux = new Image();
        }        
*/
        if(localName.equals("item")) {
            dentroItem = true;
        }
        
        if(localName.equals("title")) {
            titulo=true;
        }
    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(localName.equals("item")) {
            dentroItem = false;
        }
        
        titulo=false;
    }
    
    public void characters(char ch[], int start, int length) throws SAXException {
        if(dentroItem & titulo) {
            System.out.println(new String(ch, start, length));
        }
        
    }
}
