package controll;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AuthService {

    private Connection sqlCon = null;

    private static final Logger logger = LogManager.getLogger(AuthService.class);

    public AuthService() {
        sqlCon = null;
    }

    public boolean connect(String dbName, String dbLogin, String dbPwd) {
        boolean shouldICreateDatabase = false;

        if (!(new File("dbase/aaa.h2.db").isFile())) {
            shouldICreateDatabase = true;
        }

        logger.trace("Connecting to database...");

        try {
            Class.forName("org.h2.Driver");
            sqlCon = DriverManager.getConnection(dbName, dbLogin, dbPwd);

            if (shouldICreateDatabase) {
                logger.trace("Creating database and filling it...");
                try {
                    org.h2.tools.RunScript.execute(sqlCon, new FileReader("dbase/create_db.sql"));
                    org.h2.tools.RunScript.execute(sqlCon, new FileReader("dbase/fill_db.sql"));
                } catch (SQLException e) {
                    logger.error(e);
                } catch (FileNotFoundException e) {
                    logger.error(e);
                }
            }

            return true;
        } catch (Exception e) {
            logger.error("Cannot connect to the database", e);
            return false;
        }
    }

    public void closeConnection() {
        try {
            if (sqlCon != null) sqlCon.close();
        } catch (Exception e) {
            logger.error("Cannot close the connection", e);
        }
    }



}
