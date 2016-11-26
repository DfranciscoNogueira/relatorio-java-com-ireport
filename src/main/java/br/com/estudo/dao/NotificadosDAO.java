package br.com.estudo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.estudo.util.ConexaoUtil;

public class NotificadosDAO {

    private static NotificadosDAO instance;

    private ConexaoUtil conexaoUtil;
    private Connection conexao;
    private Statement stm;
    private ResultSet rs;

    private NotificadosDAO() {
        this.conexaoUtil = new ConexaoUtil();
    }

    // cria uma instancia da classe NotificacaoDAO (singleton)
    public static NotificadosDAO getInstance() {
        if (instance == null)
            instance = new NotificadosDAO();
        return instance;
    }

    public ResultSet buscarPessoasNotificadas() {
        try {
            conexao = conexaoUtil.criarConexao();
            stm = conexao.createStatement();
            String query = "SELECT nome FROM public.\"Pessoas\";";
            rs = stm.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}
