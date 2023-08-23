package com.example.capstone3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "The blood type must not empty")
  @Column(columnDefinition="varchar(20) not null check(blood_type='+O' or blood_type='-O' or blood_type='+A' or blood_type='-A' or blood_type='+B' or blood_type='-B' or  blood_type='+AB' or blood_type='-AB')")
    private String blood_type;

    @NotNull
    @Column(name = "pregnantOrNot", columnDefinition = "boolean default false")
    private Boolean pregnantOrNot;
    //depending on the gender

    @NotNull
    @Column(name = "isIllness", columnDefinition = "boolean default false")
    private Boolean isIllness;

    private String illness_type;


    @OneToOne
    @MapsId
    @JsonIgnore
    User user ;

}
