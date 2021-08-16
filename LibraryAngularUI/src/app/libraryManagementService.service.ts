import { Injectable } from '@angular/core';
import { HttpClient,HttpErrorResponse } from '@angular/common/http';
import { Observable,throwError } from 'rxjs';
import { IBook } from './IBook';
import { HttpHeaders } from '@angular/common/http';
import { ILibrary } from './ILibrary';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
 

@Injectable({
  providedIn: 'root'
})
export class getLibrarydetailsService {  
  public httpClient : HttpClient;
  baseUrl = environment.baseUrl;
  constructor(httpClient : HttpClient) {
    this.httpClient = httpClient;
   }

public getLibraryDetails() : Observable<ILibrary[]>{    
    return this.httpClient.get<ILibrary[]>(this.baseUrl+'/library/listAll').pipe(      
      catchError((error: HttpErrorResponse) =>{       
        return throwError(error.message || 'server error');    
      })
    );
}

errorHandler(error : HttpErrorResponse){
    return Observable.throw(error.message || "Server Error");

}

public getBookDetailsFromLibrary(libid : number) : Observable<IBook[]>{    
    return this.httpClient.get<IBook[]>(this.baseUrl+'/library/book/'+libid).pipe(      
      catchError((error: HttpErrorResponse) =>{       
         //return Observable.throw(error.message||"Server Error")
         return throwError(error.message || 'server error');    
                                            })
    );
}

public registerMovieDetails(body : IBook,id : number) : Observable<any>{
  let httpHeaders = new HttpHeaders().set('Content-Type', 'application/json');
  let options = {
    headers: httpHeaders
  }; 
  return this.httpClient.post<any>(this.baseUrl+'/updateBook/'+id,body,options).pipe(      
    catchError((error: HttpErrorResponse) =>{       
      return throwError(error.message || 'server error');    
                                          })
  );
}
}