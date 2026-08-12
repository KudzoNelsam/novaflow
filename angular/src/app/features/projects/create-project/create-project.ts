import { Component, inject, output, signal } from '@angular/core';
import { ButtonDirective } from 'primeng/button';
import { Project } from '../project-model';
import { form, FormField, minLength, required, submit } from '@angular/forms/signals';
import { ProjectService } from '../project-service';
import { MessageService } from 'primeng/api';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-create-project',
  imports: [ButtonDirective, FormField],
  templateUrl: './create-project.html',
  styleUrl: './create-project.css',
})
export class CreateProject {
  projectService = inject(ProjectService);
  private messageService = inject(MessageService);

  // Annonceur
  projectCreated = output<Project>();

  // Define form state as a plain writable signal
  projectModel = signal<Project>({
    name: '',
    description: '',
  });
  submitted = signal(false);

  projectForm = form(this.projectModel, (schemaPath) => {
    required(schemaPath.name, { message: 'Le nom du projet est obligatoire' });
    minLength(schemaPath.name, 3, { message: 'Le nom doit contenir au moins 3 caractères' });

    required(schemaPath.description, { message: 'La description est obligatoire' });
  });

  async createProject(event: Event) {
    event.preventDefault();
    this.submitted.set(true);

    await submit(this.projectForm, async (form) => {
      try {
        const createdProject = await firstValueFrom(
          this.projectService.createProject(form().value()),
        );

        this.projectCreated.emit(createdProject);

        this.messageService.add({
          severity: 'success',
          summary: 'Projet créé',
          detail: 'Le projet a été créé avec succès.',
        });

        this.projectModel.set({
          name: '',
          description: '',
        });
        
        this.submitted.set(false);
      } catch (error) {
        this.messageService.add({
          severity: 'error',
          summary: 'Erreur',
          detail: 'La création du projet a échoué. Veuillez réessayer.',
        });
      }
    });
  }
}
