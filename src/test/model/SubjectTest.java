package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubjectTest {
    private Subject subject;
    ArrayList<Observer> observers;
    Observer bob;

    @BeforeEach
    public void setUp() {
        subject = new Subject();
        observers = subject.getObservers();
        bob = new Adult("Bob");
        }


    @Test
    public void testAddObserver() {
        subject.addObserver(bob);
        assertEquals(1,observers.size());
        subject.addObserver(bob);
        assertEquals(1,observers.size());

    }

}
