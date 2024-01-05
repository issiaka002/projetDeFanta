import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateenvironComponent } from './createenviron.component';

describe('CreateenvironComponent', () => {
  let component: CreateenvironComponent;
  let fixture: ComponentFixture<CreateenvironComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateenvironComponent]
    });
    fixture = TestBed.createComponent(CreateenvironComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
