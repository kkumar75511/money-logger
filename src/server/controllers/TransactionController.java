package server.controllers;

import server.Console;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/transaction")
public class TransactionController {

    @POST
    @Path("new")
    @Produces(MediaType.TEXT_PLAIN)
    public String transactionHandler (@FormParam("transactionAmount") String transactionAmount,
                                      @FormParam("transactionCategory[]") String transactionCategory,
                                      @FormParam("transactionDate") String transactionDate) {

        Console.log("Transaction: £" + transactionAmount + " , " + transactionCategory + " , " + transactionDate);
        return "Transaction of " + transactionAmount + " pounds added to the " + transactionCategory + " category on " + transactionDate + ".";

    }

}
