//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.5-b16-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.12.17 at 09:43:27 AM GMT+07:00 
//


package com.mvnforum.jaxb.db;


/**
 * Java content class for FavoriteThreadList complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/D:/working/mvnforum/contrib/phpbb2mvnforum-jaxb/schema/mvnforum.xsd line 222)
 * <p>
 * <pre>
 * &lt;complexType name="FavoriteThreadList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FavoriteThread" type="{}FavoriteThreadType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface FavoriteThreadList {


    /**
     * Gets the value of the FavoriteThread property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the FavoriteThread property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFavoriteThread().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link com.mvnforum.jaxb.db.FavoriteThreadType}
     * 
     */
    java.util.List getFavoriteThread();

}
