package com.springboot.codeChallenge;



import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;


@Entity
@Access( AccessType.FIELD )
public class PerfectNumber {

    private
    @Id
    @GeneratedValue
    Long recipeId;

    @JsonProperty
    Integer favouriteNumber;
    @JsonProperty
    Integer startNumber;
    @JsonProperty
    Integer endNumber;

    public PerfectNumber() {
    }

    public PerfectNumber(Integer favouriteNumber, Integer startNumber, Integer endNumber) {
        this.favouriteNumber = favouriteNumber;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

}
