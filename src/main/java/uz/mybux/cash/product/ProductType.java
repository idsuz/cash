package uz.mybux.cash.product;

import lombok.Data;

import javax.persistence.*;

@Entity

@Table(name = "product_type")
@Data
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "measure_id")

    private Long measureId;
    @Column(name = "name")
    private String name;
}
