package controlador;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class XPathPropio {
    public void Ejercicio1(){
        // La expresion xpath de busqueda
        String xPathExpression = "/bookstore/book/title";

        // Carga del documento xml

        try {
            //Abrir un libro
            Document documento = DocumentoXML.documento("biblioteca.xml");

            // Preparación de xpath
            javax.xml.xpath.XPath xpath = XPathFactory.newInstance().newXPath();
            NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, documento, XPathConstants.NODESET);
            for (int i = 0; i < nodos.getLength(); i++) {
                System.out.println(i+1+".- "+nodos.item(i).getFirstChild().getNodeValue());
            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Archivo no encontrado");
        }

    }

    public void Ejercicio2(){
        // La expresion xpath de busqueda
        String xPathExpression = "/bookstore/book/author";
        // Carga del documento xml
        try {
            //Abrir un libro
            Document documento = DocumentoXML.documento("biblioteca.xml");

            // Preparación de xpath
            javax.xml.xpath.XPath xpath = XPathFactory.newInstance().newXPath();
            NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, documento, XPathConstants.NODESET);
            System.out.println(nodos.getLength());
            for (int i = 0; i < nodos.getLength(); i++) {
                System.out.println(i+1+".- "+nodos.item(i).getFirstChild().getNodeValue());
            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Archivo no encontrado");
        }

    }


    public void Ejercicio3(){
        // La expresion xpath de busqueda
        System.out.println("Introduzca el número del libro");
        Integer numeroElegido = Comprobaciones.numero(0, Integer.MAX_VALUE);
        String xPathExpression = "/bookstore/book["+numeroElegido+"]/title";

        // Carga del documento xml
        try {
            //Abrir un libro
            Document documento = DocumentoXML.documento("biblioteca.xml");

            // Preparación de xpath
            javax.xml.xpath.XPath xpath = XPathFactory.newInstance().newXPath();
            NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, documento, XPathConstants.NODESET);
            System.out.println(nodos.getLength());
            if(nodos!=null)
                System.out.println(nodos.item(0).getFirstChild().getNodeValue());
            else {
                System.out.println("Con este id("+numeroElegido+") no se ha encontrado ningun número");
            }


        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("Archivo no encontrado");
        }

    }

    public void Ejercicio4(){
        // La expresion xpath de busqueda
        System.out.println("Introduzca el precio máximo (No float)");
        Integer numeroElegido = Comprobaciones.numero(0, Integer.MAX_VALUE);
        String xPathExpression = "/bookstore/book[price<"+numeroElegido+"]/title";

        // Carga del documento xml
        try {
            //Abrir un libro
            Document documento = DocumentoXML.documento("biblioteca.xml");

            // Preparación de xpath
            javax.xml.xpath.XPath xpath = XPathFactory.newInstance().newXPath();
            NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, documento, XPathConstants.NODESET);
            System.out.println("Numero de libros: "+nodos.getLength());
            for (int i = 0; i <  nodos.getLength();i++) {
                System.out.println("- "+nodos.item(i).getFirstChild().getNodeValue());
            }




        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("Con este precio no se ha encontrado ningún libro"+numeroElegido);
        }

    }
}
