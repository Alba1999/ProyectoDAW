import { TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { AnimalService } from './animal.service';

describe('AnimalService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule], // Asegúrate de importar HttpClientModule
      providers: [AnimalService],
    });
  });

  it('should be created', () => {
    const service: AnimalService = TestBed.inject(AnimalService);
    expect(service).toBeTruthy();
  });
});
