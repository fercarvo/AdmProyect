package controladores;

import controladores.Tarea;

public class Main {
  public static void main(String[] args) throws Exception {

    Usuario dao = new Usuario();
    dao.guardar("Stalyn", "alfredleo@gmail.com", "estudiante");
    

      int idProyecto = 1;
      int cant  = new Tarea().getSizeTarea(idProyecto);
      Tarea [] tareas = new Tarea().getTareasPorProyecto(idProyecto);
      System.out.println(tareas[1].getTitulo());
//      for(int i=1; i<= cant;i++) {
//          System.out.println(tareas[i-1].getTitulo());
//      }

  }

} 