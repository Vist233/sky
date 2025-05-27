package shop.monolythe.sky.skyinday.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;

@Entity
@Table(name = "function_def")
@Data
public class FunctionDef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(columnDefinition = "TEXT")
    private String code;
    private String createdBy;
    private Instant createdAt;
}

