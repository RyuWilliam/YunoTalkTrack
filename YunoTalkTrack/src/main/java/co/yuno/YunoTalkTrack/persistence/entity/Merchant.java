package co.yuno.YunoTalkTrack.persistence.entity;


import jakarta.persistence.*;

@Entity(name = "merchants")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_merchant")
    private Integer idMerchant;
}

