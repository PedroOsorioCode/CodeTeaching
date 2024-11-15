package com.serviciosrest.demoserviciosrest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "casa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CasaEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_casa")
    private Integer idCasa;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "casa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HabitacionEntity> habitaciones;

    public CasaEntity(String nombre) {
        this.nombre = nombre;
    }
}