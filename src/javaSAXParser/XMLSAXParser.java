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
    public static XMLNode load(File xmlFile) throws Exception {
        
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            DefaultHandler handler = new DefaultHandler() {
                Stack<XMLNode> stack;
                XMLNode currentNode = null;
                String currentElementName = null;
                String currentElementData = "";
                
                @Override
                public void startDocument() {
                    root = null;
                    stack = new Stack<XMLNode>();
                }
                
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    XMLNode node = new XMLNode();
                    node.setName(qName);
                    for(int i = 0; i < attributes.getLength(); i++){
                        node.addAttributes(attributes.getQName(i), attributes.getValue(i));
                    }
                    stack.push(node);
                    if(currentNode != null) {
                        currentNode.addProperty(qName, node);
                    }
                    currentNode = node;
                }
                
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if(stack != null){
                        XMLNode poppedNode = stack.pop();
                        poppedNode.setContents(poppedNode.getContents().trim());
                        if(stack.isEmpty()){
                            root = poppedNode;
                            currentNode = null;
                        }else {
                            currentNode = stack.lastElement();
                        }
                    }
                }
                
                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    if(currentNode != null){
                        currentNode.setContents(currentNode.getContents() + String.valueOf(ch, start, length));
                    }
                }
            };
            saxParser.parse(xmlFile, handler);            
        }catch (Exception e) {
            if(root == null){
                System.out.println("Root is null");
            }
            else{
                System.out.println("Root is NOT null");
            }
            System.out.println("Exception in parser: " + e.getMessage());
            throw e;
        }
        if(root == null){
            System.out.println("Root is NULL!!!!!");
        }else{
            System.out.println("Root is NOT NULL");
        }
        return root;
    }
}
