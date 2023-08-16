package com.couture.backend.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MesureFemme {

    private Double dessousPoit;
    private Double crestesIliaque;
    private Double lDos;

}
