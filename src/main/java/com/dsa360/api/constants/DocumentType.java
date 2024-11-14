package com.dsa360.api.constants;

public enum DocumentType {
    PROOF_OF_IDENTITY("Proof of Identity"),
    PROOF_OF_ADDRESS("Proof of Address"),
    INCOME_PROOF("Income Proof"),
    BANK_STATEMENT("Bank Statement"),
    LOAN_APPLICATION_FORM("Loan Application Form"),
    OTHER("Other");

    private final String displayName;

    DocumentType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}