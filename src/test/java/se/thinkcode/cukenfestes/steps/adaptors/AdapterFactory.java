package se.thinkcode.cukenfestes.steps.adaptors;

import se.thinkcode.cukenfestes.Database;
import se.thinkcode.cukenfestes.infrastructure.InMemoryDatabase;

public class AdapterFactory {

    public TodoAdapter getAdapter() {
        Database database = getDatabase();

        Seam seam = getSeam();

        if (seam.equals(new Seam("model"))) {
            return new ModelAdaptor(database);
        }

        System.err.println("No seam, database, device, or client specified. Will default to model in memory");
        return new ModelAdaptor(database);
    }

    private Database getDatabase() {
        DatabaseSeam seam = getDatabaseSeam();
        if (seam.equals(new DatabaseSeam("in-memory"))) {
            return new InMemoryDatabase();
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
