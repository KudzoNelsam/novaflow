import { Component, inject, OnInit, signal } from '@angular/core';
import { ProjectCard } from '../project-card/project-card';
import { ProjectService } from '../project-service';

@Component({
  selector: 'app-list-project-card',
  imports: [ProjectCard],
  templateUrl: './list-project-card.html',
  styleUrl: './list-project-card.css',
})
export class ListProjectCard implements OnInit{
  projectService = inject(ProjectService);
  projects = signal<Project[]>([
    {
      id: 0,
      name: '',
      description: '',
    },
  ]);

  ngOnInit(): void {
    this.projects.set(this.projectService.getProjects());
  }


}
