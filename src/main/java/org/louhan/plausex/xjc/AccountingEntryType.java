//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.12.22 at 11:05:51 PM CET 
//


package org.louhan.plausex.xjc;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAttribute;

import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for accountingEntryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accountingEntryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountingEntryCode" type="{http://bfs.ch/shs/delivery/validation}shsStringRequiredType"/>
 *         &lt;element name="accountingEntryCodeDesc" type="{http://bfs.ch/shs/delivery/validation}shsStringRequiredType"/>
 *         &lt;element name="amount" type="{http://bfs.ch/shs/delivery/validation}shsBetragType"/>
 *         &lt;element name="datRegistration" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="datAccountingEntry" type="{http://bfs.ch/shs/delivery/validation}shsDateType"/>
 *         &lt;element name="datSubjectFrom" type="{http://bfs.ch/shs/delivery/validation}shsDateType"/>
 *         &lt;element name="datSubjectTo" type="{http://bfs.ch/shs/delivery/validation}shsDateType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="accountingEntryId" use="required" type="{http://bfs.ch/shs/delivery/validation}shsStringRequiredType" />
 *       &lt;attribute name="accountingEntryProfId" use="required" type="{http://bfs.ch/shs/delivery/validation}shsStringRequiredType" />
 *       &lt;attribute name="dossierIdRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="personIdRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountingEntryType", propOrder = {
    "accountingEntryCode",
    "accountingEntryCodeDesc",
    "amount",
    "datRegistration",
    "datAccountingEntry",
    "datSubjectFrom",
    "datSubjectTo"
})
public class AccountingEntryType {

    @XmlElement(required = true)
    protected String accountingEntryCode;
    @XmlElement(required = true)
    protected String accountingEntryCodeDesc;
    @XmlElement(required = true)
    protected String amount;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datRegistration;
    @XmlElement(required = true)
    protected String datAccountingEntry;
    @XmlElement(required = true)
    protected String datSubjectFrom;
    @XmlElement(required = true)
    protected String datSubjectTo;
    @XmlAttribute(name = "accountingEntryId", required = true)
    protected String accountingEntryId;
    @XmlAttribute(name = "accountingEntryProfId", required = true)
    protected String accountingEntryProfId;
    @XmlAttribute(name = "dossierIdRef", required = true)
    protected String dossierIdRef;
    @XmlAttribute(name = "personIdRef", required = true)
    protected String personIdRef;

    /**
     * Gets the value of the accountingEntryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountingEntryCode() {
        return accountingEntryCode;
    }

    /**
     * Sets the value of the accountingEntryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountingEntryCode(String value) {
        this.accountingEntryCode = value;
    }

    /**
     * Gets the value of the accountingEntryCodeDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountingEntryCodeDesc() {
        return accountingEntryCodeDesc;
    }

    /**
     * Sets the value of the accountingEntryCodeDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountingEntryCodeDesc(String value) {
        this.accountingEntryCodeDesc = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmount(String value) {
        this.amount = value;
    }

    /**
     * Gets the value of the datRegistration property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatRegistration() {
        return datRegistration;
    }

    /**
     * Sets the value of the datRegistration property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatRegistration(XMLGregorianCalendar value) {
        this.datRegistration = value;
    }

    /**
     * Gets the value of the datAccountingEntry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatAccountingEntry() {
        return datAccountingEntry;
    }

    /**
     * Sets the value of the datAccountingEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatAccountingEntry(String value) {
        this.datAccountingEntry = value;
    }

    /**
     * Gets the value of the datSubjectFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatSubjectFrom() {
        return datSubjectFrom;
    }

    /**
     * Sets the value of the datSubjectFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatSubjectFrom(String value) {
        this.datSubjectFrom = value;
    }

    /**
     * Gets the value of the datSubjectTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatSubjectTo() {
        return datSubjectTo;
    }

    /**
     * Sets the value of the datSubjectTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatSubjectTo(String value) {
        this.datSubjectTo = value;
    }

    /**
     * Gets the value of the accountingEntryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountingEntryId() {
        return accountingEntryId;
    }

    /**
     * Sets the value of the accountingEntryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountingEntryId(String value) {
        this.accountingEntryId = value;
    }

    /**
     * Gets the value of the accountingEntryProfId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountingEntryProfId() {
        return accountingEntryProfId;
    }

    /**
     * Sets the value of the accountingEntryProfId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountingEntryProfId(String value) {
        this.accountingEntryProfId = value;
    }

    /**
     * Gets the value of the dossierIdRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDossierIdRef() {
        return dossierIdRef;
    }

    /**
     * Sets the value of the dossierIdRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDossierIdRef(String value) {
        this.dossierIdRef = value;
    }

    /**
     * Gets the value of the personIdRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonIdRef() {
        return personIdRef;
    }

    /**
     * Sets the value of the personIdRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonIdRef(String value) {
        this.personIdRef = value;
    }

}
