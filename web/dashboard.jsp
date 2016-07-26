<%-- 
    Document   : dashboard
    Created on : 24/07/2016, 01:55:54 PM
    Author     : stalyn
--%>

<%@page import="controladores.Proyecto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Dashboard</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.10.12/datatables.min.css"/>
    <link rel="stylesheet" href="stylesheets/styles.css">
    <style>
#board li {
  list-style: none;
  padding: 5px;
  background: #f5f5f5;
  border-radius: 5px;
  margin: 0 0 5px;
}
#board ul {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 10px;
  width: 30%;
  margin: 0 0.5%;
  display: inline-block;
  vertical-align: top;
}
#board ul.over {
  padding-bottom: 55px;
  background: url('http://www.cufonfonts.com/makeImage.php?width=650&id=1026&size=35&d=y&text=Drop%20Here') center bottom no-repeat #ccc;
}
#board ul.over li {
  background: #fff;
}

#board div h3 {display: inline-block; width: 30%; margin: 1%; text-align: center; color: #fff;}
    </style>
  </head>

  <body>
    <nav class="navbar navbar-inverse navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">AdmProyectos</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li ><a href="home.jsp">Usuarios</a></li>
            <li ><a href="proyecto.jsp">Proyectos</a></li>
            <li class="active"><a href="#">Dashboard</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#about"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a></li>
            <li><a href="index.jsp">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
      
      <div class="container">
          
        <select class="form-control">
            <%= new Proyecto().enlistarProyectos()%>
        </select>
        <div id="board">
            <div>
              <h3>Inicial</h3><h3>En Desarrollo</h3><h3>Terminado</h3>
            </div>
            <ul>
                <li><input type="text" class="form-control" id="inputTarea" placeholder="Nueva Tarea"></li>
                <div id="inicial">
                    
                </div>
            </ul>
            <ul>
                <li><input type="text" class="form-control" id="inputTarea" placeholder="Nueva Tarea"></li>
                <div id="desarrollo">
                    
                </div>
            </ul>
            <ul>
                <li><input type="text" class="form-control" id="inputTarea" placeholder="Nueva Tarea"></li>
                <div id="terminado">
                    
                </div>
            </ul>
        </div>
      </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/bs/dt-1.10.12/datatables.min.js"></script>
    <script>
        $(document).ready(function() {
            //Script del Drag and Drop
            $('li').bind('dragstart', function(event) {
              event.originalEvent.dataTransfer.setData("text/plain",  event.target.getAttribute('id'));
            });

            $('ul').bind('dragover', function(event) {
              event.preventDefault();
            });

            $('ul').bind('dragenter', function(event) {
              $(this).addClass("over");
            });

            $('ul').bind('dragleave drop', function(event) {
              $(this).removeClass("over");
            });

            $('li').bind('drop', function(event) {
              return false;
            });

            $('ul').bind('drop', function(event) {
              var listitem = event.originalEvent.dataTransfer.getData("text/plain");
              console.log(listitem);
              event.target.appendChild(document.getElementById(listitem));
              event.preventDefault();
            });
            
            //funcion para actualizar las tareas al cambiar el proyecto en el combobox
            $("select").change(function () {
                $("#inicial").empty();
                $("#desarrollo").empty();
                $("#terminado").empty();
                var url = "DashboardServlet";
                var id = $("select").val();
                console.log(id);
                $.ajax({
                   type: "POST",
                   url: url,
                   data: {
                            id_proyecto : id
                    },
                   dataType: "json",
                   success: function(result) {
                       $.each(result, function(i, tarea) {
                           $("#"+tarea.estado).append($('<li>', {
                               id: "item"+tarea.id,
                               draggable: 'true',
                               text: tarea.titulo
                            }));
                            
                       });
                   }
               });
            });
            
        });
        
    </script>
  </body>
</html>