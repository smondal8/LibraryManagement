import { Component, OnInit } from '@angular/core';
import { getLibrarydetailsService } from '../libraryManagementService.service';
import { Router } from '@angular/router';
import { IBook } from '../IBook';

@Component({
  selector: 'app-registration-book',
  templateUrl: "./BookRegistration.html",
  styles: []
})
export class RegistrationBookComponent implements OnInit {
  bookname : string;
  bookauthor : string;
  libid : number;
  
  router : Router;
  errorMsg : String = "";
  public getlibraryServices : getLibrarydetailsService;
  LibraryLists = [];
  constructor(getlibraryServices : getLibrarydetailsService,router : Router) {
    this.getlibraryServices = getlibraryServices;
    this.router = router;
   }

  ngOnInit() {
    this.bookauthor = this.bookname = "";      
    this.getlibraryServices.getLibraryDetails().subscribe(data => this.LibraryLists = data); 
  }
  onClick(){
    let data : IBook = {
      "id" : 0,
      "name" : this.bookname,
      "author" : this.bookauthor
    }
    console.log("Let's register movies" + data);
    this.getlibraryServices.registerMovieDetails(data,this.libid).subscribe(
      data => {
        console.log(data);
      },
      error=>this.errorMsg = error
    );
    //console.log(this.errorMsg);
    
    this.router.navigate(["/"]);
  }
  onClickCancel(){
    this.router.navigate(["/"]);
  }

}
