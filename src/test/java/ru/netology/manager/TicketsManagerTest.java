package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketsRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketsManagerTest {
    TicketsRepository repository = new TicketsRepository();
    TicketsManager manager = new TicketsManager(repository);
    private Ticket first = new Ticket(1, 5000, "DME", "CDG", 240);
    private Ticket second = new Ticket(2, 7500, "DME", "CDG", 230);
    private Ticket third = new Ticket(3, 6500, "LED", "CDG", 230);
    private Ticket fourth = new Ticket(3, 4500, "DME", "CDG", 500);

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    void shouldSearchExist() {
        assertArrayEquals(new Ticket[]{second, first, fourth}, manager.search("DME", "CDG"));
        assertArrayEquals(new Ticket[]{third}, manager.search("LED", "CDG"));
    }

    @Test
    void shouldSearchNotExist() {
        assertArrayEquals(new Ticket[]{}, manager.search("SVO", "CDG"));
        assertArrayEquals(new Ticket[]{}, manager.search("SVO", "NYC"));
    }
}