package com.example.capstone3;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "The name must not empty")
    @Size(min = 3, max = 15 , message = "The name must between 3 to 15")
    @Column(columnDefinition = "varchar(15) not null")
    private String name;
    @NotEmpty
    @Column(columnDefinition = "datetime not null")
    private Date birth_date;
    @NotNull(message = "The user balance must not null")
    private Double balance;
    private Integer age;

    @Column(columnDefinition = "varchar(20) not null  check(gender='m' or gender='f')")
    private String gender;


    @OneToOne(cascade =CascadeType.ALL,mappedBy = "user")
    @PrimaryKeyJoinColumn
    UserDetails userDetails;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private Set<Orders> ordersSet;


//    @ManyToMany
//    @JsonIgnore
//    private Set<Laboratories> laboratories;

}

