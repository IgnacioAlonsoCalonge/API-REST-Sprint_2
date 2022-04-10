package es.upm.dit.isst.tfgapi.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.isst.tfgapi.model.Usuario;
import es.upm.dit.isst.tfgapi.repository.UsuarioRepository;



@CrossOrigin(origins = "*")
@RestController
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    public static final Logger log = LoggerFactory.getLogger(UsuarioController.class);
    public UsuarioController(UsuarioRepository t){
        this.usuarioRepository = t;
    }

    @GetMapping("/usuarios")
    List<Usuario> readAll(){
        return (List<Usuario>) usuarioRepository.findAll();
    }
 
    @GetMapping("/usuarios/{id}")
    ResponseEntity<Usuario> read(@PathVariable Long id){    
         return usuarioRepository.findById(id).map(user ->
         ResponseEntity.ok().body(user)).orElse(new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("usuarios/{id}")
    ResponseEntity<Usuario> delete(@PathVariable Long id){
        usuarioRepository.deleteById(id);  
        return ResponseEntity.ok().body(null);  
    }

    @PostMapping("/usuarios/crear")

    ResponseEntity<Usuario> create(@RequestBody Usuario newUsuario) throws URISyntaxException {

        Usuario result = usuarioRepository.save(newUsuario);

      return ResponseEntity.created(new URI("/usuarios/" + result.getId())).body(result);

    }
}
