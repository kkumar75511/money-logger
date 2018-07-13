package server.models;

public class Transaction {

    private int transactionID;
    private float transactionAmount;
    private String transactionCategory;
    private String transactionDate;

    // Constructor
    public Transaction (int transactionID, float transactionAmount, String transactionCategory, String transactionDate) {

        this.transactionID = transactionID;
        this.transactionAmount = transactionAmount;
        this.transactionCategory = transactionCategory;
        this.transactionDate = transactionDate;

    }

    public int getTransactionID () { return transactionID; }

    public void setTransactionID (int transactionID) { this.transactionID = transactionID; }

    public float getTransactionAmount () { return transactionAmount; }

    public void setTransactionAmount (float transactionAmount) { this.transactionAmount = transactionAmount; }

    public String getTransactionCategory () { return transactionCategory; }

    public void setTransactionCategory (String transactionCategory) { this.transactionCategory = transactionCategory; }

    public String getTransactionDate () { return transactionDate; }

    public void setTransactionDate (String transactionDate) { this.transactionDate = transactionDate; }

    @Override
    public String toString () {

        return "Transaction{" +
                "transactionID=" + transactionID +
                ", transactionAmount=" + transactionAmount +
                ", transactionCategory='" + transactionCategory + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                '}';

    }

}
