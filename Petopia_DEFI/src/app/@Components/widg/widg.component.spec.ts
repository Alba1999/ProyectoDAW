import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WidgComponent } from './widg.component';

describe('WidgComponent', () => {
  let component: WidgComponent;
  let fixture: ComponentFixture<WidgComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WidgComponent]
    });
    fixture = TestBed.createComponent(WidgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
