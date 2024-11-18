// DependencyInjection.java

// Interface DatabaseService
public interface DatabaseService {
    void connect();
    String getUserData();
}

// MySQL Implementation
class MySQLDatabaseService implements DatabaseService {
    @Override
    public void connect() {
        System.out.println("Connected to MySQL Database.");
    }

    @Override
    public String getUserData() {
        return "User data from MySQL.";
    }
}

// SQL Server Implementation
class SQLServerDatabaseService implements DatabaseService {
    @Override
    public void connect() {
        System.out.println("Connected to SQL Server Database.");
    }

    @Override
    public String getUserData() {
        return "User data from SQL Server.";
    }

    public void closeConnection() {
        System.out.println("SQL Server Connection Closed.");
    }
}

// PostgreSQL Implementation
class PostgreSQLDatabaseService implements DatabaseService {
    @Override
    public void connect() {
        System.out.println("Connected to PostgreSQL Database.");
    }

    @Override
    public String getUserData() {
        return "User data from PostgreSQL.";
    }

    public void rollbackTransaction() {
        System.out.println("Transaction rolled back in PostgreSQL.");
    }
}

// UserManager Class
class UserManager {
    private DatabaseService databaseService;

    public UserManager(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void manageUser() {
        databaseService.connect();
        System.out.println(databaseService.getUserData());
    }
}

// Main Class
public class DependencyInjection {
    public static void main(String[] args) {
        UserManager userManager1 = new UserManager(new MySQLDatabaseService());
        userManager1.manageUser();

        UserManager userManager2 = new UserManager(new SQLServerDatabaseService());
        userManager2.manageUser();

        UserManager userManager3 = new UserManager(new PostgreSQLDatabaseService());
        userManager3.manageUser();
    }
}
