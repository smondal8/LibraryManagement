import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
let MovieListComponent = class MovieListComponent {
    constructor(getMovieService) {
        this.movieLists = [];
        this.getMovieService = getMovieService;
    }
    ngOnInit() {
        this.getMovieService.getMovieDetails().subscribe(data => this.movieLists = data);
    }
};
MovieListComponent = tslib_1.__decorate([
    Component({
        selector: 'app-movie-list',
        template: `
    <h2>This is movie lists =></h2>
    <div *ngFor="let movie of movieLists">
    <table border="2" width="70%">
    <tr><td width="10%">{{movie.movieId}}</td><td width="90%">{{movie.movieName}}</td></tr>    
    </table>
    </div>
  `,
        styles: []
    })
], MovieListComponent);
export { MovieListComponent };
//# sourceMappingURL=movie-list.component.js.map