package team.arcticfox.frms.database;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public final class Database {
    private static final String DRIVE = "com.mysql.cj.jdbc.Driver";
    private static final String IP = "arcticfoxdb.mysql.rds.aliyuncs.com";      // 121.37.221.220
    private static final int PORT = 3306;
    private static final String USERNAME = "furui";                             // root
    private static final String PASSWORD = "Furui@2022";                        // ArcticFox@2022

    private static boolean connect = false;
    private static Connection conn;
    private static Statement stmt;
    private final String url;


    public Database(String databaseName) {
        this(IP, PORT, databaseName);
    }
    public Database(String ip, int port, String databaseName) {
        this.url = "jdbc:mysql://" + ip + ":" + port + "/"
                + URLEncoder.encode(databaseName, StandardCharsets.UTF_8) + "?"         // 数据库名含空格，用Url转义
                + "allowPublicKeyRetrieval=true&"
                + "useSSL=false&"
                + "serverTimezone=UTC";
    }

    public void open() {
        open(USERNAME, PASSWORD);
    }
    public void open(String username, String password) {
        if (connect) return;

        connect = true;
        try {
            Class.forName(DRIVE);
        } catch (ClassNotFoundException e) {
            connect = false;
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            connect = false;
        }
    }
    public void close() {
        if (!connect) return;

        connect = false;
        try {
            stmt.close();
            conn.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            // Do nothing.
        }
    }
    public boolean sql(String sql) throws SQLException {
        return stmt.execute(sql);
    }
    public ResultSet sqlQuery(String sql) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public void sqlUpdate(String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
