package server.controllers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import server.Console;
import server.models.Transaction;
import server.models.services.TransactionService;

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

        Console.log("/transaction/new - Amount " + transactionAmount);

        TransactionService.selectAllInto(Transaction.transactions);

        int transactionId = Transaction.nextId();

        Transaction newTransaction = new Transaction(transactionId, transactionAmount, transactionCategory, transactionDate);

        return TransactionService.insert(newTransaction);

    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public String listTransactions () {

        Console.log("/transaction/list - Getting all transactions from database");
        String status = TransactionService.selectAllInto(Transaction.transactions);

        if (status.equals("OK")) {

            return getTransactionList();

        } else {

            JSONObject response = new JSONObject();
            response.put("error", status);

            return response.toString();

        }

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
