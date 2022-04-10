package es.upm.dit.isst.tfgapi.repository;
import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.tfgapi.model.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    
}
