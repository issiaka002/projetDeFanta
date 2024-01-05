import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RexComponent } from './rex.component';

describe('RexComponent', () => {
  let component: RexComponent;
  let fixture: ComponentFixture<RexComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RexComponent]
    });
    fixture = TestBed.createComponent(RexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
