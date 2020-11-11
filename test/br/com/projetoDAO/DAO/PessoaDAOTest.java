/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoDAO.DAO;

import br.com.projetoDAO.model.Pessoa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author gabry
 */
public class PessoaDAOTest {
    Pessoa pessoa;
    
    public PessoaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class PessoaDAO.
     */
    @Test    
    public void testInserir() {
        pessoa = new Pessoa(0, "Jurisvaldo", "Jurislvaldense");
        System.out.println("inserir");
        PessoaDAO pd = new PessoaDAO();
        assertTrue(pd.inserir(pessoa));
    }
    

    /**
     * Test of consulta method, of class PessoaDAO.
     */
    @Test
    public void testConsulta() {
        System.out.println("consulta");
        PessoaDAO pd = new PessoaDAO();
        assertTrue(pd.consulta());    
    }
    

    /**
     * Test of alterar method, of class PessoaDAO.
     */
    @Test
    public void testAlterar() {
        pessoa = new Pessoa(0, "JJ", "JJ");
        System.out.println("alterar");
        PessoaDAO pd = new PessoaDAO();
        assertTrue(pd.alterar(pessoa));
    }    

    /**
     * Test of consultaPorId method, of class PessoaDAO.
     */
    @Test
    public void testConsultaPorId() {
        pessoa = new Pessoa(8, "", "");
        System.out.println("consultaPorId");
        PessoaDAO pd = new PessoaDAO();
        assertTrue(pd.consultaPorId(pessoa));
    }    

    /**
     * Test of deletar method, of class PessoaDAO.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        PessoaDAO pd = new PessoaDAO();        
        assertTrue(pd.deletar(12));       
    }      
}
