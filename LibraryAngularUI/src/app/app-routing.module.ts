import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrationBookComponent } from './Books-Registration/book-registration.component';
import { BookDetailsComponent } from './book-details/book-details.component';


const routes: Routes = [
  {path: 'library', component: RegistrationBookComponent},
  {path: 'books-details/:id', component: BookDetailsComponent}
  //{path: "*", component: <>}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
