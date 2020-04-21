package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket {
    private int id;
    private int coast;
    private String from;
    private String to;
    private int flightTime;
}
