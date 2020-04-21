package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Ticket;

import java.util.Arrays;
import java.util.Comparator;

@AllArgsConstructor
@NoArgsConstructor
public class TicketsRepository {
    private Ticket[] items = new Ticket[0];

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket item : items) {
            if (item.getFrom().equalsIgnoreCase(from) && item.getTo().equalsIgnoreCase(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

    public void save(Ticket item) {
        int lenght = items.length + 1;
        Ticket[] tmp = new Ticket[lenght];

        System.arraycopy(items, 0, tmp, 0, items.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    Ticket findById(int id) {
        for (Ticket item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        Ticket result = findById(id);
        if (result == null) throw new NotFoundException("Element with id: " + id + " not found");

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
