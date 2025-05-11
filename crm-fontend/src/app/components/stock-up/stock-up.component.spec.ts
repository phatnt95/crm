import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StockUpComponent } from './stock-up.component';

describe('StockUpComponent', () => {
  let component: StockUpComponent;
  let fixture: ComponentFixture<StockUpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StockUpComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StockUpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
