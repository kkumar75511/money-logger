package server.controllers;

import server.models.Transaction;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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

        String transactionSummary = "";

        for (Transaction transaction : Transaction.transactions) {

            transactionSummary += transaction.toString() + "\n";

        }

        return transactionSummary;

    }

}
