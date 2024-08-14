package main.com.webtoons.util;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    public static class DBPool {
        private static final BasicDataSource dataSource = new BasicDataSource();

        private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
        private static final String URL = "jdbc:mysql://localhost:3306/webtoons";
        private static final String USER = "root";
        private static final String PASSWORD = "0602";

        static {
            dataSource.setDriverClassName(DRIVER);
            dataSource.setUrl(URL);
            dataSource.setUsername(USER);
            dataSource.setPassword(PASSWORD);
        }

        public static Connection getDataSource() throws SQLException {
            return dataSource.getConnection();
        }
    }
}
