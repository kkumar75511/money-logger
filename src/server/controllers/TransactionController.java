package server.controllers;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/transaction")
public class TransactionController {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String transactionHandler (@FormParam("transactionAmount") String transactionAmount) {

        return "Your transaction amount is " + transactionAmount + ".";

    }

}
