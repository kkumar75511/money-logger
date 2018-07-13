package server.models;

import java.util.ArrayList;

public class Transaction {

    private int transactionID;
    private float transactionAmount;
    private String transactionCategory;
    private String transactionDate;

    // Created an arrayList that will store every transaction
    // The arrayList is static so that only one instance of the arrayList is created
    public static ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    // Constructor
    public Transaction (int transactionID, float transactionAmount, String transactionCategory, String transactionDate) {

        this.transactionID = transactionID;
        this.transactionAmount = transactionAmount;
        this.transactionCategory = transactionCategory;
        this.transactionDate = transactionDate;

    }

    // Function that works out what the next unused id is by going through all the transactions in the arrayList
    public static int nextId () {

        int id = 0;

        for (Transaction transaction : transactions) {

            if (transaction.getTransactionID() > id) {

                id = transaction.getTransactionID();

            }

        }

        return id + 1;

    }

    @Override
    public String toString () {

        return "Transaction{" +
                "transactionID=" + transactionID +
                ", transactionAmount=" + transactionAmount +
                ", transactionCategory='" + transactionCategory + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                '}';

    }

    public int getTransactionID () { return transactionID; }

    public void setTransactionID (int transactionID) { this.transactionID = transactionID; }

    public float getTransactionAmount () { return transactionAmount; }

    public void setTransactionAmount (float transactionAmount) { this.transactionAmount = transactionAmount; }

    public String getTransactionCategory () { return transactionCategory; }

    public void setTransactionCategory (String transactionCategory) { this.transactionCategory = transactionCategory; }

    public String getTransactionDate () { return transactionDate; }

    public void setTransactionDate (String transactionDate) { this.transactionDate = transactionDate; }

}
