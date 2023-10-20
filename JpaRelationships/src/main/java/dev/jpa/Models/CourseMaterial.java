package dev.jpa.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "courseMaterial")
public class CourseMaterial {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long courseMaterialID;

    private String url;

    public CourseMaterial(String url) {
        this.url = url;
    }
}
