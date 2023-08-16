package com.couture.backend.domain;

import com.couture.backend.model.Sexe;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String prenom;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, unique = true, length = 50)
    private String cni;

    @Column(nullable = false, unique = true, length = 15)
    private String telephone;

    @Column
    @Enumerated(EnumType.STRING)
    private Sexe sexe;

    @Column(length = 50)
    private String email;

    @OneToOne(mappedBy = "client", fetch = FetchType.LAZY)
    private Mesure mesure;

}
