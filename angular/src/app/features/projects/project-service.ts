import { inject, Service } from '@angular/core';
import { Observable } from 'rxjs';
import { Project } from './project-model';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { ListProjects } from '../responses/list-projects';

@Service()
export class ProjectService {
  projects = [
    {
      id: 1,
      name: 'NovaFlow',
      description: 'Plateforme de gestion',
    },
    {
      id: 2,
      name: 'NovaStream',
      description: 'Plateforme vidéo',
    },
  ];

  getProjects() {
    return this.projects;
  }

  API_URL = environment.apiUrl;
  httpClient = inject(HttpClient);

  getAllProject(): Observable<ListProjects> {
    return this.httpClient.get<ListProjects>(`${this.API_URL}/projects`);
  }

  createProject(project: Project): Observable<Project[]> {
    return this.httpClient.post<Project[]>(`${this.API_URL}/projects`, project);
  }
}
