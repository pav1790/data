package dataconnectors;

import javax.inject.*;

import models.Event;
import models.Person;
import play.api.db.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Singleton
class JavaApplicationDatabase {

    private Database db;
    private DatabaseExecutionContext executionContext;

    @Inject
    public JavaApplicationDatabase(Database db, DatabaseExecutionContext context) {
        this.db = db;
        this.executionContext = executionContext;
    }

    public CompletionStage<Integer> exampleDBCall() {
        return CompletableFuture.supplyAsync(() -> {
            return db.withConnection(connection -> {
                // do whatever you need with the db connection
                return 1;
            });
        }, executionContext);
    }

    public boolean creatEvent(Event event) {
        CompletionStage<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            return db.withConnection(connection -> {
                Statement statement = null;
                try {
                    statement = connection.createStatement();

                    // TODO
                    // Check for Events table and create if needed
                    ResultSet resultSet = statement.executeQuery("");
                    // insert new Event


                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return 1;
            });
        }, executionContext);

        if (completableFuture.toCompletableFuture().isDone()) {
            return true;
        } else {
            return false;
        }
    }

    public Map<String, Event> getAllEvents() {
        Map<String, Event> allEvents = new HashMap<>();

        // TODO

        return allEvents;
    }

    public Event getEvent(Event event) {
        // TODO
        return null;
    }

    public Event getEvent(String id) {
        // TODO
        return null;
    }

    public boolean registerParticipant(String eventReferralId, Person participant) {
        // TODO - route through participants DB connection
        return true;
    }
}
