package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketsComparatorByTime;
import ru.netology.repository.TicketsRepository;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketsManager {
    TicketsRepository repository;
    TicketsComparatorByTime compare;

    public void add(Ticket item) {
        repository.save(item);
    }

    public Ticket[] search(String from, String to) {
        TicketsRepository founded = new TicketsRepository();
        for (Ticket item : repository.findAll()) {
            if (item.getFrom() == from && item.getTo() == to) {
                founded.save(item);
            }
        }
        Ticket[] result = founded.findAll();
        Arrays.sort(result, compare);
        return result;
    }
}
