/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaSAXParser;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;
import javax.xml.parsers.ParserConfigurationException;
/**
 *
 * @author SBWin
 */
public class XMLSAXParser
{
    static XMLNode root;
    public static XMLNode load(File xmlCourseFile) throws Exception {
        
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            DefaultHandler handler = new DefaultHandler() {
                Stack<XMLNode> stack;
                XMLNode currentNode = null;
                String key = "";
                String value = "";
                
                @Override
                public void startDocument() {
                    root = null;
                    stack = new Stack<>();
                }
                
                 @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    
                }
                
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    
                }
            };
            
            
        }catch (ParserConfigurationException | SAXException e) {
            throw e;
        }
        
        
        
        
        return root;
    }
}
