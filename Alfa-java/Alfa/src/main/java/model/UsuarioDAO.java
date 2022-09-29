package model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
  Connection conn = null;
  PreparedStatement pstm = null;

  public void saveUser(Usuario usuario) {

    // Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
    // de dados

    String sql = "INSERT INTO usuario(Nome,CPF,Senha)" + " VALUES(?,?,?)";

    try {
      // Cria uma conexão com o banco
      conn = Conexao.createConnectionToMySQL();
      // Cria um PreparedStatment, classe usada para executar a query
      pstm = conn.prepareStatement(sql);

    
      pstm.setString(1, usuario.getNome());
      // Adicionar o valor do segundo parâmetro da sql
      pstm.setString(2, usuario.getCPF());
      // Adiciona o valor do terceiro parâmetro da sql
      pstm.setString(3, usuario.getSenha());

      System.out.println(pstm);

      // Executa a sql para inserção dos dados
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

  // REMOVE
  public void removeByid(int id) {

    String sql = "DELETE FROM contato where id = ?";

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

	    // Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar no banco
	    // de dados

	    String sql = "UPDATE livros SET valor_livro = ?,nome_livro = ?,id_editora = ?,id_autor = ?"
	        + "WHERE id_autor=?";

	    try {
	      // Cria uma conexão com o banco
	      conn = Conexao.createConnectionToMySQL();
	      // Cria um PreparedStatment, classe usada para executar a query
	      pstm = conn.prepareStatement(sql);

	      // Adiciona o valor do primeiro parâmetro da sql
	      // Adiciona o valor do segundo parâmetro
	      //pstm.setDouble(1, livros.getPreco());
	      //
	      //pstm.setString(2, livros.getNome());
	      //
	      //pstm.setInt(3, livros.getEditora().getId());
	      //
	      //pstm.setInt(4, livros.getAutor().getId_Autor());
	      //
	      //pstm.setInt(5, livros.getId());

	      // Executa a sql para inserção dos dados
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
  public List<Usuario> getClientes(String emailUser) {

	    //String sql = "SELECT * FROM Usuario";
	    String sql = "SELECT Email,Senha FROM usuario WHERE Email = ?";

	    List<Usuario> user = new ArrayList<>();

	    // Classe que vai recuperar os dados do banco de dados
	    ResultSet rset = null;

	    try {
	      conn = Conexao.createConnectionToMySQL();

	      pstm = conn.prepareStatement(sql);
	      pstm.setString(1, emailUser);
	      rset = pstm.executeQuery();

	      // Enquanto existir dados no banco de dados, faça
	      while (rset.next()) {

	       Usuario usuario =  new Usuario();
	        // Recupera o id do banco e atribui ele ao objeto
	       
	        usuario.setEmail(rset.getString("Email"));
	        usuario.setSenha(rset.getString("Senha"));
	        
	        // Recupera o nome do banco e atribui ele ao objeto

	        // Adiciona o autor recuperado, a lista de autores
	        user.add(usuario);
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

	    return user;
	  }
  

}

