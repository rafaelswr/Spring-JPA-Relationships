package dev.jpa.Models;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "courseMaterial")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "courseMaterial_sequence",
            sequenceName = "courseMaterial_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "courseMaterial_sequence"
    )
    private Long cmId;

    private String url;

    public CourseMaterial(String url) {
        this.url = url;
    }
}
