package se.thinkcode.cukenfestes.steps.adaptors;

import se.thinkcode.cukenfestes.todolist.InMemoryDatabase;
import se.thinkcode.cukenfestes.todolist.Database;
import se.thinkcode.cukenfestes.todolist.SqlDatabase;

public class AdapterFactory {

    public TodoAdapter getAdapter() {
        Database database = getDatabase();

        Seam seam = getSeam();

        if (seam.equals(new Seam("model"))) {
            return new ModelAdapter(database);
        }

        if (seam.equals(new Seam("rest"))) {
            return new RestAdapter(database);
        }

        System.err.println("No seam, database, device, or client specified. Will default to model in memory");
        return new ModelAdapter(database);
    }

    private Database getDatabase() {
        DatabaseSeam database = getDatabaseSeam();

        if (database.equals(new DatabaseSeam("in-memory"))) {
            return new InMemoryDatabase();
        }

        if (database.equals(new DatabaseSeam("sql"))) {
            return new SqlDatabase();
        }

        return new InMemoryDatabase();
    }

    private Seam getSeam() {
        if (System.getProperty("seam") != null) {
            String seam = System.getProperty("seam");
            return new Seam(seam);
        }

        String defaultSeam = "model";
        System.err.println("No seam specified. Specify with -Dseam=<your seam name> Will default to " + defaultSeam);
        return new Seam(defaultSeam);
    }

    private DatabaseSeam getDatabaseSeam() {
        if (System.getProperty("database") != null) {
            String database = System.getProperty("database");
            return new DatabaseSeam(database);
        }

        String defaultDatabase = "in-memory";
        System.err.println("No database specified. Specify with -Ddatabase=<your database name> Will default to " + defaultDatabase);
        return new DatabaseSeam(defaultDatabase);
    }

}
