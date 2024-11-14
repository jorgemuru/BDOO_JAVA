import java.util.List;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Crear usuarios
        Usuario usuario1 = new Usuario("1", "Juan Perez", "eljuan@ucu.edu.uy");
        usuarioDAO.crearUsuario(usuario1);

        Usuario usuario2 = new Usuario("2", "Juana Perez", "lajuana@ucu.edu.uy");
        usuarioDAO.crearUsuario(usuario2);

        // Leer un usuario
        Usuario usuarioObtenido = usuarioDAO.obtenerUsuario("1");
        System.out.println("1.- Nombre: " + usuarioObtenido.getNombre() + " || Email: " + usuarioObtenido.getCorreo());

        // Actualizar un usuario
        usuarioObtenido.setCorreo("juan.perez@ucu.edu.uy");
        usuarioDAO.actualizarUsuario(usuarioObtenido);

        // Listar todos los usuarios
        List<Usuario> usuarios = usuarioDAO.listarUsuarios();
        System.out.println("Lista de usuarios:");
        for (Usuario u : usuarios) {
            System.out.println(u.getNombre() + " - " + u.getCorreo());
        }

        // Eliminar un usuario
        //usuarioDAO.eliminarUsuario("1");

/*        System.out.println("Lista de usuarios actualizados:");
        for (Usuario u : usuarios) {
            System.out.println(u.getNombre() + " - " + u.getCorreo());
        }*/

    }//fin Main
}//fin clase