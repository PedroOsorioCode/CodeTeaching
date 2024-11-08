import { ComponentFixture, TestBed } from '@angular/core/testing';
import { TecnologiaComponent } from './tecnologia.component';
import { of } from 'rxjs';
import { TecnologiaService } from '../service/tecnologia.service';

describe('TecnologiaComponent', () => {
  let component: TecnologiaComponent;
  let fixture: ComponentFixture<TecnologiaComponent>;
  let tecnologiaServiceSpy: jasmine.SpyObj<TecnologiaService>;

  const mockResponse = {
    content: [{ id: 1, nombre: 'Tecnologia 1', descripcion:"" }, { id: 2, nombre: 'Tecnologia 2', descripcion:"" }],
    pageNumber: 1,
    pageSize: 5,
    totalPages: 10,
    totalElements: 50
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TecnologiaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TecnologiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('debería cargar las tecnologías correctamente', () => {
    // Configuramos el servicio para devolver un valor simulado
    tecnologiaServiceSpy.obtenerTecnologiasPaginadas.and.returnValue(of(mockResponse));

    // Llamamos a la función que queremos probar
    component.cargarTecnologias();

    // Verificamos los resultados
    expect(component.tecnologias).toEqual(mockResponse.content);
    expect(component.pageNumber).toBe(mockResponse.pageNumber);
    expect(component.pageSize).toBe(mockResponse.pageSize);
    expect(component.totalPages).toBe(mockResponse.totalPages);
    expect(component.totalElements).toBe(mockResponse.totalElements);
    expect(tecnologiaServiceSpy.obtenerTecnologiasPaginadas).toHaveBeenCalledOnceWith({
      columnaOrdenamiento: component.columnOrder,
      direccionOrdenamiento: component.orientacion,
      numeroPagina: component.pageNumber,
      tamanoPorPagina: component.pageSize
    });
  });
});
