package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyMemberTest {
    Adult bob;
    Kid tom;

    @BeforeEach
    public void setUp() {
        bob = new Adult("Bob");
        tom = new Kid("Tom");
        bob.addMember(tom);
    }

    @Test
    public void testConstructor() {
        assertEquals("Bob", bob.getName());
    }

    @Test
    public void testAddMember() {
        assertEquals(1,bob.getFamilyMembers().size());
    }

    @Test
    public void testUpdateAdult() {
        assertEquals("",bob.update("food",100));
    }

    @Test
    public void testKidNotExceed() {
        assertEquals("100 dollars has been spent on food",tom.update("food",100));
    }

    @Test
    public void testKidExceedLimit() {
        assertEquals("Exceed the kid's spending limit!",tom.update("videoGame",1000));
    }
}
