package org.example.barbershop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Table(name = "barbershops")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Barbershop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "barbershop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Barber> barbers;
}
