//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.5-b16-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.12.29 at 03:19:11 PM GMT+07:00 
//


package com.mvnforum.jaxb.db.impl;

public class MessageFolderTypeImpl implements com.mvnforum.jaxb.db.MessageFolderType, com.sun.xml.bind.JAXBObject, com.mvnforum.jaxb.db.impl.runtime.UnmarshallableObject, com.mvnforum.jaxb.db.impl.runtime.XMLSerializable, com.mvnforum.jaxb.db.impl.runtime.ValidatableObject
{

    protected java.lang.String _FolderCreationDate;
    protected java.lang.String _FolderName;
    protected com.mvnforum.jaxb.db.MessageList _MessageList;
    protected java.lang.String _FolderModifiedDate;
    protected boolean has_FolderOrder;
    protected int _FolderOrder;
    public final static java.lang.Class version = (com.mvnforum.jaxb.db.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (com.mvnforum.jaxb.db.MessageFolderType.class);
    }

    public java.lang.String getFolderCreationDate() {
        return _FolderCreationDate;
    }

    public void setFolderCreationDate(java.lang.String value) {
        _FolderCreationDate = value;
    }

    public java.lang.String getFolderName() {
        return _FolderName;
    }

    public void setFolderName(java.lang.String value) {
        _FolderName = value;
    }

    public com.mvnforum.jaxb.db.MessageList getMessageList() {
        return _MessageList;
    }

    public void setMessageList(com.mvnforum.jaxb.db.MessageList value) {
        _MessageList = value;
    }

    public java.lang.String getFolderModifiedDate() {
        return _FolderModifiedDate;
    }

    public void setFolderModifiedDate(java.lang.String value) {
        _FolderModifiedDate = value;
    }

    public int getFolderOrder() {
        return _FolderOrder;
    }

    public void setFolderOrder(int value) {
        _FolderOrder = value;
        has_FolderOrder = true;
    }

    public com.mvnforum.jaxb.db.impl.runtime.UnmarshallingEventHandler createUnmarshaller(com.mvnforum.jaxb.db.impl.runtime.UnmarshallingContext context) {
        return new com.mvnforum.jaxb.db.impl.MessageFolderTypeImpl.Unmarshaller(context);
    }

    public void serializeBody(com.mvnforum.jaxb.db.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        context.startElement("", "FolderName");
        context.endNamespaceDecls();
        context.endAttributes();
        try {
            context.text(((java.lang.String) _FolderName), "FolderName");
        } catch (java.lang.Exception e) {
            com.mvnforum.jaxb.db.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
        if (has_FolderOrder) {
            context.startElement("", "FolderOrder");
            context.endNamespaceDecls();
            context.endAttributes();
            try {
                context.text(javax.xml.bind.DatatypeConverter.printInt(((int) _FolderOrder)), "FolderOrder");
            } catch (java.lang.Exception e) {
                com.mvnforum.jaxb.db.impl.runtime.Util.handlePrintConversionException(this, e, context);
            }
            context.endElement();
        }
        if (_FolderCreationDate!= null) {
            context.startElement("", "FolderCreationDate");
            context.endNamespaceDecls();
            context.endAttributes();
            try {
                context.text(((java.lang.String) _FolderCreationDate), "FolderCreationDate");
            } catch (java.lang.Exception e) {
                com.mvnforum.jaxb.db.impl.runtime.Util.handlePrintConversionException(this, e, context);
            }
            context.endElement();
        }
        if (_FolderModifiedDate!= null) {
            context.startElement("", "FolderModifiedDate");
            context.endNamespaceDecls();
            context.endAttributes();
            try {
                context.text(((java.lang.String) _FolderModifiedDate), "FolderModifiedDate");
            } catch (java.lang.Exception e) {
                com.mvnforum.jaxb.db.impl.runtime.Util.handlePrintConversionException(this, e, context);
            }
            context.endElement();
        }
        if (_MessageList!= null) {
            context.startElement("", "MessageList");
            context.childAsURIs(((com.sun.xml.bind.JAXBObject) _MessageList), "MessageList");
            context.endNamespaceDecls();
            context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _MessageList), "MessageList");
            context.endAttributes();
            context.childAsBody(((com.sun.xml.bind.JAXBObject) _MessageList), "MessageList");
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
        return (com.mvnforum.jaxb.db.MessageFolderType.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.su"
+"n.msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/gra"
+"mmar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expressi"
+"on\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0002L\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000b"
+"expandedExpq\u0000~\u0000\u0002xpppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsr\u0000\'com.sun.msv."
+"grammar.trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\tnameClasst\u0000\u001fLcom/su"
+"n/msv/grammar/NameClass;xr\u0000\u001ecom.sun.msv.grammar.ElementExp\u0000\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000\fcontentModelq\u0000~\u0000\u0002xq"
+"\u0000~\u0000\u0003pp\u0000sq\u0000~\u0000\u0000ppsr\u0000\u001bcom.sun.msv.grammar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002"
+"dtt\u0000\u001fLorg/relaxng/datatype/Datatype;L\u0000\u0006exceptq\u0000~\u0000\u0002L\u0000\u0004namet\u0000\u001d"
+"Lcom/sun/msv/util/StringPair;xq\u0000~\u0000\u0003ppsr\u0000#com.sun.msv.datatyp"
+"e.xsd.StringType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001Z\u0000\risAlwaysValidxr\u0000*com.sun.msv.d"
+"atatype.xsd.BuiltinAtomicType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.data"
+"type.xsd.ConcreteType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatype.xsd"
+".XSDatatypeImpl\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\fnamespaceUrit\u0000\u0012Ljava/lang/Strin"
+"g;L\u0000\btypeNameq\u0000~\u0000\u0016L\u0000\nwhiteSpacet\u0000.Lcom/sun/msv/datatype/xsd/"
+"WhiteSpaceProcessor;xpt\u0000 http://www.w3.org/2001/XMLSchemat\u0000\u0006"
+"stringsr\u00005com.sun.msv.datatype.xsd.WhiteSpaceProcessor$Prese"
+"rve\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,com.sun.msv.datatype.xsd.WhiteSpaceProcess"
+"or\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xp\u0001sr\u00000com.sun.msv.grammar.Expression$NullSetEx"
+"pression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003ppsr\u0000\u001bcom.sun.msv.util.StringPair\u00d0t"
+"\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u0016L\u0000\fnamespaceURIq\u0000~\u0000\u0016xpq\u0000~\u0000\u001aq\u0000~\u0000\u0019sr"
+"\u0000\u001dcom.sun.msv.grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0001ppsr\u0000 com.su"
+"n.msv.grammar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0002L\u0000\tnameClass"
+"q\u0000~\u0000\nxq\u0000~\u0000\u0003sr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000psq\u0000~\u0000"
+"\u000eppsr\u0000\"com.sun.msv.datatype.xsd.QnameType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0013q\u0000"
+"~\u0000\u0019t\u0000\u0005QNamesr\u00005com.sun.msv.datatype.xsd.WhiteSpaceProcessor$"
+"Collapse\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u001cq\u0000~\u0000\u001fsq\u0000~\u0000 q\u0000~\u0000+q\u0000~\u0000\u0019sr\u0000#com.sun.ms"
+"v.grammar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u0016L\u0000\fname"
+"spaceURIq\u0000~\u0000\u0016xr\u0000\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpt"
+"\u0000\u0004typet\u0000)http://www.w3.org/2001/XMLSchema-instancesr\u00000com.su"
+"n.msv.grammar.Expression$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003s"
+"q\u0000~\u0000&\u0001psq\u0000~\u0000/t\u0000\nFolderNamet\u0000\u0000sq\u0000~\u0000\"ppsq\u0000~\u0000\tq\u0000~\u0000\'p\u0000sq\u0000~\u0000\u0000ppsq"
+"\u0000~\u0000\u000eppsr\u0000 com.sun.msv.datatype.xsd.IntType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000+com"
+".sun.msv.datatype.xsd.IntegerDerivedType\u0099\u00f1]\u0090&6k\u00be\u0002\u0000\u0001L\u0000\nbaseFa"
+"cetst\u0000)Lcom/sun/msv/datatype/xsd/XSDatatypeImpl;xq\u0000~\u0000\u0013q\u0000~\u0000\u0019t"
+"\u0000\u0003intq\u0000~\u0000-sr\u0000*com.sun.msv.datatype.xsd.MaxInclusiveFacet\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000#com.sun.msv.datatype.xsd.RangeFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\n"
+"limitValuet\u0000\u0012Ljava/lang/Object;xr\u00009com.sun.msv.datatype.xsd."
+"DataTypeWithValueConstraintFacet\"\u00a7Ro\u00ca\u00c7\u008aT\u0002\u0000\u0000xr\u0000*com.sun.msv.d"
+"atatype.xsd.DataTypeWithFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0005Z\u0000\fisFacetFixedZ\u0000\u0012ne"
+"edValueCheckFlagL\u0000\bbaseTypeq\u0000~\u0000@L\u0000\fconcreteTypet\u0000\'Lcom/sun/m"
+"sv/datatype/xsd/ConcreteType;L\u0000\tfacetNameq\u0000~\u0000\u0016xq\u0000~\u0000\u0015ppq\u0000~\u0000-\u0000"
+"\u0001sr\u0000*com.sun.msv.datatype.xsd.MinInclusiveFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq"
+"\u0000~\u0000Dppq\u0000~\u0000-\u0000\u0000sr\u0000!com.sun.msv.datatype.xsd.LongType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000"
+"\u0000xq\u0000~\u0000?q\u0000~\u0000\u0019t\u0000\u0004longq\u0000~\u0000-sq\u0000~\u0000Cppq\u0000~\u0000-\u0000\u0001sq\u0000~\u0000Jppq\u0000~\u0000-\u0000\u0000sr\u0000$co"
+"m.sun.msv.datatype.xsd.IntegerType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000?q\u0000~\u0000\u0019t\u0000\u0007i"
+"ntegerq\u0000~\u0000-sr\u0000,com.sun.msv.datatype.xsd.FractionDigitsFacet\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001I\u0000\u0005scalexr\u0000;com.sun.msv.datatype.xsd.DataTypeWithL"
+"exicalConstraintFacetT\u0090\u001c>\u001azb\u00ea\u0002\u0000\u0000xq\u0000~\u0000Gppq\u0000~\u0000-\u0001\u0000sr\u0000#com.sun.m"
+"sv.datatype.xsd.NumberType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0013q\u0000~\u0000\u0019t\u0000\u0007decimalq\u0000"
+"~\u0000-q\u0000~\u0000Xt\u0000\u000efractionDigits\u0000\u0000\u0000\u0000q\u0000~\u0000Rt\u0000\fminInclusivesr\u0000\u000ejava.la"
+"ng.Long;\u008b\u00e4\u0090\u00cc\u008f#\u00df\u0002\u0000\u0001J\u0000\u0005valuexr\u0000\u0010java.lang.Number\u0086\u00ac\u0095\u001d\u000b\u0094\u00e0\u008b\u0002\u0000\u0000xp\u0080"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0000q\u0000~\u0000Rt\u0000\fmaxInclusivesq\u0000~\u0000\\\u007f\u00ff\u00ff\u00ff\u00ff\u00ff\u00ff\u00ffq\u0000~\u0000Mq\u0000~\u0000[sr\u0000\u0011java."
+"lang.Integer\u0012\u00e2\u00a0\u00a4\u00f7\u0081\u00878\u0002\u0000\u0001I\u0000\u0005valuexq\u0000~\u0000]\u0080\u0000\u0000\u0000q\u0000~\u0000Mq\u0000~\u0000_sq\u0000~\u0000a\u007f\u00ff\u00ff"
+"\u00ffq\u0000~\u0000\u001fsq\u0000~\u0000 q\u0000~\u0000Bq\u0000~\u0000\u0019sq\u0000~\u0000\"ppsq\u0000~\u0000$q\u0000~\u0000\'pq\u0000~\u0000(q\u0000~\u00001q\u0000~\u00005sq\u0000"
+"~\u0000/t\u0000\u000bFolderOrderq\u0000~\u00009q\u0000~\u00005sq\u0000~\u0000\"ppsq\u0000~\u0000\tq\u0000~\u0000\'p\u0000sq\u0000~\u0000\u0000ppq\u0000~\u0000"
+"\u0011sq\u0000~\u0000\"ppsq\u0000~\u0000$q\u0000~\u0000\'pq\u0000~\u0000(q\u0000~\u00001q\u0000~\u00005sq\u0000~\u0000/t\u0000\u0012FolderCreationD"
+"ateq\u0000~\u00009q\u0000~\u00005sq\u0000~\u0000\"ppsq\u0000~\u0000\tq\u0000~\u0000\'p\u0000sq\u0000~\u0000\u0000ppq\u0000~\u0000\u0011sq\u0000~\u0000\"ppsq\u0000~\u0000"
+"$q\u0000~\u0000\'pq\u0000~\u0000(q\u0000~\u00001q\u0000~\u00005sq\u0000~\u0000/t\u0000\u0012FolderModifiedDateq\u0000~\u00009q\u0000~\u00005s"
+"q\u0000~\u0000\"ppsq\u0000~\u0000\tq\u0000~\u0000\'p\u0000sq\u0000~\u0000\u0000ppsq\u0000~\u0000\tpp\u0000sq\u0000~\u0000\"ppsr\u0000 com.sun.msv"
+".grammar.OneOrMoreExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001ccom.sun.msv.grammar.Unar"
+"yExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\u0003expq\u0000~\u0000\u0002xq\u0000~\u0000\u0003q\u0000~\u0000\'psq\u0000~\u0000$q\u0000~\u0000\'psr\u00002com.su"
+"n.msv.grammar.Expression$AnyStringExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000"
+"\u0003q\u0000~\u00006psr\u0000 com.sun.msv.grammar.AnyNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u00000"
+"q\u0000~\u00005sq\u0000~\u0000/t\u0000 com.mvnforum.jaxb.db.MessageListt\u0000+http://java"
+".sun.com/jaxb/xjc/dummy-elementssq\u0000~\u0000\"ppsq\u0000~\u0000$q\u0000~\u0000\'pq\u0000~\u0000(q\u0000~"
+"\u00001q\u0000~\u00005sq\u0000~\u0000/t\u0000\u000bMessageListq\u0000~\u00009q\u0000~\u00005sr\u0000\"com.sun.msv.grammar"
+".ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/grammar"
+"/ExpressionPool$ClosedHash;xpsr\u0000-com.sun.msv.grammar.Express"
+"ionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0003\u0000\u0003I\u0000\u0005countB\u0000\rstreamVersionL\u0000\u0006pare"
+"ntt\u0000$Lcom/sun/msv/grammar/ExpressionPool;xp\u0000\u0000\u0000\u0014\u0001pq\u0000~\u0000:q\u0000~\u0000\u0006q"
+"\u0000~\u0000{q\u0000~\u0000yq\u0000~\u0000\rq\u0000~\u0000kq\u0000~\u0000rq\u0000~\u0000\u0007q\u0000~\u0000#q\u0000~\u0000eq\u0000~\u0000lq\u0000~\u0000sq\u0000~\u0000\u0087q\u0000~\u0000wq"
+"\u0000~\u0000\bq\u0000~\u0000iq\u0000~\u0000pq\u0000~\u0000\u0005q\u0000~\u0000~q\u0000~\u0000<x"));
        }
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends com.mvnforum.jaxb.db.impl.runtime.AbstractUnmarshallingEventHandlerImpl
    {


        public Unmarshaller(com.mvnforum.jaxb.db.impl.runtime.UnmarshallingContext context) {
            super(context, "----------------");
        }

        protected Unmarshaller(com.mvnforum.jaxb.db.impl.runtime.UnmarshallingContext context, int startState) {
            this(context);
            state = startState;
        }

        public java.lang.Object owner() {
            return com.mvnforum.jaxb.db.impl.MessageFolderTypeImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  15 :
                        revertToParentFromEnterElement(___uri, ___local, ___qname, __atts);
                        return ;
                    case  13 :
                        if (("Message" == ___local)&&("" == ___uri)) {
                            _MessageList = ((com.mvnforum.jaxb.db.impl.MessageListImpl) spawnChildFromEnterElement((com.mvnforum.jaxb.db.impl.MessageListImpl.class), 14, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        _MessageList = ((com.mvnforum.jaxb.db.impl.MessageListImpl) spawnChildFromEnterElement((com.mvnforum.jaxb.db.impl.MessageListImpl.class), 14, ___uri, ___local, ___qname, __atts));
                        return ;
                    case  6 :
                        if (("FolderCreationDate" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 7;
                            return ;
                        }
                        state = 9;
                        continue outer;
                    case  3 :
                        if (("FolderOrder" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 4;
                            return ;
                        }
                        state = 6;
                        continue outer;
                    case  9 :
                        if (("FolderModifiedDate" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 10;
                            return ;
                        }
                        state = 12;
                        continue outer;
                    case  0 :
                        if (("FolderName" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 1;
                            return ;
                        }
                        break;
                    case  12 :
                        if (("MessageList" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 13;
                            return ;
                        }
                        state = 15;
                        continue outer;
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
                    case  15 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
                    case  13 :
                        _MessageList = ((com.mvnforum.jaxb.db.impl.MessageListImpl) spawnChildFromLeaveElement((com.mvnforum.jaxb.db.impl.MessageListImpl.class), 14, ___uri, ___local, ___qname));
                        return ;
                    case  5 :
                        if (("FolderOrder" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 6;
                            return ;
                        }
                        break;
                    case  6 :
                        state = 9;
                        continue outer;
                    case  8 :
                        if (("FolderCreationDate" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 9;
                            return ;
                        }
                        break;
                    case  3 :
                        state = 6;
                        continue outer;
                    case  11 :
                        if (("FolderModifiedDate" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 12;
                            return ;
                        }
                        break;
                    case  9 :
                        state = 12;
                        continue outer;
                    case  12 :
                        state = 15;
                        continue outer;
                    case  14 :
                        if (("MessageList" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 15;
                            return ;
                        }
                        break;
                    case  2 :
                        if (("FolderName" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 3;
                            return ;
                        }
                        break;
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
                    case  15 :
                        revertToParentFromEnterAttribute(___uri, ___local, ___qname);
                        return ;
                    case  13 :
                        _MessageList = ((com.mvnforum.jaxb.db.impl.MessageListImpl) spawnChildFromEnterAttribute((com.mvnforum.jaxb.db.impl.MessageListImpl.class), 14, ___uri, ___local, ___qname));
                        return ;
                    case  6 :
                        state = 9;
                        continue outer;
                    case  3 :
                        state = 6;
                        continue outer;
                    case  9 :
                        state = 12;
                        continue outer;
                    case  12 :
                        state = 15;
                        continue outer;
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
                    case  15 :
                        revertToParentFromLeaveAttribute(___uri, ___local, ___qname);
                        return ;
                    case  13 :
                        _MessageList = ((com.mvnforum.jaxb.db.impl.MessageListImpl) spawnChildFromLeaveAttribute((com.mvnforum.jaxb.db.impl.MessageListImpl.class), 14, ___uri, ___local, ___qname));
                        return ;
                    case  6 :
                        state = 9;
                        continue outer;
                    case  3 :
                        state = 6;
                        continue outer;
                    case  9 :
                        state = 12;
                        continue outer;
                    case  12 :
                        state = 15;
                        continue outer;
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
                        case  15 :
                            revertToParentFromText(value);
                            return ;
                        case  13 :
                            _MessageList = ((com.mvnforum.jaxb.db.impl.MessageListImpl) spawnChildFromText((com.mvnforum.jaxb.db.impl.MessageListImpl.class), 14, value));
                            return ;
                        case  1 :
                            state = 2;
                            eatText1(value);
                            return ;
                        case  10 :
                            state = 11;
                            eatText2(value);
                            return ;
                        case  6 :
                            state = 9;
                            continue outer;
                        case  3 :
                            state = 6;
                            continue outer;
                        case  9 :
                            state = 12;
                            continue outer;
                        case  7 :
                            state = 8;
                            eatText3(value);
                            return ;
                        case  4 :
                            state = 5;
                            eatText4(value);
                            return ;
                        case  12 :
                            state = 15;
                            continue outer;
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
                _FolderName = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText2(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _FolderModifiedDate = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText3(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _FolderCreationDate = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText4(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _FolderOrder = javax.xml.bind.DatatypeConverter.parseInt(com.sun.xml.bind.WhiteSpaceProcessor.collapse(value));
                has_FolderOrder = true;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

    }

}
