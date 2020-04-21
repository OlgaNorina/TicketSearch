package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketsComparatorByTime;
import ru.netology.repository.TicketsRepository;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketsManager {
    TicketsRepository repository;

    public void add(Ticket item) {
        repository.save(item);
    }

    public Ticket[] search(String from, String to) {
        TicketsComparatorByTime comparator = new TicketsComparatorByTime();
        return repository.findAll(from, to, comparator);
    }
}
