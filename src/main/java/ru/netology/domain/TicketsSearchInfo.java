package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TicketsSearchInfo implements Comparable<TicketsSearchInfo> {
    private int id;
    private int coast;
    private String from;
    private String to;
    private int flightTime;

    @Override
    public int compareTo(TicketsSearchInfo o) {
        TicketsSearchInfo p = o;
        return coast - p.coast;
    }
}
