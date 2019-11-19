package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "elections")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectionsEntity {

    @Id
    @Column (name = "election_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "region")
    private String region;

    @Column(name = "city")
    private String city;

    @Column(name = "alternative_name")
    private String alternative_name;

    @Column(name = "type_elections")
    private String typeElections;

    @Column(name = "year")
    private String year;

}
