//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.5-b16-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.12.17 at 09:43:27 AM GMT+07:00 
//


package com.mvnforum.jaxb.db;


/**
 * Java content class for RankType complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/D:/working/mvnforum/contrib/phpbb2mvnforum-jaxb/schema/mvnforum.xsd line 74)
 * <p>
 * <pre>
 * &lt;complexType name="RankType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RankMinPosts" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RankLevel" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="RankTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RankImage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RankType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="RankOption" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface RankType {


    /**
     * Gets the value of the rankImage property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getRankImage();

    /**
     * Sets the value of the rankImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setRankImage(java.lang.String value);

    /**
     * Gets the value of the rankMinPosts property.
     * 
     */
    int getRankMinPosts();

    /**
     * Sets the value of the rankMinPosts property.
     * 
     */
    void setRankMinPosts(int value);

    /**
     * Gets the value of the rankTitle property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getRankTitle();

    /**
     * Sets the value of the rankTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setRankTitle(java.lang.String value);

    /**
     * Gets the value of the rankLevel property.
     * 
     */
    int getRankLevel();

    /**
     * Sets the value of the rankLevel property.
     * 
     */
    void setRankLevel(int value);

    /**
     * Gets the value of the rankType property.
     * 
     */
    int getRankType();

    /**
     * Sets the value of the rankType property.
     * 
     */
    void setRankType(int value);

    /**
     * Gets the value of the rankOption property.
     * 
     */
    int getRankOption();

    /**
     * Sets the value of the rankOption property.
     * 
     */
    void setRankOption(int value);

}
