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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.isst.tfgapi.model.Resumen;
import es.upm.dit.isst.tfgapi.repository.ResumenRepository;

@CrossOrigin(origins = "*")
@RestController
public class ResumenController {
    private final ResumenRepository resumenRepository;
    public static final Logger log = LoggerFactory.getLogger(ResumenController.class);
    public ResumenController(ResumenRepository t){
        this.resumenRepository = t;
    }

    @GetMapping("/resumenes")
    List<Resumen> readAll(){
        return (List<Resumen>) resumenRepository.findAll();
    }
 
    @GetMapping("/resumenes/{id}")
    ResponseEntity<Resumen> read(@PathVariable Long id){    
         return resumenRepository.findById(id).map(tfg ->
         ResponseEntity.ok().body(tfg)).orElse(new ResponseEntity<Resumen>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("resumenes/{id}")
    ResponseEntity<Resumen> delete(@PathVariable Long id){
        resumenRepository.deleteById(id);  
        return ResponseEntity.ok().body(null);  
    }


    @GetMapping("/resumenes/{id}/pdf")

    public ResponseEntity<ByteArrayResource> getFilePdf(@PathVariable Long id) {

       Resumen resumen = resumenRepository.findById(id).get();

       byte[] documento = resumen.getDocumento();

       String titulo = resumen.getTitulo();

       ByteArrayResource resource = new ByteArrayResource(documento) ;
       
       HttpHeaders headers = new HttpHeaders();

       headers.setContentDispositionFormData( titulo+".pdf", titulo+".pdf");

       headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
       headers.add("Pragma", "no-cache");
       headers.add("Expires", "0");
     
       headers.setContentType(new MediaType("application", "force-download"));

       return new ResponseEntity<ByteArrayResource>(resource, headers, HttpStatus.OK);

    }

    @GetMapping("/resumenes/{id}/mp3")

    public ResponseEntity<ByteArrayResource> getFileMp3(@PathVariable Long id) {

       Resumen resumen = resumenRepository.findById(id).get();

       byte[] audio = resumen.getAudio();

       ByteArrayResource resource = new ByteArrayResource(audio) ;
       
       HttpHeaders headers = new HttpHeaders();

       headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
       headers.add("Pragma", "no-cache");
       headers.add("Expires", "0");
       headers.setContentType(new MediaType("application", "force-download"));

       return new ResponseEntity<ByteArrayResource>(resource, headers, HttpStatus.OK);
    }
    
    @PostMapping("/resumenes/crear")

    ResponseEntity<Resumen> create(@RequestBody Resumen newResumen) throws URISyntaxException {

        Resumen result = resumenRepository.save(newResumen);

      return ResponseEntity.created(new URI("/resumenes/" + result.getId())).body(result);

    }

    @PostMapping("/resumenes/{id}/incrementa")

    ResponseEntity<Resumen> incrementa(@PathVariable Long id) {

      return resumenRepository.findById(id).map(resumen -> {

        resumenRepository.save(resumen);

        return ResponseEntity.ok().body(resumen);

      }).orElse(new ResponseEntity<Resumen>(HttpStatus.NOT_FOUND));  

    }

    @PutMapping("/resumenes/{id}")

    ResponseEntity<Resumen> update(@PathVariable Long id) {

      Resumen resumen = resumenRepository.findById(id).get();

      resumen.setPublicado(true); 

      resumenRepository.save(resumen);

      return ResponseEntity.ok().body(resumen);

    }



}
