import { ComponentFixture, TestBed } from '@angular/core/testing';
import { OrganizePage } from './organize.page';

describe('OrganizePage', () => {
  let component: OrganizePage;
  let fixture: ComponentFixture<OrganizePage>;

  beforeEach(() => {
    fixture = TestBed.createComponent(OrganizePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
