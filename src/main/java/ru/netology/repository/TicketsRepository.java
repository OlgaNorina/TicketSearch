package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.TicketsSearchInfo;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketsRepository {
    TicketsSearchInfo[] items = new TicketsSearchInfo[0];

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

    public void removeById(int id) {
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
