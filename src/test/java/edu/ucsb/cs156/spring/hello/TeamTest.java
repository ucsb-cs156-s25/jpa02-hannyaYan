package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_different_class() {
        assertFalse(team.equals("a string"));
    }

    @Test
    public void equals_sameNameSameMembers() {
        Team otherTeam = new Team("test-team");
        assertTrue(team.equals(otherTeam));
    }

    @Test
    public void equals_sameNameDiffMembers() {
        Team otherTeam = new Team("test-team");
        otherTeam.addMember("A");
        assertFalse(team.equals(otherTeam));
    }

    @Test
    public void equals_diffNameSameMembers() {
        Team otherTeam = new Team("diff-name");
        assertFalse(team.equals(otherTeam));
    }

    @Test
    public void equals_diffNameDiffMembers() {
        Team otherTeam = new Team("diff-name");
        otherTeam.addMember("A");
        assertFalse(team.equals(otherTeam));
    }

    @Test
    public void hashCode_test() {
        Team t = new Team("t");
        int result = t.hashCode();
        int expectedResult = 117;
        assertEquals(expectedResult, result);
    }
}
