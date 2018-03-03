/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaSAXParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 *
 * @author SBWin
 */
public class XMLNode
{
    private String name = "";
    private String contents = "";
    private Map<String, List<XMLNode>> properties;
    private Map<String, String> attributes;
    
    
    public XMLNode(){
        
    }
    
    public XMLNode(String name, String contents){
        this.name = name;
        this.contents = contents;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getContents(){
        return contents;
    }
    
    public void setContents(String contents){
        this.contents = contents;
    }
    
    public void addProperty(String name, XMLNode node){
        if(properties == null) {
            properties = new HashMap<>();
        }
        properties.putIfAbsent(name, new ArrayList<XMLNode>());
        properties.get(name).add(node);
    }
    
    public Map<String, List<XMLNode>> getProperties(){
        return properties;
    }
    
    public void addAttributes(String name, String contents){
        this.attributes.put(name, contents);
    }
    
    public Map<String,String> getAttributes(){
        return attributes;
    }
    
}
