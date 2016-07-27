package controladores;

import controladores.Tarea;

public class Main {
  public static void main(String[] args) throws Exception {
      new Tarea().guardarTarea("tarea7", "desarrollo", 1);
      new Proyecto().update("1","kilo","kilo1","1");
  }

} 