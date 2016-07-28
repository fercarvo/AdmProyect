<%-- 
    Document   : proyecto
    Created on : 24-jul-2016, 11:49:23
    Author     : Usuario
--%>

<%@page import="controladores.listaDeProyectos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Administrador de Proyectos</title>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.10.12/datatables.min.css"/>
    <link rel="stylesheet" href="stylesheets/styles.css">
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
            <li class="active"><a href="#">Proyectos</a></li>
            <li><a href="dashboard.jsp">Dashboard</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#about"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a></li>
            <li><a href="index.jsp">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <div class="container usuarios">
      <h2>Registro de Proyectos</h2>
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalUsuarios">Agregar Proyecto</button>
      <table id="tablaProyectos" class="table table-bordered table-striped">
        <thead>
          <tr>
            <th>#</th>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Usuario Responsable</th>
            <th>Editar</th>
            <th>Eliminar</th>
          </tr>
        </thead>
        <tbody id = "tabla">
          <%= new listaDeProyectos().tablaProyectos() %>
        </tbody>
      </table>
       
    </div>

    <!-- Modal -->
    
    <div class="modal fade" id="modalUsuarios" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <form id="formNuevoProyecto" >
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
              <h4 class="modal-title">Ingresar Proyecto</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                  <input type="text" class="form-control" id="inputNombre" name="inputNombre" placeholder="Nombre">
                </div>
                <div class="form-group">
                  <input type="text" class="form-control" id="inputDescripcion" name="inputDescripcion" placeholder="Descripcion">
                </div>
                <div class="form-group">
                  <input type="text" class="form-control responsable" id="inputResponsable" name="inputResponsable" placeholder="Nombre del Responsable">
                </div>
                
                  <input type="number" id="inputId" class="Id_proy" name="inputId" >
                
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
              <button type="submit" class="btn btn-primary">Ingresar</button>
            </div>
               
          </form>
            
        </div>
         
      </div>
        
    </div>
    <div class="modal fade" id="modalProyectosUpdate" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <form id="formUpdateProyecto" >
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
              <h4 class="modal-title">Actualizar Proyecto</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                  <input type="text" class="form-control" id="inputNombre" name="inputNombre" placeholder="Nombre">
                </div>
                <div class="form-group">
                  <input type="text" class="form-control" id="inputDescripcion" name="inputDescripcion" placeholder="Descripcion">
                </div>
                <div class="form-group">
                  <input type="text" class="form-control responsable" id="inputResponsable" name="inputResponsable" placeholder="Nombre del Responsable">
                </div>
                
                  <input type="number" id="inputId" class="Id_proy" name="inputId" >
                
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
              <button type="submit" class="btn btn-primary">Actualizar</button>
            </div>
               
          </form>
            
        </div>
         
      </div>
        
    </div>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/bs/dt-1.10.12/datatables.min.js"></script>
    <script>
        $(document).ready(function() {
            
            $('#tablaProyectos').DataTable({
                "language": {
                    url: 'i18n/dt-spanish.json'
                },
                "aoColumnDefs": [
                    { 'bSortable': false, 'aTargets': [ 4, 5 ] }
                 ]
            });
            function autoCompletar(responsable){
            $(responsable).autocomplete({
                
                source: function(request, response){
                    var nombres = [];
                     $.ajax({
                   
                   url: 'ProyectosServlet',
                   
                   success: function(data) {
                       
                       
                        $.each(data, function(index, usuario) {
                            
                            nombres.push({
                                label: usuario.nombre,
                                id:usuario.id
                            });
                        });
                        console.log(data);
                        response($.ui.autocomplete.filter(nombres, request.term));
                   }
               });
                    
                    
                },
		select: function(event, ui){
                    $(responsable).val(ui.item.label);
                    $(".Id_proy").val(ui.item.id);
                    return false;
		}
            });
        }
           $("#formNuevoProyecto").submit(function(e){
               // this.setAttribute("color","red");
                
                e.preventDefault();
               var formData=$("#formNuevoProyecto").serialize()+'&'+$.param({flag:"save"});;
               
               var url = "ProyectosServlet";
               $.ajax({
                   type: "POST",
                   url: url,
                   data:formData,
                   success:function(){
                   window.location = "proyecto.jsp";
                   
                   
               }
               });
            });
            autoCompletar(".responsable");
            $('.editarProyecto').click(function() {
 
                var userId = $(this).siblings('.userIdProyecto').text();               
                $("input#inputNombre.form-control").val( $(this).siblings('.nombre').text() );
                $("input#inputDescripcion.form-control").val( $(this).siblings('.descripcion').text() );
                     
               
                $("#formUpdateProyecto").submit(function(e){
                    e.preventDefault();
                    var formData=$("#formUpdateProyecto").serialize()+'&'+$.param({Id:userId})+'&'+$.param({flag:"update"});
                    var url = "ProyectosServlet";
                    $.ajax({
                        type: "POST",
                        url: url,
                        data:formData,
                        success:function(){
                            window.location = "proyecto.jsp";
                    }
                    });
                });
            });
            $('.eliminarProyecto').click(function() {
                
               var userId = $(this).siblings('.userIdProyecto').text();
               var url = "ProyectosServlet";
               var elemento = $(this);
               
               $.ajax({
                   type: "POST",
                   url: url,
                   data: {Id:userId,flag:"delete"},
                   success:function(){
                           elemento.parent().remove();                       
                   }
                   
               });
              
              
            });
        });
        
    </script>
  </body>
</html>