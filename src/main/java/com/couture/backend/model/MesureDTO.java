package com.couture.backend.model;

import com.couture.backend.domain.Mesure;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class MesureDTO {

    private Long id;

    private Double tete;

    private Double cou;

    private Double epaule;

    @JsonProperty("lBras")
    private Double lBras;

    private Double poitrine;

    private Double hanches;

    @JsonProperty("lCorps")
    private Double lCorps;

    private Double cuisse;

    @JsonProperty("hTotal")
    private Double hTotal;

    private Double genou;

    private Double mollet;

    private Double cheville;

    private Double biceps;

    private Double coude;

    private Double avantBras;

    private Double entreJambe;

    @Valid
    private MesureFemme mesureFemme;

    @NotNull
    private ClientDTO client;

    public static MesureDTO mapToDTO(Mesure mesure) {
        if (mesure == null) {
            return null;
        }
        return MesureDTO.builder()
                .id(mesure.getId())
                .tete(mesure.getTete())
                .cou(mesure.getCou())
                .epaule(mesure.getEpaule())
                .lBras(mesure.getLBras())
                .poitrine(mesure.getPoitrine())
                .hanches(mesure.getHanches())
                .lCorps(mesure.getLCorps())
                .cuisse(mesure.getCuisse())
                .hTotal(mesure.getHTotal())
                .genou(mesure.getGenou())
                .mollet(mesure.getMollet())
                .cheville(mesure.getCheville())
                .biceps(mesure.getBiceps())
                .coude(mesure.getCoude())
                .avantBras(mesure.getAvantBras())
                .entreJambe(mesure.getEntreJambe())
                .mesureFemme(mesure.getMesureFemme())
                .build();
    }

    public static Mesure mapToEntity(MesureDTO dto) {
        if (dto == null) {
            return null;
        }
        Mesure mesure = new Mesure();
        mesure.setId(dto.getId());
        mesure.setTete(dto.getTete());
        mesure.setCou(dto.getCou());
        mesure.setEpaule(dto.getEpaule());
        mesure.setLBras(dto.getLBras());
        mesure.setPoitrine(dto.getPoitrine());
        mesure.setHanches(dto.getHanches());
        mesure.setLCorps(dto.getLCorps());
        mesure.setCuisse(dto.getCuisse());
        mesure.setHTotal(dto.getHTotal());
        mesure.setGenou(dto.getGenou());
        mesure.setMollet(dto.getMollet());
        mesure.setCheville(dto.getCheville());
        mesure.setBiceps(dto.getBiceps());
        mesure.setCoude(dto.getCoude());
        mesure.setAvantBras(dto.getAvantBras());
        mesure.setEntreJambe(dto.getEntreJambe());
        mesure.setMesureFemme(dto.getMesureFemme());
        mesure.setClient(ClientDTO.mapToEntity(dto.getClient()));
        return mesure;
    }

}
