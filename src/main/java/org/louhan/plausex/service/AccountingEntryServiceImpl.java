package org.louhan.plausex.service;

import org.louhan.plausex.xjc.AccountingEntryType;
import org.springframework.stereotype.Service;

@Service
public class AccountingEntryServiceImpl implements AccountingEntryService {

    public AccountingEntryServiceImpl() {
    }

    @Override
    public AccountingEntryType createAccountingEntry() {

        AccountingEntryType accountingEntryType = new AccountingEntryType();
        return accountingEntryType;
    }
}
