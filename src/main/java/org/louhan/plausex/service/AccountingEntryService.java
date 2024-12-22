package org.louhan.plausex.service;

import org.louhan.plausex.xjc.AccountingEntryType;

import javax.xml.datatype.XMLGregorianCalendar;

public interface AccountingEntryService {

    AccountingEntryType createAccountingEntry();

    AccountingEntryType createAccountingEntryType(
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
            String personIdRef);
}
