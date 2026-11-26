package kh.edu.istad.restapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "m2_customers") // កំណត់ឈ្មោះ Table ក្នុង Database
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;
    private String email;
    private String address;
    private String phone;
    private Boolean isDeleted;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}