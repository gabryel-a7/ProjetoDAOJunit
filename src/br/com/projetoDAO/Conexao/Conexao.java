package br.com.projetoDAO.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexao {
    public static Connection conectar(){
        Connection con = null;
        final String URL = "jdbc:mysql://localhost:3306/projetoDAO?useTimezone=true&serverTimezone=UTC";
        final String USER = "root";
        final String PASS = "Abcdefgh@1";
        
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao se conectar:"+e);
        }      
        return null;
    }
    
    public static void desconectar(Connection conexao)
    {
        try {
            conexao.close();
        } catch (Exception e) {
            System.out.println("Não foi possível desconectar: "+e);
        }
    }   
}
