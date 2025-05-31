package org.example.barbershop.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime; // Modern date-time API
import java.util.UUID;

@Table(name = "appointments")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barber_id", nullable = false)
    private Barber barber;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;
}