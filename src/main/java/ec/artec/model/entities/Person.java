package ec.artec.model.entities;

import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "person")
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;

    @Column(length = 10)
    @NonNull
    private String identifier;

    @Column(length = 45)
    @NonNull
    private String name;

    @Column(length = 45)
    @NonNull
    private String lastName;

    @Column(length = 45)
    private String address;

    @Column(length = 10)
    private String phoneNumber;

    @Column(length = 45)
    @NonNull
    private String userName;

    @Column(length = 45)
    @NonNull
    private String password;
}
