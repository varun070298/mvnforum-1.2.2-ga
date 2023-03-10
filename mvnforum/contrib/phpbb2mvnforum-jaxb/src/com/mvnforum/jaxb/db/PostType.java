//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.5-b16-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.12.17 at 09:43:27 AM GMT+07:00 
//


package com.mvnforum.jaxb.db;


/**
 * Java content class for PostType complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/D:/working/mvnforum/contrib/phpbb2mvnforum-jaxb/schema/mvnforum.xsd line 244)
 * <p>
 * <pre>
 * &lt;complexType name="PostType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MemberName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastEditMemberName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostTopic" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PostBody" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PostCreationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostLastEditDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostCreationIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostLastEditIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostEditCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PostFormatOption" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PostOption" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PostStatus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PostIcon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostAttachCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="AttachmentList" type="{}AttachmentList" minOccurs="0"/>
 *         &lt;element name="PostList" type="{}PostList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface PostType {


    /**
     * Gets the value of the postTopic property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getPostTopic();

    /**
     * Sets the value of the postTopic property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setPostTopic(java.lang.String value);

    /**
     * Gets the value of the postList property.
     * 
     * @return
     *     possible object is
     *     {@link com.mvnforum.jaxb.db.PostList}
     */
    com.mvnforum.jaxb.db.PostList getPostList();

    /**
     * Sets the value of the postList property.
     * 
     * @param value
     *     allowed object is
     *     {@link com.mvnforum.jaxb.db.PostList}
     */
    void setPostList(com.mvnforum.jaxb.db.PostList value);

    /**
     * Gets the value of the postLastEditDate property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getPostLastEditDate();

    /**
     * Sets the value of the postLastEditDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setPostLastEditDate(java.lang.String value);

    /**
     * Gets the value of the postCreationDate property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getPostCreationDate();

    /**
     * Sets the value of the postCreationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setPostCreationDate(java.lang.String value);

    /**
     * Gets the value of the postFormatOption property.
     * 
     */
    int getPostFormatOption();

    /**
     * Sets the value of the postFormatOption property.
     * 
     */
    void setPostFormatOption(int value);

    /**
     * Gets the value of the postAttachCount property.
     * 
     */
    int getPostAttachCount();

    /**
     * Sets the value of the postAttachCount property.
     * 
     */
    void setPostAttachCount(int value);

    /**
     * Gets the value of the postIcon property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getPostIcon();

    /**
     * Sets the value of the postIcon property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setPostIcon(java.lang.String value);

    /**
     * Gets the value of the postLastEditIP property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getPostLastEditIP();

    /**
     * Sets the value of the postLastEditIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setPostLastEditIP(java.lang.String value);

    /**
     * Gets the value of the postCreationIP property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getPostCreationIP();

    /**
     * Sets the value of the postCreationIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setPostCreationIP(java.lang.String value);

    /**
     * Gets the value of the postOption property.
     * 
     */
    int getPostOption();

    /**
     * Sets the value of the postOption property.
     * 
     */
    void setPostOption(int value);

    /**
     * Gets the value of the postEditCount property.
     * 
     */
    int getPostEditCount();

    /**
     * Sets the value of the postEditCount property.
     * 
     */
    void setPostEditCount(int value);

    /**
     * Gets the value of the lastEditMemberName property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getLastEditMemberName();

    /**
     * Sets the value of the lastEditMemberName property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setLastEditMemberName(java.lang.String value);

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
     * Gets the value of the postStatus property.
     * 
     */
    int getPostStatus();

    /**
     * Sets the value of the postStatus property.
     * 
     */
    void setPostStatus(int value);

    /**
     * Gets the value of the postBody property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getPostBody();

    /**
     * Sets the value of the postBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setPostBody(java.lang.String value);

    /**
     * Gets the value of the attachmentList property.
     * 
     * @return
     *     possible object is
     *     {@link com.mvnforum.jaxb.db.AttachmentList}
     */
    com.mvnforum.jaxb.db.AttachmentList getAttachmentList();

    /**
     * Sets the value of the attachmentList property.
     * 
     * @param value
     *     allowed object is
     *     {@link com.mvnforum.jaxb.db.AttachmentList}
     */
    void setAttachmentList(com.mvnforum.jaxb.db.AttachmentList value);

}
