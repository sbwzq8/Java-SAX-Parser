/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaSAXParser;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author SBWin
 */
public class XMLNode
{
    private String key = "";
    private String value = "";
    
    private List<XMLNode> children;
    
    public XMLNode(String key, String value){
        this.key = key;
        this.value = value;
    }
    
    public String getKey(){
        return key;
    }
    
    public String getValue(){
        return value;
    }
    
}
