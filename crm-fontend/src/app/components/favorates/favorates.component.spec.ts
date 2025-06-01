import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FavoratesComponent } from './favorates.component';

describe('FavoratesComponent', () => {
  let component: FavoratesComponent;
  let fixture: ComponentFixture<FavoratesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FavoratesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FavoratesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
