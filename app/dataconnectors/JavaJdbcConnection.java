package dataconnectors;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import javax.inject.Inject;

import play.api.db.*;

class JavaJdbcConnection {
    private Database db;
    private DatabaseExecutionContext executionContext;

    @Inject
    public JavaJdbcConnection(Database db, DatabaseExecutionContext executionContext) {
        this.db = db;
        this.executionContext = executionContext;
    }

    public CompletionStage<Void> updateSomething() {
        return CompletableFuture.runAsync(() -> {
            // get jdbc connection
            Connection connection = db.getConnection();

            // do whatever you need with the db connection

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return;
        }, executionContext);
    }

}
