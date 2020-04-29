import * as tslib_1 from "tslib";
import { Injectable } from '@angular/core';
let GetMovieDetailsServiceService = class GetMovieDetailsServiceService {
    constructor(httpClient) {
        this.url = "http://localhost:8282/getMovies/";
        this.httpClient = httpClient;
    }
    getMovieDetails() {
        /* return [{"movieId":1,"movieName":"The body","movieDesc":"The body is gone from morgue","year":"2020"},
        {"movieId":2,"movieName":"The Killer","movieDesc":"The body is gone from morgue","year":"2020"},
        {"movieId":3,"movieName":"Kaho Na Pyar Hai","movieDesc":"The body is gone from morgue","year":"2020"},
        {"movieId":4,"movieName":"Murder","movieDesc":"The body is gone from morgue","year":"2020"}
      ]; */
        return this.httpClient.get(this.url);
    }
};
GetMovieDetailsServiceService = tslib_1.__decorate([
    Injectable({
        providedIn: 'root'
    })
], GetMovieDetailsServiceService);
export { GetMovieDetailsServiceService };
//# sourceMappingURL=get-movie-details-service.service.js.map