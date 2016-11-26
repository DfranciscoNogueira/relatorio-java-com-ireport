package br.com.estudo.util;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import br.com.estudo.dao.NotificadosDAO;

public class RelatorioNotificacao {

    @SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
    public void gerar() throws JRException, SQLException, ClassNotFoundException {
        
        Utilitario utilitario = new Utilitario();
        
        // nome do relatorio criado em JRXML
        String nomeReport = utilitario.getResourceDoClasspath("relatorioNotificacao.jrxml");
        
        // gerando o jasper design
        JasperDesign desenho = JRXmlLoader.load(nomeReport);

        // compila o relatório
        JasperReport relatorio = JasperCompileManager.compileReport(desenho);
        
        // dados do banco
        ResultSet rs = NotificadosDAO.getInstance().buscarPessoasNotificadas();

        // implementação da interface JRDataSource para DataSource ResultSet
        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

        // executa o relatório
        Map parametros = new HashMap();
        parametros.put("nome", new String());
        JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, jrRS);

        // exibe o resultado
        JasperViewer viewer = new JasperViewer(impressao, true);
        viewer.show();
    }
    
}