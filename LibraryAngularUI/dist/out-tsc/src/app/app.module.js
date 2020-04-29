import * as tslib_1 from "tslib";
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MovieListComponent } from './movie-list/movie-list.component';
import { MovieDetailsComponent } from './movie-details/movie-details.component';
import { GetMovieDetailsServiceService } from './get-movie-details-service.service';
import { HttpClientModule } from '@angular/common/http';
let AppModule = class AppModule {
};
AppModule = tslib_1.__decorate([
    NgModule({
        declarations: [
            AppComponent,
            MovieListComponent,
            MovieDetailsComponent
        ],
        imports: [
            BrowserModule,
            AppRoutingModule,
            HttpClientModule
        ],
        providers: [GetMovieDetailsServiceService],
        bootstrap: [AppComponent]
    })
], AppModule);
export { AppModule };
//# sourceMappingURL=app.module.js.map