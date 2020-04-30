import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LibraryListComponent } from './Library-list/Library-list.component';
import { getLibrarydetailsService } from './libraryManagementService.service';
import { HttpClientModule } from '@angular/common/http';
import { RegistrationBookComponent } from './Books-Registration/book-registration.component';
import { BookDetailsComponent } from './book-details/book-details.component';


@NgModule({
  declarations: [
    AppComponent,
    LibraryListComponent,    
    RegistrationBookComponent, BookDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [getLibrarydetailsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
