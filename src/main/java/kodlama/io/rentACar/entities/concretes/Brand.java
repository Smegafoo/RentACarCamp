package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "Brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int ıd;

    @Column(name="name")
    private String name;


    @OneToMany(mappedBy = ("brand"))
    private List<Model> models;

}
