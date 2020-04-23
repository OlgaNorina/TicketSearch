package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.TicketsSearchInfo;

@AllArgsConstructor
@NoArgsConstructor
public class TicketsRepository {
    private TicketsSearchInfo[] items = new TicketsSearchInfo[0];

    public TicketsSearchInfo[] findAll() {
        return items;
    }

    public void save(TicketsSearchInfo item) {
        int lenght = items.length + 1;
        TicketsSearchInfo[] tmp = new TicketsSearchInfo[lenght];

        System.arraycopy(items, 0, tmp, 0, items.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    TicketsSearchInfo findById(int id) {
        for (TicketsSearchInfo item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        TicketsSearchInfo result = findById(id);
        if (result == null) throw new NotFoundException("Element with id: " + id + " not found");

        int lenght = items.length - 1;
        TicketsSearchInfo[] tmp = new TicketsSearchInfo[lenght];
        int index = 0;

        for (TicketsSearchInfo item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
