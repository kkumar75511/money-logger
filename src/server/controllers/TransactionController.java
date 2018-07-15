package server.controllers;

import org.json.simple.JSONArray;
import server.models.Transaction;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("transaction/")
public class TransactionController {

    @POST
    @Path("new")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String newTransaction (@FormParam("transactionAmount") float transactionAmount,
                                      @FormParam("transactionCategory[]") String transactionCategory,
                                      @FormParam("transactionDate") String transactionDate) {

        int transactionId = Transaction.nextId();

        Transaction.transactions.add(new Transaction(transactionId, transactionAmount, transactionCategory, transactionDate));

        return getTransactionList();

    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public String listTransactions () {

        return getTransactionList();

    }

    @SuppressWarnings("unchecked")
    private String getTransactionList () {

        JSONArray transactionList = new JSONArray();

        for (Transaction transaction : Transaction.transactions) {

            transactionList.add(transaction.toJSON());

        }

        return transactionList.toString();

    }

}
