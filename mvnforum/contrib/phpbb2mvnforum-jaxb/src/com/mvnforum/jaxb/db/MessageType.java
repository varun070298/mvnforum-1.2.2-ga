//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.5-b16-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.12.29 at 03:19:11 PM GMT+07:00 
//


package com.mvnforum.jaxb.db;


/**
 * Java content class for MessageType complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/D:/working/mvnforum/contrib/phpbb2mvnforum-jaxb/schema/mvnforum.xsd line 353)
 * <p>
 * <pre>
 * &lt;complexType name="MessageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FolderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageSenderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageToList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageCcList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageBccList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageTopic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageBody" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="MessageOption" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="MessageStatus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="MessageReadStatus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="MessageNotify" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="MessageIcon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageAttachCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="MessageIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageCreationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface MessageType {


    /**
     * Gets the value of the messageReadStatus property.
     * 
     */
    int getMessageReadStatus();

    /**
     * Sets the value of the messageReadStatus property.
     * 
     */
    void setMessageReadStatus(int value);

    /**
     * Gets the value of the messageIP property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getMessageIP();

    /**
     * Sets the value of the messageIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setMessageIP(java.lang.String value);

    /**
     * Gets the value of the messageOption property.
     * 
     */
    int getMessageOption();

    /**
     * Sets the value of the messageOption property.
     * 
     */
    void setMessageOption(int value);

    /**
     * Gets the value of the messageStatus property.
     * 
     */
    int getMessageStatus();

    /**
     * Sets the value of the messageStatus property.
     * 
     */
    void setMessageStatus(int value);

    /**
     * Gets the value of the messageBody property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getMessageBody();

    /**
     * Sets the value of the messageBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setMessageBody(java.lang.String value);

    /**
     * Gets the value of the messageBccList property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getMessageBccList();

    /**
     * Sets the value of the messageBccList property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setMessageBccList(java.lang.String value);

    /**
     * Gets the value of the folderName property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getFolderName();

    /**
     * Sets the value of the folderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setFolderName(java.lang.String value);

    /**
     * Gets the value of the messageTopic property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getMessageTopic();

    /**
     * Sets the value of the messageTopic property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setMessageTopic(java.lang.String value);

    /**
     * Gets the value of the messageSenderName property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getMessageSenderName();

    /**
     * Sets the value of the messageSenderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setMessageSenderName(java.lang.String value);

    /**
     * Gets the value of the messageCcList property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getMessageCcList();

    /**
     * Sets the value of the messageCcList property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setMessageCcList(java.lang.String value);

    /**
     * Gets the value of the messageCreationDate property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getMessageCreationDate();

    /**
     * Sets the value of the messageCreationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setMessageCreationDate(java.lang.String value);

    /**
     * Gets the value of the messageAttachCount property.
     * 
     */
    int getMessageAttachCount();

    /**
     * Sets the value of the messageAttachCount property.
     * 
     */
    void setMessageAttachCount(int value);

    /**
     * Gets the value of the messageType property.
     * 
     */
    int getMessageType();

    /**
     * Sets the value of the messageType property.
     * 
     */
    void setMessageType(int value);

    /**
     * Gets the value of the messageIcon property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getMessageIcon();

    /**
     * Sets the value of the messageIcon property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setMessageIcon(java.lang.String value);

    /**
     * Gets the value of the messageNotify property.
     * 
     */
    int getMessageNotify();

    /**
     * Sets the value of the messageNotify property.
     * 
     */
    void setMessageNotify(int value);

    /**
     * Gets the value of the messageToList property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getMessageToList();

    /**
     * Sets the value of the messageToList property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setMessageToList(java.lang.String value);

}
