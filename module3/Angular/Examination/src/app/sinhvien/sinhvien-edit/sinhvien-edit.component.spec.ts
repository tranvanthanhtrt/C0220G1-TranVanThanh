import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SinhvienEditComponent } from './sinhvien-edit.component';

describe('CustomerEditComponent', () => {
  let component: SinhvienEditComponent;
  let fixture: ComponentFixture<SinhvienEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SinhvienEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SinhvienEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
