package es.upm.dit.isst.tfgapi.repository;

import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.tfgapi.model.Resumen;
import java.util.List;
import java.util.Optional;
    
public interface ResumenRepository extends CrudRepository<Resumen, Long> {

   static Optional<Resumen> findByTitulo(String titulo) {
      return null;
   }
   
   }
   