package model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

public class UsuarioDAO {
  Connection conn = null;
  PreparedStatement pstm = null;

  public void saveUser(Usuario usuario) {

    String sql = "INSERT INTO user(Nome,CPF,Senha)" + " VALUES(?,?,?)";

    try {
      conn = Conexao.createConnectionToMySQL();
      pstm = conn.prepareStatement(sql);
      pstm.setString(1, usuario.getNome());
      pstm.setString(2, usuario.getCPF());
      pstm.setString(3, usuario.getSenha());
      System.out.println(pstm);

      // Executa a sql para inserção dos dados
      pstm.execute();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      
      try {
        if (pstm != null) {

          pstm.close();
        }

        if (conn != null) {
          conn.close();
        }

      } catch (Exception e) {

        e.printStackTrace();
      }
    }
  }

  // REMOVE
  public void removeByid(int id) {

    String sql = "DELETE FROM user where id = ?";

    try {
      conn = Conexao.createConnectionToMySQL();
      // cria conexao

      pstm = conn.prepareStatement(sql);
      // passa o comando sql para o objeto pstm
      pstm.setInt(1, id);
      // seta o id no comando sql
      pstm.execute();
      // executa o comando sql que está no objeto pstm
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // Fecha as conexões
      try {
        if (pstm != null) {

          pstm.close();
        }

        if (conn != null) {
          conn.close();
        }

      } catch (Exception e) {

        e.printStackTrace();
      }
    }
  }
  
  //UPDATE
  
  public void update(Usuario usuario) {

	 

	    String sql = "UPDATE livros SET valor_livro = ?,nome_livro = ?,id_editora = ?,id_autor = ?"
	        + "WHERE id_autor=?";

	    try {
	      // Cria uma conexão com o banco
	      conn = Conexao.createConnectionToMySQL();
	      // Cria um PreparedStatment, classe usada para executar a query
	      pstm = conn.prepareStatement(sql);

	      //pstm.setDouble(1, livros.getPreco());
	  
	      //pstm.setString(2, livros.getNome());
	  
	      //pstm.setInt(3, livros.getEditora().getId());
	
	      //pstm.setInt(4, livros.getAutor().getId_Autor());
	      
	      //pstm.setInt(5, livros.getId());

	      pstm.execute();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      // Fecha as conexões
	      try {
	        if (pstm != null) {

	          pstm.close();
	        }

	        if (conn != null) {
	          conn.close();
	        }

	      } catch (Exception e) {

	        e.printStackTrace();
	      }
	    }
	  }
  

  
  //GET USUARIO
  public Usuario getClientes(String cpf) {

	    
	    String sql = "SELECT Email,Senha,CPF FROM user WHERE cpf = ?";

	  

	    ResultSet rset = null;

	    try {
	      conn = Conexao.createConnectionToMySQL();

	      pstm = conn.prepareStatement(sql);
	      pstm.setString(1, cpf);
	      rset = pstm.executeQuery();

	      while (rset.next()) {

	    	  
	      Usuario user = new Usuario();
	     
	       	user.setCPF(rset.getString("CPF"));
	        user.setEmail(rset.getString("Email"));
	        user.setSenha(rset.getString("Senha"));
	        

	        return user;
	       
	      }
	    } catch (Exception e) {

	      e.printStackTrace();
	    } finally {

	      try {

	        if (rset != null) {

	          rset.close();
	        }

	        if (pstm != null) {

	          pstm.close();
	        }

	        if (conn != null) {
	          conn.close();
	        }

	      } catch (Exception e) {

	        e.printStackTrace();
	      }
	    }
		return null;

	   
	  }
  //verificaBAnco
  
 
  public String verifica(List<Usuario> usuario, String CPF) {
	  
	  
	for(Usuario user: usuario) {
			
			System.out.println(user.getCPF());
			if(user.getCPF().equals(CPF)) {
				
				System.out.println("vc já tem conta");
				return "TRUE";
				  
				
			}else {
				System.out.println("vc não tem conta");
				return "false";
			}
			
		}
	return CPF;
			  
  }
  

}

