import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogicielComponent } from './logiciel.component';

describe('LogicielComponent', () => {
  let component: LogicielComponent;
  let fixture: ComponentFixture<LogicielComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LogicielComponent]
    });
    fixture = TestBed.createComponent(LogicielComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
