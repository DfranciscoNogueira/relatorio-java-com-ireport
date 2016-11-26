package br.com.estudo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoUtil {

    // dados do banco
    private final String DRIVER = "org.postgresql.Driver";
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USUARIO = "postgres";
    private final String SENHA = "Java@5151";
    private Connection conexao = null;

    public Connection criarConexao() {
        try {
            Class.forName(DRIVER);
            this.conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e) {
            System.out.println("Erro ao se conectar com o banco : " + URL);
            e.printStackTrace();
        }
        return this.conexao;
    }
}
