package team.arcticfox.frms.database;

import team.arcticfox.frms.program.environment.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class Database {
    private static final String DRIVE = "com.mysql.cj.jdbc.Driver";

    private static boolean connect = false;
    private static Connection conn;
    private static Statement stmt;

    private final String databaseName;
    private final String url;

    public Database(String databaseName) {
        this.databaseName = databaseName;
        this.url = "jdbc:mysql://" + Constant.DB_URL + ":" + Constant.DB_PORT + "/"
                + URLEncoder.encode(databaseName, StandardCharsets.UTF_8) + "?"         // 数据库名含空格，用Url转义
                + "allowPublicKeyRetrieval=true&"
                + "useSSL=false&"
                + "serverTimezone=UTC";
    }

    public void open() {
        if (connect) return;

        connect = true;
        try {
            Class.forName(DRIVE);
        } catch (ClassNotFoundException e) {
            connect = false;
        }

        try {
            conn = DriverManager.getConnection(url, Constant.DB_USER, Constant.DB_PWD);
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

    public ResultSet sqlQuery(String sql) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            // Do nothing.
        }
        return rs;
    }

    public void sqlUpdate(String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // Do nothing.
        }
    }

    public boolean isConnect() {
        return connect;
    }
}
