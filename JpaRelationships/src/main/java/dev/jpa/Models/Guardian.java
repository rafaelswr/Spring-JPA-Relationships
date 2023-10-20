package dev.jpa.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "guardian")
public class Guardian {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long guardianID;
    private String name;
    private String mobile;
    private String email;


    public Guardian(String name, String mobile, String email) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }
}
