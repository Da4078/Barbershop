package org.example.barbershop.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Table(name = "barbers")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barbershop_id", nullable = false)
    private Barbershop barbershop;

    private String specialization;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    private String image;

    @OneToMany(mappedBy = "barber", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "barber_services",
            joinColumns = @JoinColumn(name = "barber_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> services;
}