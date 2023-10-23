package dev.jpa.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tutor")
@Data
@NoArgsConstructor
public class Tutor {
    @Id
    @SequenceGenerator(
            name = "tutor_sequence",
            sequenceName = "tutor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tutor_sequence"
    )
    private Long tutorId;
    private String name;
    private String phone;

    public Tutor(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
