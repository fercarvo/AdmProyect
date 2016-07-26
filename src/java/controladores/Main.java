package controladores;

import controladores.Usuario;

public class Main {
  public static void main(String[] args) throws Exception {
    Usuario dao = new Usuario();
    dao.guardar("Stalyn", "alfredleo@gmail.com", "estudiante");
    
  }

} 