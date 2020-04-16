package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketsSearchInfo;
import ru.netology.repository.TicketsRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketsManagerTest {
    TicketsRepository repository = new TicketsRepository();
    TicketsManager manager = new TicketsManager(repository);
    private TicketsSearchInfo first = new TicketsSearchInfo(1, 5000, "DME", "CDG", 240);
    private TicketsSearchInfo second = new TicketsSearchInfo(2, 7500, "DME", "CDG", 230);
    private TicketsSearchInfo third = new TicketsSearchInfo(3, 6500, "LED", "CDG", 230);
    private TicketsSearchInfo fourth = new TicketsSearchInfo(3, 4500, "DME", "CDG", 500);

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    void shouldSearchExist() {
        assertArrayEquals(new TicketsSearchInfo[]{fourth, first, second}, manager.search("DME", "CDG"));
        assertArrayEquals(new TicketsSearchInfo[]{third}, manager.search("LED", "CDG"));
    }

    @Test
    void shouldSearchNotExist() {
        assertArrayEquals(new TicketsSearchInfo[]{}, manager.search("SVO", "CDG"));
        assertArrayEquals(new TicketsSearchInfo[]{}, manager.search("SVO", "NYC"));

    }
}