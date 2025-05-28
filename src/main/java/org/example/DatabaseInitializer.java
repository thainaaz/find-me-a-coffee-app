package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

    public class DatabaseInitializer {

        public static void criarTabelas() {
            String sqlUsuarios = """
                
                    CREATE TABLE IF NOT EXISTS Usuario (
                      id INTEGER PRIMARY KEY AUTOINCREMENT,
                      nome TEXT NOT NULL,
                      email TEXT NOT NULL,
                      senha TEXT NOT NULL
                  );
                """;

            String sqlLocal = """
                    CREATE TABLE IF NOT EXISTS Local (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          nome TEXT NOT NULL,
                          endereco TEXT NOT NULL
                      );
                """;

            String sqlAvaliacoes = """
               
                    CREATE TABLE IF NOT EXISTS Avaliacao (
                         id INTEGER PRIMARY KEY AUTOINCREMENT,
                         descricao TEXT NOT NULL,
                         local_id INTEGER NOT NULL,
                         FOREIGN KEY (local_id) REFERENCES Local(id)
                     );
                """;

            String sqlCaracteristicas = """
                   CREATE TABLE IF NOT EXISTS Caracteristica (
                      id INTEGER PRIMARY KEY AUTOINCREMENT,
                      nome TEXT NOT NULL,
                      local_id INTEGER NOT NULL,
                      FOREIGN KEY (local_id) REFERENCES Local(id)
                   );
                """;

            try (Connection conn = DatabaseConnector.connect();
                 Statement stmt = conn.createStatement()) {

                stmt.execute(sqlUsuarios);
                stmt.execute(sqlLocal);
                stmt.execute(sqlAvaliacoes);
                stmt.execute(sqlCaracteristicas);

                System.out.println("Tabelas criadas com sucesso!");

            } catch (SQLException e) {
                System.out.println("Erro ao criar tabelas: " + e.getMessage());
            }
        }
    }
