import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UsuarioDAO {
    private EntityManagerFactory emf;

    public UsuarioDAO() {
        emf = Persistence.createEntityManagerFactory("objectdb://localhost:6136/usuarios.odb");
    }

    // Create (Agregar un Usuario)
    public void crearUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Read (Obtener un Usuario por ID)
    public Usuario obtenerUsuario(String id) {
        EntityManager em = emf.createEntityManager();
        Usuario usuario = null;
        try {
            usuario = em.find(Usuario.class, id);
        } finally {
            em.close();
        }
        return usuario;
    }

    // Update (Actualizar un Usuario)
    public void actualizarUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Delete (Eliminar un Usuario)
    public void eliminarUsuario(String id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Usuario usuario = em.find(Usuario.class, id);
            if (usuario != null) {
                em.remove(usuario);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Listar todos los usuarios
    public List<Usuario> listarUsuarios() {
        EntityManager em = emf.createEntityManager();
        List<Usuario> usuarios = null;
        try {
            usuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
        } finally {
            em.close();
        }
        return usuarios;
    }

}//fin clase
