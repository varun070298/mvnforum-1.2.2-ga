//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.5-b16-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.12.17 at 09:43:27 AM GMT+07:00 
//


package com.mvnforum.jaxb.db;


/**
 * Java content class for ThreadWatchType complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/D:/working/mvnforum/contrib/phpbb2mvnforum-jaxb/schema/mvnforum.xsd line 210)
 * <p>
 * <pre>
 * &lt;complexType name="ThreadWatchType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MemberName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WatchType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="WatchOption" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="WatchStatus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="WatchCreationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WatchLastSentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WatchEndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface ThreadWatchType {


    /**
     * Gets the value of the watchCreationDate property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getWatchCreationDate();

    /**
     * Sets the value of the watchCreationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setWatchCreationDate(java.lang.String value);

    /**
     * Gets the value of the watchLastSentDate property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getWatchLastSentDate();

    /**
     * Sets the value of the watchLastSentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setWatchLastSentDate(java.lang.String value);

    /**
     * Gets the value of the watchEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getWatchEndDate();

    /**
     * Sets the value of the watchEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setWatchEndDate(java.lang.String value);

    /**
     * Gets the value of the watchType property.
     * 
     */
    int getWatchType();

    /**
     * Sets the value of the watchType property.
     * 
     */
    void setWatchType(int value);

    /**
     * Gets the value of the memberName property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getMemberName();

    /**
     * Sets the value of the memberName property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setMemberName(java.lang.String value);

    /**
     * Gets the value of the watchOption property.
     * 
     */
    int getWatchOption();

    /**
     * Sets the value of the watchOption property.
     * 
     */
    void setWatchOption(int value);

    /**
     * Gets the value of the watchStatus property.
     * 
     */
    int getWatchStatus();

    /**
     * Sets the value of the watchStatus property.
     * 
     */
    void setWatchStatus(int value);

}
