import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PosicionComponent } from './posicion.component';

describe('PosicionComponent', () => {
  let component: PosicionComponent;
  let fixture: ComponentFixture<PosicionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PosicionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PosicionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
