package org.example.barbershop.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Table(name = "services")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int durationMinutes;

    @ManyToMany(mappedBy = "services", fetch = FetchType.LAZY)
    private List<Barber> barbers;
}