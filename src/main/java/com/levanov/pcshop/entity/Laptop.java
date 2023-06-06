package com.levanov.pcshop.entity;

import com.levanov.pcshop.entity.type.Inch;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Laptop extends Product {

    private Inch inch;

}
