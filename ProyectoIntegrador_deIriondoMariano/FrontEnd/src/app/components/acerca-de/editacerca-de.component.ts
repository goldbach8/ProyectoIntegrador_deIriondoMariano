import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';


@Component({
  selector: 'app-editacerca-de',
  templateUrl: './editacerca-de.component.html',
  styleUrls: ['./editacerca-de.component.css']
})
export class EditacercadeComponent implements OnInit {
  persona: persona = null;
  
  constructor(
    private personaS: PersonaService,
    private activatedRouter : ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.personaS.getPersona().subscribe(data => {this.persona = data})
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.personaS.update(id, this.persona).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al modificar la educacion");
        this.router.navigate(['']);
      }
    )
  }

  uploadImage($event:any){

  }
}
