import { ComponentFixture, TestBed } from '@angular/core/testing';
import { StockUpPage } from './stock-up.page';

describe('StockUpPage', () => {
  let component: StockUpPage;
  let fixture: ComponentFixture<StockUpPage>;

  beforeEach(() => {
    fixture = TestBed.createComponent(StockUpPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
