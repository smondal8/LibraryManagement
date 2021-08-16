import { HttpClientModule } from '@angular/common/http';
import { TestBed, async } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { table } from 'console';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookDetailsComponent } from './book-details/book-details.component';
import { RegistrationBookComponent } from './Books-Registration/book-registration.component';
import { LibraryListComponent } from './Library-list/Library-list.component';
import { getLibrarydetailsService } from './libraryManagementService.service';

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        BrowserModule,        
        AppRoutingModule,
        HttpClientModule,
        FormsModule
      ],
      declarations: [
        AppComponent,
        LibraryListComponent,    
        RegistrationBookComponent,
        BookDetailsComponent
      ],
      providers: [getLibrarydetailsService],  
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'Library Management System'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('Library Management System');    
  });

  it('should render title in a h1 tag', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Welcome to Library Management System!');
  });

  it('Register button Validation', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;    
    expect(compiled.querySelector('button').textContent).toBe('Register');
  });

  it('Register button Validation', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;    
    expect(compiled.querySelector('button').textContent).toBe('Register');
  });

  it('Verification of the library details table' , () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    //let tableRows = .querySelector('tr');
    console.log("Table details",JSON.stringify(fixture.debugElement.nativeElement.querySelector('library-list')));
   // expect(tableRows.length).toBe(4);
  })

});
