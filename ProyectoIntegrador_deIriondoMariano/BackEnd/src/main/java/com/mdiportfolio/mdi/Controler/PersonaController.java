
package com.mdiportfolio.mdi.Controler;

import com.mdiportfolio.mdi.Entity.Persona;
import com.mdiportfolio.mdi.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired
    IPersonaService ipersonaService;
    
    @GetMapping("/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue correctamente creada";
    }
    
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable int id){
        ipersonaService.deletePersona(id);
        return "la persona fue correctamente borrada";
    }
    
    @PutMapping("/editar/{id}")
    public  Persona editPersona(@PathVariable int id, 
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("descripcion") String nuevoDescripcion,
                                @RequestParam("img") String nuevoImg){
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setDescripcion(nuevoDescripcion);
        persona.setImg(nuevoImg);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
    @GetMapping("/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((int)1);}
}
