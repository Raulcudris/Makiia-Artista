package com.makiia.crosscutting.domain.model;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class EntyRecmaetarivalorDto {
    private String rec_secreg_retp;
    private String apj_nroreg_aphp;
    private String rec_tipres_repe;
    private String rec_titulo_retp;
    private String rec_notmem_retp;
    private String rec_notdet_retp;
    private String rec_image1_retp;
    private String rec_image2_retp;
    private String rec_image3_retp;
    private Integer rec_ordvis_retp;
    private String rec_tipmon_retm;
    private Integer rec_precio_retp;
    private Integer rec_estreg_retp;
}
