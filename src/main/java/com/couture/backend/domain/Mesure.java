package com.couture.backend.domain;

import com.couture.backend.model.MesureFemme;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mesure {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double tete;

    @Column
    private Double cou;

    @Column
    private Double epaule;

    @Column
    private Double lBras;

    @Column
    private Double poitrine;

    @Column
    private Double hanches;

    @Column
    private Double lCorps;

    @Column
    private Double cuisse;

    @Column
    private Double hTotal;

    @Column
    private Double genou;

    @Column
    private Double mollet;

    @Column
    private Double cheville;

    @Column
    private Double biceps;

    @Column
    private Double coude;

    @Column
    private Double avantBras;

    @Column
    private Double entreJambe;

    @Column(columnDefinition = "json")
    @Type(JsonType.class)
    private MesureFemme mesureFemme;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false, unique = true)
    private Client client;

}
