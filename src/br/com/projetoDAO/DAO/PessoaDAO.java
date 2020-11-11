package br.com.projetoDAO.DAO;

import br.com.projetoDAO.Conexao.Conexao;
import br.com.projetoDAO.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PessoaDAO {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;         
    
    public boolean inserir(Pessoa pessoa)
    {
        String sql = "insert into pessoa(nome,profissao) values (?,?)";        
        con = Conexao.conectar();        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getProfissao());
            int op = pst.executeUpdate();
            boolean resultBuscaId = buscaId(pessoa);
            if(op>0 & resultBuscaId == true){ 
                System.out.println("Cadastro realizado!");   
            }
            else if(resultBuscaId == false){
                System.out.println("Erro ao buscar id!");   
            }                   
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível inserir os dados: "+e);
            return false;
        }finally{
            Conexao.desconectar(con);
        }
    }   
    
    public boolean consulta()
    {
        String sql = "Select * from pessoa";
        
        con = Conexao.conectar();
        
        try {
            pst=con.prepareStatement(sql);
            rs = pst.executeQuery();
            System.out.printf("%-5s|%-50s|%-20s\n", "ID", "Nome", "Profissao");
            while(rs.next())
            {
                System.out.printf("%-5s|%-50s|%-20s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível acessar os dados: "+e);
            return false;
        }finally{
            Conexao.desconectar(con);
        }
    }   
        
    public boolean alterar(Pessoa pessoa)
    {
        String sql = "UPDATE pessoa SET nome=?, profissao=? WHERE id=?";
        con = Conexao.conectar();
        try {
            buscaId(pessoa);
            pst = con.prepareStatement(sql);
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getProfissao());
            pst.setInt(3, pessoa.getId());
            int valida = pst.executeUpdate();
            if(valida>0){
                System.out.println("Alterado com sucesso!");              
            }
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível alterar os dados: "+e);
            return false;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public boolean consultaPorId(Pessoa pessoa)
    {
        String sql = "Select * from pessoa where id=?";        
        con = Conexao.conectar();        
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, String.valueOf(pessoa.getId()));
            rs = pst.executeQuery();
            System.out.printf("%-5s|%-50s|%-20s\n", "ID", "Nome", "Profissao");
            while(rs.next())
            {
                System.out.printf("%-5s|%-50s|%-20s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível acessar os dados: "+e);
            return false;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public boolean deletar(int id)
    {               
        String sql = "delete from pessoa where id = ?";
        con = Conexao.conectar();
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);            
            int op = pst.executeUpdate();
            if(op>0)
            System.out.println("Cadastro excluído!");
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível deletar os dados: "+e);
            return false;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public boolean buscaId(Pessoa pessoa){
        String sql = "Select MAX(id) as UltitmoId from pessoa";
        
        con = Conexao.conectar();
        
        try {
            pst=con.prepareStatement(sql);
            rs = pst.executeQuery();            
            if(rs.next())
            {
                pessoa.setId(rs.getInt(1));
            }
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível busca o id: "+e);
            return false;
        }
    }
}