package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Consumer;

public class TransactionManager {

    public static void executeTransaction(Connection conn, Consumer<Connection> operation) {
        try {
            conn.setAutoCommit(false);
            operation.accept(conn);
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao tentar rollback: " + ex.getMessage(), ex);
            }
            throw new RuntimeException("Erro durante transação: " + e.getMessage(), e);
        } finally {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar conexão: " + ex.getMessage(), ex);
            }
        }
    }
}
