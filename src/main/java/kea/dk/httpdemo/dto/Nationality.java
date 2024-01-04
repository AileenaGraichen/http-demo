package kea.dk.httpdemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Array;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Nationality {
    ArrayList<Country> country = new ArrayList<>();
}
