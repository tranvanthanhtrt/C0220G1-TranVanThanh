import { TestBed } from '@angular/core/testing';

import { SinhVienService } from './sinhVien.service';

describe('CustomerService', () => {
  let service: SinhVienService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SinhVienService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
