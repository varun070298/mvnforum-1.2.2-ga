//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.5-b16-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.12.29 at 03:19:11 PM GMT+07:00 
//


package com.mvnforum.jaxb.db.impl;

public class GroupTypeImpl implements com.mvnforum.jaxb.db.GroupType, com.sun.xml.bind.JAXBObject, com.mvnforum.jaxb.db.impl.runtime.UnmarshallableObject, com.mvnforum.jaxb.db.impl.runtime.XMLSerializable, com.mvnforum.jaxb.db.impl.runtime.ValidatableObject
{

    protected java.lang.String _GroupOwnerName;
    protected java.lang.String _GroupCreationDate;
    protected java.lang.String _GroupName;
    protected com.mvnforum.jaxb.db.GroupMemberList _GroupMemberList;
    protected java.lang.String _GroupModifiedDate;
    protected boolean has_GroupOption;
    protected int _GroupOption;
    protected com.mvnforum.jaxb.db.GlobalPermissionList _GlobalPermissionList;
    protected java.lang.String _GroupDesc;
    public final static java.lang.Class version = (com.mvnforum.jaxb.db.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (com.mvnforum.jaxb.db.GroupType.class);
    }

    public java.lang.String getGroupOwnerName() {
        return _GroupOwnerName;
    }

    public void setGroupOwnerName(java.lang.String value) {
        _GroupOwnerName = value;
    }

    public java.lang.String getGroupCreationDate() {
        return _GroupCreationDate;
    }

    public void setGroupCreationDate(java.lang.String value) {
        _GroupCreationDate = value;
    }

    public java.lang.String getGroupName() {
        return _GroupName;
    }

    public void setGroupName(java.lang.String value) {
        _GroupName = value;
    }

    public com.mvnforum.jaxb.db.GroupMemberList getGroupMemberList() {
        return _GroupMemberList;
    }

    public void setGroupMemberList(com.mvnforum.jaxb.db.GroupMemberList value) {
        _GroupMemberList = value;
    }

    public java.lang.String getGroupModifiedDate() {
        return _GroupModifiedDate;
    }

    public void setGroupModifiedDate(java.lang.String value) {
        _GroupModifiedDate = value;
    }

    public int getGroupOption() {
        return _GroupOption;
    }

    public void setGroupOption(int value) {
        _GroupOption = value;
        has_GroupOption = true;
    }

    public com.mvnforum.jaxb.db.GlobalPermissionList getGlobalPermissionList() {
        return _GlobalPermissionList;
    }

    public void setGlobalPermissionList(com.mvnforum.jaxb.db.GlobalPermissionList value) {
        _GlobalPermissionList = value;
    }

    public java.lang.String getGroupDesc() {
        return _GroupDesc;
    }

    public void setGroupDesc(java.lang.String value) {
        _GroupDesc = value;
    }

    public com.mvnforum.jaxb.db.impl.runtime.UnmarshallingEventHandler createUnmarshaller(com.mvnforum.jaxb.db.impl.runtime.UnmarshallingContext context) {
        return new com.mvnforum.jaxb.db.impl.GroupTypeImpl.Unmarshaller(context);
    }

    public void serializeBody(com.mvnforum.jaxb.db.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        if (_GroupOwnerName!= null) {
            context.startElement("", "GroupOwnerName");
            context.endNamespaceDecls();
            context.endAttributes();
            try {
                context.text(((java.lang.String) _GroupOwnerName), "GroupOwnerName");
            } catch (java.lang.Exception e) {
                com.mvnforum.jaxb.db.impl.runtime.Util.handlePrintConversionException(this, e, context);
            }
            context.endElement();
        }
        context.startElement("", "GroupName");
        context.endNamespaceDecls();
        context.endAttributes();
        try {
            context.text(((java.lang.String) _GroupName), "GroupName");
        } catch (java.lang.Exception e) {
            com.mvnforum.jaxb.db.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
        if (_GroupDesc!= null) {
            context.startElement("", "GroupDesc");
            context.endNamespaceDecls();
            context.endAttributes();
            try {
                context.text(((java.lang.String) _GroupDesc), "GroupDesc");
            } catch (java.lang.Exception e) {
                com.mvnforum.jaxb.db.impl.runtime.Util.handlePrintConversionException(this, e, context);
            }
            context.endElement();
        }
        if (has_GroupOption) {
            context.startElement("", "GroupOption");
            context.endNamespaceDecls();
            context.endAttributes();
            try {
                context.text(javax.xml.bind.DatatypeConverter.printInt(((int) _GroupOption)), "GroupOption");
            } catch (java.lang.Exception e) {
                com.mvnforum.jaxb.db.impl.runtime.Util.handlePrintConversionException(this, e, context);
            }
            context.endElement();
        }
        if (_GroupCreationDate!= null) {
            context.startElement("", "GroupCreationDate");
            context.endNamespaceDecls();
            context.endAttributes();
            try {
                context.text(((java.lang.String) _GroupCreationDate), "GroupCreationDate");
            } catch (java.lang.Exception e) {
                com.mvnforum.jaxb.db.impl.runtime.Util.handlePrintConversionException(this, e, context);
            }
            context.endElement();
        }
        if (_GroupModifiedDate!= null) {
            context.startElement("", "GroupModifiedDate");
            context.endNamespaceDecls();
            context.endAttributes();
            try {
                context.text(((java.lang.String) _GroupModifiedDate), "GroupModifiedDate");
            } catch (java.lang.Exception e) {
                com.mvnforum.jaxb.db.impl.runtime.Util.handlePrintConversionException(this, e, context);
            }
            context.endElement();
        }
        if (_GlobalPermissionList!= null) {
            context.startElement("", "GlobalPermissionList");
            context.childAsURIs(((com.sun.xml.bind.JAXBObject) _GlobalPermissionList), "GlobalPermissionList");
            context.endNamespaceDecls();
            context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _GlobalPermissionList), "GlobalPermissionList");
            context.endAttributes();
            context.childAsBody(((com.sun.xml.bind.JAXBObject) _GlobalPermissionList), "GlobalPermissionList");
            context.endElement();
        }
        if (_GroupMemberList!= null) {
            context.startElement("", "GroupMemberList");
            context.childAsURIs(((com.sun.xml.bind.JAXBObject) _GroupMemberList), "GroupMemberList");
            context.endNamespaceDecls();
            context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _GroupMemberList), "GroupMemberList");
            context.endAttributes();
            context.childAsBody(((com.sun.xml.bind.JAXBObject) _GroupMemberList), "GroupMemberList");
            context.endElement();
        }
    }

    public void serializeAttributes(com.mvnforum.jaxb.db.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public void serializeURIs(com.mvnforum.jaxb.db.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public java.lang.Class getPrimaryInterface() {
        return (com.mvnforum.jaxb.db.GroupType.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.su"
+"n.msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/gra"
+"mmar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expressi"
+"on\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0002L\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000b"
+"expandedExpq\u0000~\u0000\u0002xpppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000pp"
+"sq\u0000~\u0000\u0000ppsr\u0000\u001dcom.sun.msv.grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0001pp"
+"sr\u0000\'com.sun.msv.grammar.trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\tnam"
+"eClasst\u0000\u001fLcom/sun/msv/grammar/NameClass;xr\u0000\u001ecom.sun.msv.gram"
+"mar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000\fcon"
+"tentModelq\u0000~\u0000\u0002xq\u0000~\u0000\u0003sr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005value"
+"xp\u0000p\u0000sq\u0000~\u0000\u0000ppsr\u0000\u001bcom.sun.msv.grammar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dt"
+"t\u0000\u001fLorg/relaxng/datatype/Datatype;L\u0000\u0006exceptq\u0000~\u0000\u0002L\u0000\u0004namet\u0000\u001dLc"
+"om/sun/msv/util/StringPair;xq\u0000~\u0000\u0003ppsr\u0000#com.sun.msv.datatype."
+"xsd.StringType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001Z\u0000\risAlwaysValidxr\u0000*com.sun.msv.dat"
+"atype.xsd.BuiltinAtomicType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.dataty"
+"pe.xsd.ConcreteType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatype.xsd.X"
+"SDatatypeImpl\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\fnamespaceUrit\u0000\u0012Ljava/lang/String;"
+"L\u0000\btypeNameq\u0000~\u0000\u001dL\u0000\nwhiteSpacet\u0000.Lcom/sun/msv/datatype/xsd/Wh"
+"iteSpaceProcessor;xpt\u0000 http://www.w3.org/2001/XMLSchemat\u0000\u0006st"
+"ringsr\u00005com.sun.msv.datatype.xsd.WhiteSpaceProcessor$Preserv"
+"e\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,com.sun.msv.datatype.xsd.WhiteSpaceProcessor"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xp\u0001sr\u00000com.sun.msv.grammar.Expression$NullSetExpr"
+"ession\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003ppsr\u0000\u001bcom.sun.msv.util.StringPair\u00d0t\u001ej"
+"B\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u001dL\u0000\fnamespaceURIq\u0000~\u0000\u001dxpq\u0000~\u0000!q\u0000~\u0000 sq\u0000~"
+"\u0000\fppsr\u0000 com.sun.msv.grammar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~"
+"\u0000\u0002L\u0000\tnameClassq\u0000~\u0000\u000fxq\u0000~\u0000\u0003q\u0000~\u0000\u0013psq\u0000~\u0000\u0015ppsr\u0000\"com.sun.msv.datat"
+"ype.xsd.QnameType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u001aq\u0000~\u0000 t\u0000\u0005QNamesr\u00005com.sun.m"
+"sv.datatype.xsd.WhiteSpaceProcessor$Collapse\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000"
+"#q\u0000~\u0000&sq\u0000~\u0000\'q\u0000~\u0000/q\u0000~\u0000 sr\u0000#com.sun.msv.grammar.SimpleNameClas"
+"s\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u001dL\u0000\fnamespaceURIq\u0000~\u0000\u001dxr\u0000\u001dcom.sun"
+".msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpt\u0000\u0004typet\u0000)http://www.w3.o"
+"rg/2001/XMLSchema-instancesr\u00000com.sun.msv.grammar.Expression"
+"$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003sq\u0000~\u0000\u0012\u0001psq\u0000~\u00003t\u0000\u000eGroupOwn"
+"erNamet\u0000\u0000q\u0000~\u00009sq\u0000~\u0000\u000epp\u0000sq\u0000~\u0000\u0000ppq\u0000~\u0000\u0018sq\u0000~\u0000\fppsq\u0000~\u0000*q\u0000~\u0000\u0013pq\u0000~\u0000"
+",q\u0000~\u00005q\u0000~\u00009sq\u0000~\u00003t\u0000\tGroupNameq\u0000~\u0000=sq\u0000~\u0000\fppsq\u0000~\u0000\u000eq\u0000~\u0000\u0013p\u0000sq\u0000~\u0000"
+"\u0000ppq\u0000~\u0000\u0018sq\u0000~\u0000\fppsq\u0000~\u0000*q\u0000~\u0000\u0013pq\u0000~\u0000,q\u0000~\u00005q\u0000~\u00009sq\u0000~\u00003t\u0000\tGroupDes"
+"cq\u0000~\u0000=q\u0000~\u00009sq\u0000~\u0000\fppsq\u0000~\u0000\u000eq\u0000~\u0000\u0013p\u0000sq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0015ppsr\u0000 com.sun."
+"msv.datatype.xsd.IntType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000+com.sun.msv.datatype."
+"xsd.IntegerDerivedType\u0099\u00f1]\u0090&6k\u00be\u0002\u0000\u0001L\u0000\nbaseFacetst\u0000)Lcom/sun/ms"
+"v/datatype/xsd/XSDatatypeImpl;xq\u0000~\u0000\u001aq\u0000~\u0000 t\u0000\u0003intq\u0000~\u00001sr\u0000*com."
+"sun.msv.datatype.xsd.MaxInclusiveFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000#com.sun"
+".msv.datatype.xsd.RangeFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\nlimitValuet\u0000\u0012Ljava"
+"/lang/Object;xr\u00009com.sun.msv.datatype.xsd.DataTypeWithValueC"
+"onstraintFacet\"\u00a7Ro\u00ca\u00c7\u008aT\u0002\u0000\u0000xr\u0000*com.sun.msv.datatype.xsd.DataTy"
+"peWithFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0005Z\u0000\fisFacetFixedZ\u0000\u0012needValueCheckFlagL\u0000"
+"\bbaseTypeq\u0000~\u0000QL\u0000\fconcreteTypet\u0000\'Lcom/sun/msv/datatype/xsd/Co"
+"ncreteType;L\u0000\tfacetNameq\u0000~\u0000\u001dxq\u0000~\u0000\u001cppq\u0000~\u00001\u0000\u0001sr\u0000*com.sun.msv.d"
+"atatype.xsd.MinInclusiveFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000Uppq\u0000~\u00001\u0000\u0000sr\u0000!c"
+"om.sun.msv.datatype.xsd.LongType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000Pq\u0000~\u0000 t\u0000\u0004lon"
+"gq\u0000~\u00001sq\u0000~\u0000Tppq\u0000~\u00001\u0000\u0001sq\u0000~\u0000[ppq\u0000~\u00001\u0000\u0000sr\u0000$com.sun.msv.datatype"
+".xsd.IntegerType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000Pq\u0000~\u0000 t\u0000\u0007integerq\u0000~\u00001sr\u0000,com"
+".sun.msv.datatype.xsd.FractionDigitsFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001I\u0000\u0005scale"
+"xr\u0000;com.sun.msv.datatype.xsd.DataTypeWithLexicalConstraintFa"
+"cetT\u0090\u001c>\u001azb\u00ea\u0002\u0000\u0000xq\u0000~\u0000Xppq\u0000~\u00001\u0001\u0000sr\u0000#com.sun.msv.datatype.xsd.Nu"
+"mberType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u001aq\u0000~\u0000 t\u0000\u0007decimalq\u0000~\u00001q\u0000~\u0000it\u0000\u000efractio"
+"nDigits\u0000\u0000\u0000\u0000q\u0000~\u0000ct\u0000\fminInclusivesr\u0000\u000ejava.lang.Long;\u008b\u00e4\u0090\u00cc\u008f#\u00df\u0002\u0000\u0001"
+"J\u0000\u0005valuexr\u0000\u0010java.lang.Number\u0086\u00ac\u0095\u001d\u000b\u0094\u00e0\u008b\u0002\u0000\u0000xp\u0080\u0000\u0000\u0000\u0000\u0000\u0000\u0000q\u0000~\u0000ct\u0000\fmax"
+"Inclusivesq\u0000~\u0000m\u007f\u00ff\u00ff\u00ff\u00ff\u00ff\u00ff\u00ffq\u0000~\u0000^q\u0000~\u0000lsr\u0000\u0011java.lang.Integer\u0012\u00e2\u00a0\u00a4\u00f7\u0081"
+"\u00878\u0002\u0000\u0001I\u0000\u0005valuexq\u0000~\u0000n\u0080\u0000\u0000\u0000q\u0000~\u0000^q\u0000~\u0000psq\u0000~\u0000r\u007f\u00ff\u00ff\u00ffq\u0000~\u0000&sq\u0000~\u0000\'q\u0000~\u0000Sq"
+"\u0000~\u0000 sq\u0000~\u0000\fppsq\u0000~\u0000*q\u0000~\u0000\u0013pq\u0000~\u0000,q\u0000~\u00005q\u0000~\u00009sq\u0000~\u00003t\u0000\u000bGroupOptionq"
+"\u0000~\u0000=q\u0000~\u00009sq\u0000~\u0000\fppsq\u0000~\u0000\u000eq\u0000~\u0000\u0013p\u0000sq\u0000~\u0000\u0000ppq\u0000~\u0000\u0018sq\u0000~\u0000\fppsq\u0000~\u0000*q\u0000~"
+"\u0000\u0013pq\u0000~\u0000,q\u0000~\u00005q\u0000~\u00009sq\u0000~\u00003t\u0000\u0011GroupCreationDateq\u0000~\u0000=q\u0000~\u00009sq\u0000~\u0000\f"
+"ppsq\u0000~\u0000\u000eq\u0000~\u0000\u0013p\u0000sq\u0000~\u0000\u0000ppq\u0000~\u0000\u0018sq\u0000~\u0000\fppsq\u0000~\u0000*q\u0000~\u0000\u0013pq\u0000~\u0000,q\u0000~\u00005q\u0000"
+"~\u00009sq\u0000~\u00003t\u0000\u0011GroupModifiedDateq\u0000~\u0000=q\u0000~\u00009sq\u0000~\u0000\fppsq\u0000~\u0000\u000eq\u0000~\u0000\u0013p\u0000"
+"sq\u0000~\u0000\u0000ppsq\u0000~\u0000\u000epp\u0000sq\u0000~\u0000\fppsr\u0000 com.sun.msv.grammar.OneOrMoreEx"
+"p\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001ccom.sun.msv.grammar.UnaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\u0003ex"
+"pq\u0000~\u0000\u0002xq\u0000~\u0000\u0003q\u0000~\u0000\u0013psq\u0000~\u0000*q\u0000~\u0000\u0013psr\u00002com.sun.msv.grammar.Expres"
+"sion$AnyStringExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003q\u0000~\u0000:psr\u0000 com.sun.m"
+"sv.grammar.AnyNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u00004q\u0000~\u00009sq\u0000~\u00003t\u0000)com.mv"
+"nforum.jaxb.db.GlobalPermissionListt\u0000+http://java.sun.com/ja"
+"xb/xjc/dummy-elementssq\u0000~\u0000\fppsq\u0000~\u0000*q\u0000~\u0000\u0013pq\u0000~\u0000,q\u0000~\u00005q\u0000~\u00009sq\u0000~"
+"\u00003t\u0000\u0014GlobalPermissionListq\u0000~\u0000=q\u0000~\u00009sq\u0000~\u0000\fppsq\u0000~\u0000\u000eq\u0000~\u0000\u0013p\u0000sq\u0000~"
+"\u0000\u0000ppsq\u0000~\u0000\u000epp\u0000sq\u0000~\u0000\fppsq\u0000~\u0000\u008dq\u0000~\u0000\u0013psq\u0000~\u0000*q\u0000~\u0000\u0013pq\u0000~\u0000\u0092q\u0000~\u0000\u0094q\u0000~\u00009"
+"sq\u0000~\u00003t\u0000$com.mvnforum.jaxb.db.GroupMemberListq\u0000~\u0000\u0097sq\u0000~\u0000\fppsq"
+"\u0000~\u0000*q\u0000~\u0000\u0013pq\u0000~\u0000,q\u0000~\u00005q\u0000~\u00009sq\u0000~\u00003t\u0000\u000fGroupMemberListq\u0000~\u0000=q\u0000~\u00009s"
+"r\u0000\"com.sun.msv.grammar.ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet"
+"\u0000/Lcom/sun/msv/grammar/ExpressionPool$ClosedHash;xpsr\u0000-com.s"
+"un.msv.grammar.ExpressionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0003\u0000\u0003I\u0000\u0005countB"
+"\u0000\rstreamVersionL\u0000\u0006parentt\u0000$Lcom/sun/msv/grammar/ExpressionPo"
+"ol;xp\u0000\u0000\u0000\"\u0001pq\u0000~\u0000Kq\u0000~\u0000\u008cq\u0000~\u0000\u00a0q\u0000~\u0000\u008aq\u0000~\u0000\u009eq\u0000~\u0000\u0006q\u0000~\u0000\u0014q\u0000~\u0000?q\u0000~\u0000Fq\u0000~\u0000"
+"|q\u0000~\u0000\u0083q\u0000~\u0000\tq\u0000~\u0000\u0007q\u0000~\u0000)q\u0000~\u0000@q\u0000~\u0000Gq\u0000~\u0000vq\u0000~\u0000}q\u0000~\u0000\u0084q\u0000~\u0000\u0098q\u0000~\u0000\u00a5q\u0000~\u0000"
+"\bq\u0000~\u0000\u0088q\u0000~\u0000\u009cq\u0000~\u0000\u0005q\u0000~\u0000\u000bq\u0000~\u0000\rq\u0000~\u0000Dq\u0000~\u0000zq\u0000~\u0000\nq\u0000~\u0000\u0081q\u0000~\u0000\u008fq\u0000~\u0000\u00a1q\u0000~\u0000"
+"Mx"));
        }
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends com.mvnforum.jaxb.db.impl.runtime.AbstractUnmarshallingEventHandlerImpl
    {


        public Unmarshaller(com.mvnforum.jaxb.db.impl.runtime.UnmarshallingContext context) {
            super(context, "-------------------------");
        }

        protected Unmarshaller(com.mvnforum.jaxb.db.impl.runtime.UnmarshallingContext context, int startState) {
            this(context);
            state = startState;
        }

        public java.lang.Object owner() {
            return com.mvnforum.jaxb.db.impl.GroupTypeImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  9 :
                        if (("GroupOption" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 10;
                            return ;
                        }
                        state = 12;
                        continue outer;
                    case  3 :
                        if (("GroupName" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 4;
                            return ;
                        }
                        break;
                    case  6 :
                        if (("GroupDesc" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 7;
                            return ;
                        }
                        state = 9;
                        continue outer;
                    case  19 :
                        if (("GlobalPermission" == ___local)&&("" == ___uri)) {
                            _GlobalPermissionList = ((com.mvnforum.jaxb.db.impl.GlobalPermissionListImpl) spawnChildFromEnterElement((com.mvnforum.jaxb.db.impl.GlobalPermissionListImpl.class), 20, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        _GlobalPermissionList = ((com.mvnforum.jaxb.db.impl.GlobalPermissionListImpl) spawnChildFromEnterElement((com.mvnforum.jaxb.db.impl.GlobalPermissionListImpl.class), 20, ___uri, ___local, ___qname, __atts));
                        return ;
                    case  22 :
                        if (("GroupMember" == ___local)&&("" == ___uri)) {
                            _GroupMemberList = ((com.mvnforum.jaxb.db.impl.GroupMemberListImpl) spawnChildFromEnterElement((com.mvnforum.jaxb.db.impl.GroupMemberListImpl.class), 23, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        _GroupMemberList = ((com.mvnforum.jaxb.db.impl.GroupMemberListImpl) spawnChildFromEnterElement((com.mvnforum.jaxb.db.impl.GroupMemberListImpl.class), 23, ___uri, ___local, ___qname, __atts));
                        return ;
                    case  15 :
                        if (("GroupModifiedDate" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 16;
                            return ;
                        }
                        state = 18;
                        continue outer;
                    case  12 :
                        if (("GroupCreationDate" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 13;
                            return ;
                        }
                        state = 15;
                        continue outer;
                    case  0 :
                        if (("GroupOwnerName" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 1;
                            return ;
                        }
                        state = 3;
                        continue outer;
                    case  18 :
                        if (("GlobalPermissionList" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 19;
                            return ;
                        }
                        state = 21;
                        continue outer;
                    case  21 :
                        if (("GroupMemberList" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 22;
                            return ;
                        }
                        state = 24;
                        continue outer;
                    case  24 :
                        revertToParentFromEnterElement(___uri, ___local, ___qname, __atts);
                        return ;
                }
                super.enterElement(___uri, ___local, ___qname, __atts);
                break;
            }
        }

        public void leaveElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  9 :
                        state = 12;
                        continue outer;
                    case  14 :
                        if (("GroupCreationDate" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 15;
                            return ;
                        }
                        break;
                    case  11 :
                        if (("GroupOption" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 12;
                            return ;
                        }
                        break;
                    case  8 :
                        if (("GroupDesc" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 9;
                            return ;
                        }
                        break;
                    case  20 :
                        if (("GlobalPermissionList" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 21;
                            return ;
                        }
                        break;
                    case  6 :
                        state = 9;
                        continue outer;
                    case  19 :
                        _GlobalPermissionList = ((com.mvnforum.jaxb.db.impl.GlobalPermissionListImpl) spawnChildFromLeaveElement((com.mvnforum.jaxb.db.impl.GlobalPermissionListImpl.class), 20, ___uri, ___local, ___qname));
                        return ;
                    case  22 :
                        _GroupMemberList = ((com.mvnforum.jaxb.db.impl.GroupMemberListImpl) spawnChildFromLeaveElement((com.mvnforum.jaxb.db.impl.GroupMemberListImpl.class), 23, ___uri, ___local, ___qname));
                        return ;
                    case  15 :
                        state = 18;
                        continue outer;
                    case  12 :
                        state = 15;
                        continue outer;
                    case  0 :
                        state = 3;
                        continue outer;
                    case  2 :
                        if (("GroupOwnerName" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 3;
                            return ;
                        }
                        break;
                    case  17 :
                        if (("GroupModifiedDate" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 18;
                            return ;
                        }
                        break;
                    case  18 :
                        state = 21;
                        continue outer;
                    case  21 :
                        state = 24;
                        continue outer;
                    case  23 :
                        if (("GroupMemberList" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 24;
                            return ;
                        }
                        break;
                    case  5 :
                        if (("GroupName" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 6;
                            return ;
                        }
                        break;
                    case  24 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
                }
                super.leaveElement(___uri, ___local, ___qname);
                break;
            }
        }

        public void enterAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  9 :
                        state = 12;
                        continue outer;
                    case  6 :
                        state = 9;
                        continue outer;
                    case  19 :
                        _GlobalPermissionList = ((com.mvnforum.jaxb.db.impl.GlobalPermissionListImpl) spawnChildFromEnterAttribute((com.mvnforum.jaxb.db.impl.GlobalPermissionListImpl.class), 20, ___uri, ___local, ___qname));
                        return ;
                    case  22 :
                        _GroupMemberList = ((com.mvnforum.jaxb.db.impl.GroupMemberListImpl) spawnChildFromEnterAttribute((com.mvnforum.jaxb.db.impl.GroupMemberListImpl.class), 23, ___uri, ___local, ___qname));
                        return ;
                    case  15 :
                        state = 18;
                        continue outer;
                    case  12 :
                        state = 15;
                        continue outer;
                    case  0 :
                        state = 3;
                        continue outer;
                    case  18 :
                        state = 21;
                        continue outer;
                    case  21 :
                        state = 24;
                        continue outer;
                    case  24 :
                        revertToParentFromEnterAttribute(___uri, ___local, ___qname);
                        return ;
                }
                super.enterAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void leaveAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  9 :
                        state = 12;
                        continue outer;
                    case  6 :
                        state = 9;
                        continue outer;
                    case  19 :
                        _GlobalPermissionList = ((com.mvnforum.jaxb.db.impl.GlobalPermissionListImpl) spawnChildFromLeaveAttribute((com.mvnforum.jaxb.db.impl.GlobalPermissionListImpl.class), 20, ___uri, ___local, ___qname));
                        return ;
                    case  22 :
                        _GroupMemberList = ((com.mvnforum.jaxb.db.impl.GroupMemberListImpl) spawnChildFromLeaveAttribute((com.mvnforum.jaxb.db.impl.GroupMemberListImpl.class), 23, ___uri, ___local, ___qname));
                        return ;
                    case  15 :
                        state = 18;
                        continue outer;
                    case  12 :
                        state = 15;
                        continue outer;
                    case  0 :
                        state = 3;
                        continue outer;
                    case  18 :
                        state = 21;
                        continue outer;
                    case  21 :
                        state = 24;
                        continue outer;
                    case  24 :
                        revertToParentFromLeaveAttribute(___uri, ___local, ___qname);
                        return ;
                }
                super.leaveAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void handleText(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                try {
                    switch (state) {
                        case  9 :
                            state = 12;
                            continue outer;
                        case  6 :
                            state = 9;
                            continue outer;
                        case  19 :
                            _GlobalPermissionList = ((com.mvnforum.jaxb.db.impl.GlobalPermissionListImpl) spawnChildFromText((com.mvnforum.jaxb.db.impl.GlobalPermissionListImpl.class), 20, value));
                            return ;
                        case  7 :
                            state = 8;
                            eatText1(value);
                            return ;
                        case  22 :
                            _GroupMemberList = ((com.mvnforum.jaxb.db.impl.GroupMemberListImpl) spawnChildFromText((com.mvnforum.jaxb.db.impl.GroupMemberListImpl.class), 23, value));
                            return ;
                        case  15 :
                            state = 18;
                            continue outer;
                        case  13 :
                            state = 14;
                            eatText2(value);
                            return ;
                        case  12 :
                            state = 15;
                            continue outer;
                        case  10 :
                            state = 11;
                            eatText3(value);
                            return ;
                        case  0 :
                            state = 3;
                            continue outer;
                        case  18 :
                            state = 21;
                            continue outer;
                        case  21 :
                            state = 24;
                            continue outer;
                        case  1 :
                            state = 2;
                            eatText4(value);
                            return ;
                        case  16 :
                            state = 17;
                            eatText5(value);
                            return ;
                        case  4 :
                            state = 5;
                            eatText6(value);
                            return ;
                        case  24 :
                            revertToParentFromText(value);
                            return ;
                    }
                } catch (java.lang.RuntimeException e) {
                    handleUnexpectedTextException(value, e);
                }
                break;
            }
        }

        private void eatText1(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _GroupDesc = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText2(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _GroupCreationDate = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText3(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _GroupOption = javax.xml.bind.DatatypeConverter.parseInt(com.sun.xml.bind.WhiteSpaceProcessor.collapse(value));
                has_GroupOption = true;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText4(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _GroupOwnerName = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText5(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _GroupModifiedDate = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText6(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _GroupName = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

    }

}
