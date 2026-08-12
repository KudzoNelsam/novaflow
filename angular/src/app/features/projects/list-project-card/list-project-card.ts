import { Component, inject } from '@angular/core';
import { ProjectCard } from '../project-card/project-card';
import { ProjectService } from '../project-service';
import { toSignal } from '@angular/core/rxjs-interop';
import { CreateProject } from '../create-project/create-project';
import { Divider } from 'primeng/divider';

@Component({
  selector: 'app-list-project-card',
  imports: [ProjectCard, CreateProject, Divider],
  templateUrl: './list-project-card.html',
  styleUrl: './list-project-card.css',
})
export class ListProjectCard {
  projectService = inject(ProjectService);
  projectsResponse = toSignal(this.projectService.getAllProject(), {
    initialValue: { projects: [] },
  });
}
