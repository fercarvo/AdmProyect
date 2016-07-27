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
                <li><input type="text" class="form-control nuevaTarea" id="inputInicial" placeholder="Nueva Tarea"></li>
                <div id="inicial">
                    
                </div>
            </ul>
            <ul>
                <li><input type="text" class="form-control nuevaTarea" id="inputDesarrollo" placeholder="Nueva Tarea"></li>
                <div id="desarrollo">
                    
                </div>
            </ul>
            <ul>
                <li><input type="text" class="form-control nuevaTarea" id="inputTerminado" placeholder="Nueva Tarea"></li>
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
            var cargarTareas = function(){
                $("#inicial").empty();
                $("#desarrollo").empty();
                $("#terminado").empty();
                var url = "DashboardServlet?action=cargar";
                var id = $("select").val();
                $.ajax({
                   type: "POST",
                   url: url,
                   data: {
                            id_proyecto : id
                    },
                   dataType: "json",
                   success: function(result) {
                       $.each(result, function(i, tarea) {
                           var elem = document.createElement('li');
                           elem.id = tarea.id;
                           elem.draggable = "true";
                           elem.innerHTML = tarea.titulo;
                           $("#"+tarea.estado).append(elem);
                       });
                   }
               });
            };
            
            cargarTareas();
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
              //var id_tarea = event.originalEvent.dataTransfer.getData("text/plain")
              var id_tarea = "1";//EL DRAG ANDO DROP SOLO FUNCIONA PARA LA TAREA CON ID 1, SI QUIEREN HACER PRUEBAS CAMBIEN EL ID EN ESTA LINEA
              $(event.target).children('div').append($("#"+id_tarea));
              var estado = $(event.target).children('div').attr('id');
              event.preventDefault();
              modificarTarea(id_tarea, estado);
            });
            
            
            
            
            //funcion para actualizar las tareas al cambiar el proyecto en el combobox
            $("select").change(function () {
                cargarTareas();
            });
            
            
            //GUARDAR TAREA
            //identificar ENTER y obtener datos
            $(".nuevaTarea").keydown(function(e){
                var key = e.which;
                if(key == 13) {
                    var id_input = $(this).attr("id");//contiene el id del input
                    var titulo = $("#"+id_input).val();
                    //validando la informacion que se ingresó
                    if(titulo == "") {
                        alert("Escriba un titulo");
                    } else {
                        var estado;
                        var id_proyecto;
                        if(id_input == "inputInicial") {
                            estado = "inicial";
                        }
                        if(id_input == "inputDesarrollo") {
                            estado = "desarrollo";
                        }
                        if (id_input == "inputTerminado") {
                            estado = "terminado";
                        }
                        id_proyecto = $("select").val();//obtengo el id del proyecto
                        $("#"+id_input).val("");//borrar el input para ingresar nueva tarea
                        guardarTarea(titulo, estado, id_proyecto);
                        cargarTareas();
                    }
                }
            });
            
            var guardarTarea = function(titulo, estado, id_proyecto){
                var url = "DashboardServlet?action=guardar";
                $.ajax({
                    type: "POST",
                    url: url,
                    data: {
                        titulo: titulo,
                        estado: estado,
                        id_proyecto: id_proyecto
                    }
                });
            };
            
            var modificarTarea = function(id_tarea, estado) {
                var url = "DashboardServlet?action=modificar";
                $.ajax({
                    type: "POST",
                    url: url,
                    data: {
                        id_tarea: id_tarea,
                        estado: estado
                    }
                });
            };
        });
        
    </script>
  </body>
</html>