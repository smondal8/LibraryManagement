import { Component, OnInit } from '@angular/core';
import { ActivatedRoute , Router,ParamMap } from '@angular/router';
import { getLibrarydetailsService } from '../libraryManagementService.service';
import { IBook } from '../IBook';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  constructor(private route : ActivatedRoute, getlibraryDetailsSerice : getLibrarydetailsService) {
    this.service = getlibraryDetailsSerice;
   }
  private id : number = 0;
  private service : getLibrarydetailsService;
  private bookList = [];
  private erroMsg = "";
  ngOnInit() {
    //this.id = parseInt(this.route.snapshot.paramMap.get('id'));
    this.route.paramMap.subscribe((param : ParamMap)=> {
      this.id = parseInt(param.get('id'));
      //this.bookList = [""];
      this.service.getBookDetailsFromLibrary(this.id).subscribe(data => this.bookList = data,
                                                                error => this.erroMsg = error);
    });
    
    //console.log(this.id);    
  }

}
