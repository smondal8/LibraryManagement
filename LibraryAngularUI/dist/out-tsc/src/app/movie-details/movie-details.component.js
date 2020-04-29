import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
let MovieDetailsComponent = class MovieDetailsComponent {
    constructor(getMovieDetailsService) {
        this.movieLists = [];
        this.getMovieDetailsService = getMovieDetailsService;
    }
    ngOnInit() {
        this.getMovieDetailsService.getMovieDetails().subscribe(data => this.movieLists = data);
    }
};
MovieDetailsComponent = tslib_1.__decorate([
    Component({
        selector: 'app-movie-details',
        template: `
  <h2>This is movie details =></h2>
  <div *ngFor="let movie of movieLists">
  <table border="2" width="70%">
  <tr>
  <td width="10%">{{movie.movieId}}</td>
  <td width="20%">{{movie.movieName}}</td>
  <td width="50%">{{movie.movieDesc}}</td>
  <td width="20%">{{movie.year}}</td>
  </tr>    
  </table>
  </div>
  `,
        styles: []
    })
], MovieDetailsComponent);
export { MovieDetailsComponent };
//# sourceMappingURL=movie-details.component.js.map