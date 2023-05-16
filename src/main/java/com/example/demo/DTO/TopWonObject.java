package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TopWonObject {
    String countryName;
    Integer gold;

    public TopWonObject(String countryName, Integer gold) {
        this.countryName = countryName;
        this.gold = gold;
    }
}
