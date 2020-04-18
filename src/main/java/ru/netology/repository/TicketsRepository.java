package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Ticket;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketsRepository {
    Ticket[] items = new Ticket[0];

    public Ticket[] findAll() {
        return items;
    }

    public void save(Ticket item) {
        int lenght = items.length + 1;
        Ticket[] tmp = new Ticket[lenght];

        System.arraycopy(items, 0, tmp, 0, items.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public void removeById(int id) {
        int lenght = items.length - 1;
        Ticket[] tmp = new Ticket[lenght];
        int index = 0;

        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
