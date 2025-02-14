//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.12.22 at 11:05:51 PM CET 
//


package org.louhan.plausex.xjc;

import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
/**
 * <p>Java class for infosType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="infosType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ffsInfos">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ffsId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                   &lt;element name="ffsVersion" type="{http://bfs.ch/shs/delivery/validation}shsStringRequiredType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="expInfos">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="supplierId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                   &lt;element name="extractionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="referenceDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="isProd" type="{http://bfs.ch/shs/delivery/validation}shsIsProdType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infosType", propOrder = {
    "ffsInfos",
    "expInfos"
})
public class InfosType {

    @XmlElement(required = true)
    protected InfosType.FfsInfos ffsInfos;
    @XmlElement(required = true)
    protected InfosType.ExpInfos expInfos;

    /**
     * Gets the value of the ffsInfos property.
     * 
     * @return
     *     possible object is
     *     {@link FfsInfos }
     *     
     */
    public FfsInfos getFfsInfos() {
        return ffsInfos;
    }

    /**
     * Sets the value of the ffsInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link FfsInfos }
     *     
     */
    public void setFfsInfos(FfsInfos value) {
        this.ffsInfos = value;
    }

    /**
     * Gets the value of the expInfos property.
     * 
     * @return
     *     possible object is
     *     {@link ExpInfos }
     *     
     */
    public ExpInfos getExpInfos() {
        return expInfos;
    }

    /**
     * Sets the value of the expInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpInfos }
     *     
     */
    public void setExpInfos(ExpInfos value) {
        this.expInfos = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="supplierId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *         &lt;element name="extractionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="referenceDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="isProd" type="{http://bfs.ch/shs/delivery/validation}shsIsProdType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "supplierId",
        "extractionDateTime",
        "referenceDate",
        "isProd"
    })
    public static class ExpInfos {

        @XmlElement(required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger supplierId;
        @XmlElement(required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar extractionDateTime;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar referenceDate;
        @XmlElement(required = true)
        @XmlSchemaType(name = "string")
        protected ShsIsProdType isProd;

        /**
         * Gets the value of the supplierId property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getSupplierId() {
            return supplierId;
        }

        /**
         * Sets the value of the supplierId property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setSupplierId(BigInteger value) {
            this.supplierId = value;
        }

        /**
         * Gets the value of the extractionDateTime property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getExtractionDateTime() {
            return extractionDateTime;
        }

        /**
         * Sets the value of the extractionDateTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setExtractionDateTime(XMLGregorianCalendar value) {
            this.extractionDateTime = value;
        }

        /**
         * Gets the value of the referenceDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getReferenceDate() {
            return referenceDate;
        }

        /**
         * Sets the value of the referenceDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setReferenceDate(XMLGregorianCalendar value) {
            this.referenceDate = value;
        }

        /**
         * Gets the value of the isProd property.
         * 
         * @return
         *     possible object is
         *     {@link ShsIsProdType }
         *     
         */
        public ShsIsProdType getIsProd() {
            return isProd;
        }

        /**
         * Sets the value of the isProd property.
         * 
         * @param value
         *     allowed object is
         *     {@link ShsIsProdType }
         *     
         */
        public void setIsProd(ShsIsProdType value) {
            this.isProd = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ffsId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *         &lt;element name="ffsVersion" type="{http://bfs.ch/shs/delivery/validation}shsStringRequiredType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ffsId",
        "ffsVersion"
    })
    public static class FfsInfos {

        @XmlElement(required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger ffsId;
        @XmlElement(required = true)
        protected String ffsVersion;

        /**
         * Gets the value of the ffsId property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getFfsId() {
            return ffsId;
        }

        /**
         * Sets the value of the ffsId property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setFfsId(BigInteger value) {
            this.ffsId = value;
        }

        /**
         * Gets the value of the ffsVersion property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFfsVersion() {
            return ffsVersion;
        }

        /**
         * Sets the value of the ffsVersion property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFfsVersion(String value) {
            this.ffsVersion = value;
        }

    }

}
