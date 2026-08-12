import { Component } from '@angular/core';
import { ListProjectCard } from './list-project-card/list-project-card';

@Component({
  selector: 'app-projects',
  imports: [ListProjectCard],
  templateUrl: './projects.html',
  styleUrl: './projects.css',
})
export class Projects {}
