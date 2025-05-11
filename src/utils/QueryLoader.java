package utils;

import java.io.InputStream;
import java.util.Properties;

public class QueryLoader {

    private static final Properties queries = new Properties();

    static {
        try {
            InputStream input = QueryLoader.class.getClassLoader().getResourceAsStream("sql.properties");

            if (input == null) {
                throw new RuntimeException("Arquivo sql.properties não encontrado");
            }

            queries.load(input);
            System.out.println("sql.properties carregado com sucesso ✅");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar sql.properties", e);
        }
    }

    public static String getQuery(String key) {
        return queries.getProperty(key);
    }
}
