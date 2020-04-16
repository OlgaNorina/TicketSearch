package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TicketsSearchInfo implements Comparable {
    int id;
    int coast;
    String from;
    String to;
    int flightTime;

    @Override
    public int compareTo(Object o) {
        TicketsSearchInfo p = (TicketsSearchInfo) o;
        return coast - p.coast;
    }
}
