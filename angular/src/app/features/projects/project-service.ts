import { Service } from '@angular/core';

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
}
