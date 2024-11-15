package com.serviciosrest.demoserviciosrest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "habitacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitacionEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Integer idHabitacion;

    @ManyToOne
    @JoinColumn(name = "id_casa", nullable = false)
    private CasaEntity casa;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DispositivoEntity> dispositivos;

    public HabitacionEntity(String tipo, CasaEntity casa) {
        this.tipo = tipo;
        this.casa = casa;
    }
}