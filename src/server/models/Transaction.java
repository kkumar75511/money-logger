package server.models;

import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Transaction {

    private int transactionId;
    private float transactionAmount;
    private String transactionCategory;
    private String transactionDate;

    // Created an arrayList that will store every transaction
    // The arrayList is static so that only one instance of the arrayList is created
    public static ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    // Constructor
    public Transaction (int transactionId, float transactionAmount, String transactionCategory, String transactionDate) {

        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
        this.transactionCategory = transactionCategory;
        this.transactionDate = transactionDate;

    }

    // Function that works out what the next unused id is by going through all the transactions in the arrayList
    public static int nextId () {

        int id = 0;

        for (Transaction transaction : transactions) {

            if (transaction.getTransactionId() > id) {

                id = transaction.getTransactionId();

            }

        }

        return id + 1;

    }

    // Function that converts all of the transaction's elements into a JSONObject with all the correct attributes as key and value pairs
    @SuppressWarnings("unchecked")
    public JSONObject toJSON () {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", getTransactionId());
        jsonObject.put("amount", getTransactionAmount());
        jsonObject.put("category", getTransactionCategory());
        jsonObject.put("date", getTransactionDate());

        return jsonObject;

    }

    // Function that creates a string containing all of the transaction's elements
    @Override
    public String toString () {

        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionAmount=" + transactionAmount +
                ", transactionCategory='" + transactionCategory + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                '}';

    }

    public int getTransactionId () { return transactionId; }

    public void setTransactionId (int transactionId) { this.transactionId = transactionId; }

    public float getTransactionAmount () { return transactionAmount; }

    public void setTransactionAmount (float transactionAmount) { this.transactionAmount = transactionAmount; }

    public String getTransactionCategory () { return transactionCategory; }

    public void setTransactionCategory (String transactionCategory) { this.transactionCategory = transactionCategory; }

    public String getTransactionDate () { return transactionDate; }

    public void setTransactionDate (String transactionDate) { this.transactionDate = transactionDate; }

}
