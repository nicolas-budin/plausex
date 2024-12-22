package org.louhan.plausex.service;

import org.louhan.plausex.utils.StringUtils;
import org.louhan.plausex.xjc.AccountingEntryType;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;

@Service
public class AccountingEntryServiceImpl implements AccountingEntryService {

    public AccountingEntryServiceImpl() {
    }

    @Override
    public AccountingEntryType createAccountingEntry() {

        AccountingEntryType accountingEntryType = new AccountingEntryType();
        return accountingEntryType;
    }


    @Override
    public AccountingEntryType createAccountingEntryType(
            String accountingEntryCode,
            String accountingEntryCodeDesc,
            String amount,
            XMLGregorianCalendar datRegistration,
            String datAccountingEntry,
            String datSubjectFrom,
            String datSubjectTo,
            String accountingEntryId,
            String accountingEntryProfId,
            String dossierIdRef,
            String personIdRef) {

        AccountingEntryType accountingEntry = new AccountingEntryType();

        // Vérification pour les propriétés String avec StringUtils.isValidString
        if (StringUtils.isValidString(accountingEntryCode)) {
            accountingEntry.setAccountingEntryCode(accountingEntryCode);
        }
        if (StringUtils.isValidString(accountingEntryCodeDesc)) {
            accountingEntry.setAccountingEntryCodeDesc(accountingEntryCodeDesc);
        }
        if (StringUtils.isValidString(amount)) {
            accountingEntry.setAmount(amount);
        }
        if (StringUtils.isValidString(datAccountingEntry)) {
            accountingEntry.setDatAccountingEntry(datAccountingEntry);
        }
        if (StringUtils.isValidString(datSubjectFrom)) {
            accountingEntry.setDatSubjectFrom(datSubjectFrom);
        }
        if (StringUtils.isValidString(datSubjectTo)) {
            accountingEntry.setDatSubjectTo(datSubjectTo);
        }
        if (StringUtils.isValidString(accountingEntryId)) {
            accountingEntry.setAccountingEntryId(accountingEntryId);
        }
        if (StringUtils.isValidString(accountingEntryProfId)) {
            accountingEntry.setAccountingEntryProfId(accountingEntryProfId);
        }
        if (StringUtils.isValidString(dossierIdRef)) {
            accountingEntry.setDossierIdRef(dossierIdRef);
        }
        if (StringUtils.isValidString(personIdRef)) {
            accountingEntry.setPersonIdRef(personIdRef);
        }

        // Vérifications pour les autres types (par exemple XMLGregorianCalendar)
        if (datRegistration != null) {
            accountingEntry.setDatRegistration(datRegistration);
        }

        return accountingEntry;
    }
}
