package com.makiia.crosscutting.persistence.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recmaetarivalor")

public class EntyRecmaetarivalor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rec_secreg_retp")
    private String rec_secreg_retp;

    @Basic(optional = false)
    @Column(name = "apj_nroreg_aphp")
    private String apj_nroreg_aphp;

    @Basic(optional = false)
    @Column(name = "rec_tipres_repe")
    private String rec_tipres_repe;

    @Basic(optional = false)
    @Column(name = "rec_titulo_retp")
    private String rec_titulo_retp;

    @Basic(optional = false)
    @Column(name = "rec_notmem_retp")
    private String rec_notmem_retp;

    @Basic(optional = false)
    @Column(name = "rec_notdet_retp")
    private String rec_notdet_retp;

    @Basic(optional = false)
    @Column(name = "rec_image1_retp")
    private String rec_image1_retp;

    @Basic(optional = false)
    @Column(name = "rec_image2_retp")
    private String rec_image2_retp;

    @Basic(optional = false)
    @Column(name = "rec_image3_retp")
    private String rec_image3_retp;

    @Basic(optional = false)
    @Column(name = "rec_ordvis_retp")
    private Integer rec_ordvis_retp;

    @Basic(optional = false)
    @Column(name = "rec_tipmon_retm")
    private String rec_tipmon_retm;

    @Basic(optional = false)
    @Column(name = "rec_precio_retp")
    private Integer rec_precio_retp;

    @Basic(optional = false)
    @Column(name = "rec_estreg_retp")
    private Integer rec_estreg_retp;
}
