import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CabinetDetailComponent } from './cabinet-detail.component';

describe('CabinetDetailComponent', () => {
  let component: CabinetDetailComponent;
  let fixture: ComponentFixture<CabinetDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CabinetDetailComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CabinetDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
