import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { AppComponent } from '../app.component';
import { BookDetailsComponent } from '../book-details/book-details.component';
import { RegistrationBookComponent } from '../Books-Registration/book-registration.component';
import { getLibrarydetailsService } from '../libraryManagementService.service';

import { LibraryListComponent } from './Library-list.component';

describe('Library-list Component', () => {
  let component: LibraryListComponent;
  let fixture: ComponentFixture<LibraryListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        LibraryListComponent,    
        RegistrationBookComponent,
        BookDetailsComponent
      ],
      imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule
      ],
      providers: [getLibrarydetailsService],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LibraryListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should get created', () => {
    expect(component).toBeTruthy();
  });

  it('Table data validation', () => {
    const rowData = fixture.debugElement.nativeElement.querySelector('th');    
    //expect(compiled.querySelector('button').textContent).toBe('Register');
    console.log("row Data =>",JSON.stringify(rowData));
  });
});