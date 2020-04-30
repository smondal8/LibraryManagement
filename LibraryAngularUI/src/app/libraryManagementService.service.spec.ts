import { TestBed } from '@angular/core/testing';

import { getLibrarydetailsService } from './libraryManagementService.service';

describe('GetMovieDetailsServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: getLibrarydetailsService = TestBed.get(getLibrarydetailsService);
    expect(service).toBeTruthy();
  });
});
