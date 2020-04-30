import { Component, OnInit } from '@angular/core';
import { getLibrarydetailsService } from 
'../libraryManagementService.service';
import { Router } from '@angular/router';

@Component({
  selector: 'library-list',
  template: `
    <h2><u>Library details</u></h2>
    <H1>{{errorMsg}}</H1>
    <table border="2" width="50%">  
    <tr><th width="20%">Library Code</th><th width="80%" colspan = "2">Library Name</th></tr>
    <tr *ngFor="let library of LibraryLists">
    <td width="20%">{{library.id}}</td><td width="70%">{{library.name}}</td>
    <td width="10%"><button (click)="onClick(library)">Details</button></td>      
    </tr>  
    </table>
    
  `,
  styles: []
})
export class LibraryListComponent implements OnInit {

  public router : Router;  
  public getMovieService : getLibrarydetailsService;
  constructor(getMovieService : getLibrarydetailsService,router : Router) {
    this.getMovieService = getMovieService;
    this.router = router;
   }

  ngOnInit() {
    this.getMovieService.getLibraryDetails().subscribe(data => this.LibraryLists = data,
                                                      error => this.errorMsg = error);
    console.log(this.LibraryLists);
  }
  public LibraryLists = [];
  public errorMsg = "";
  onClick(library){
    this.router.navigate(['books-details',library.id]);
  }

}
