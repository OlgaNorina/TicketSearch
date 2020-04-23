package ru.netology.manager;

import lombok.AllArgsConstructor;
import ru.netology.domain.TicketsSearchInfo;
import ru.netology.repository.TicketsRepository;

import java.util.Arrays;

@AllArgsConstructor
public class TicketsManager {
    TicketsRepository repository;

    public void add(TicketsSearchInfo item) {
        repository.save(item);
    }

    public TicketsSearchInfo[] search(String from, String to) {
        TicketsSearchInfo[] result = new TicketsSearchInfo[0];
        for (TicketsSearchInfo item : repository.findAll()) {
            if (item.getFrom().equalsIgnoreCase(from) && item.getTo().equalsIgnoreCase(to)) {
                TicketsSearchInfo[] tmp = new TicketsSearchInfo[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
