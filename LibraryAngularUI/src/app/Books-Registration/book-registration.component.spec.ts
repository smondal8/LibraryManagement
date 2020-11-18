import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { RegistrationBookComponent } from './book-registration.component';

describe('RegistrationMoviesComponent', () => {
  let component: RegistrationBookComponent;
  let fixture: ComponentFixture<RegistrationBookComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistrationBookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
