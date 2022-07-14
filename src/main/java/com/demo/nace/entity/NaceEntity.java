package com.demo.nace.entity;

import com.demo.nace.converter.IntegerToLongConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * This is an entity class which represents table
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name="NaceDetails")
public class NaceEntity {

    @Id
    @Column(name="Order_Num")
    @Convert(converter = IntegerToLongConverter.class)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @Column(name = "Level")
    private String level;
    @Column(name = "Code")
    private String code;
    @Column(name = "Parent")
    private String parent;
    @Column(name = "Description")
    private String description;
    @Column(name = "This_Item_Includes")
    private String thisItemIncludes;
    @Column(name = "This_Item_Also_Includes")
    private String thisItemAlsoIncludes;
    @Column(name = "Rulings")
    private String rulings;
    @Column(name = "This_Item_Excludes")
    private String thisItemExcludes;
    @Column(name = "Reference_To_ISIC_Rev_4")
    private String referenceToIsicRev4;

}
