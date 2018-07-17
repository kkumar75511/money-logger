package server.models.services;

import server.Console;
import server.DatabaseConnection;
import server.models.Transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TransactionService {

    public static String selectAllInto (List<Transaction> targetList) {

        targetList.clear();

        try {

            PreparedStatement statement = DatabaseConnection.newStatement(
                    "SELECT TransactionID, Amount, Category, Date FROM Transactions"
            );

            if (statement != null) {

                ResultSet results = statement.executeQuery();

                if (results != null) {

                    while (results.next()) {

                        targetList.add(new Transaction(results.getInt("TransactionID"), results.getFloat("Amount"), results.getString("Category"), results.getString("Date")));

                    }

                }

            }

        } catch (SQLException resultsException) {

            String error = "Database error - can't select all from 'Transactions' table: " + resultsException.getMessage();

            Console.log(error);
            return error;

        }

        return "OK";

    }

    public static String insert (Transaction itemToSave) {

        try {

            PreparedStatement statement = DatabaseConnection.newStatement(
                    "INSERT INTO Transactions (TransactionID, Amount, Category, Date) VALUES (?, ?, ?, ?)"
            );

            statement.setInt(1, itemToSave.getTransactionId());
            statement.setFloat(2, itemToSave.getTransactionAmount());
            statement.setString(3, itemToSave.getTransactionCategory());
            statement.setString(4, itemToSave.getTransactionDate());

            statement.executeUpdate();
            return "OK";

        } catch (SQLException resultsException) {

            String error = "Database error - can't insert into 'Transactions' table: " + resultsException.getMessage();

            Console.log(error);
            return error;

        }

    }

}
