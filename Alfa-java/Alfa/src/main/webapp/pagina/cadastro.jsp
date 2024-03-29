<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Cadastro</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <!-- <fonte -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@200&family=Roboto&display=swap"
      rel="stylesheet"
    />

    <!-- icons -->
    <script
      src="https://kit.fontawesome.com/8a094e39a4.js"
      crossorigin="anonymous"
    ></script>
    <!-- Bootstrap CSS v5.2.0-beta1 -->
  <link rel="stylesheet" href=" ../style/bootstrap.min.css" />
    <link rel="stylesheet" href="../style/style.css" />
  </head>
  <body>
    <main>
      <a href="../index.html"><i class="fa-solid fa-arrow-left icon-volt"></i></a>
      <div class="container-fluid p-5 cad">
        <div class="row justify-content-between">
          <!-- CARD ALUNO -->

          <div class="card-cadastro col-md-5 card bg-light p-5 mt-2">
            <h3 class="text-center">
              <i class="fa-solid fa-graduation-cap"></i>
            </h3>
            <h4 class="text-center">ALUNO</h4>
            <audio src="" controls class=""></audio>

            <form action="../CadUsuarioServlet" name="formCadastro" method="post" >
             <div class="mb-3">
                <label for="" class="form-label">Nome: </label>
                <input type="text"
                 placeholder="Seu nome aqui"
                  class="text form-control" required
                  name="nome" />
              </div>
              <div class="mb-3">
                <label for="" class="form-label">CPF</label>
                <input type="text"
                 placeholder="XXX.XXX.XXX-XX"
                  class="text form-control" required
                  name="CPF" />
              </div>
              <div class="mb-3">
                <label for="" class="form-label">Senha</label>
                
                <input type="password"
                 placeholder="******" 
                 class="form-control" required 
                 name="senha"/>
                <div class="form-text">
                  A senha deve conter no minino 6 números.
                </div>
              </div>
              <div class="row">
                <input type="submit" value="CADASTRAR" class="btn btn-primary"></input>
              </div>
            </form>
          </div>

          <!--  FIM CARD ALUNO -->

        </div>
      </div>
    </main>
    
    <footer class="bg-dark text-center ">
      <a href="https://github.com/Squad-31/Alfa">
        <img src="../assets/img/Github-logo.png" alt="" >
      </a>
        <p class="text-white mb-0 mx-3" style="display: inline-block;">
          &copy; Alfa.Beto corporation
        </p>
        
    </footer>

    <!-- Bootstrap JavaScript Libraries -->
    <script
      src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
      integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
      crossorigin="anonymous"
    ></script>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
      integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
