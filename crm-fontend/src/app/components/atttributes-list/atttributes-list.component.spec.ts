import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtttributesListComponent } from './atttributes-list.component';

describe('AtttributesListComponent', () => {
  let component: AtttributesListComponent;
  let fixture: ComponentFixture<AtttributesListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AtttributesListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AtttributesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
