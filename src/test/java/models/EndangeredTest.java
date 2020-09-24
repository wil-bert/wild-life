package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiateCorrectly_true() {
        Endangered testAnimal = setUpEndangered();
        assertTrue(testAnimal instanceof Endangered);
    }

    @Test
    public void animal_instantiateWithName_String() {
        Endangered testAnimal = setUpEndangered();
        assertEquals("lion", testAnimal.getName());
    }

    @Test
    public void animal_instantiateWithCorrectType_String() {
        Endangered testAnimal = setUpEndangered();
        assertEquals("endangered", testAnimal.getType());
    }

    @Test
    public void equals_returnTrueWhenObjectsHaveSameValues_true() {
        Endangered testAnimal = setUpEndangered();
        Endangered testAnimal2 = setUpEndangered();
        assertTrue(testAnimal.equals(testAnimal2));
    }

//    @Test
//    public void save_addAnimalToDatabase_void() {
//        Endangered testAnimal = setUpEndangered();
//        testAnimal.save();
//        assertTrue(Endangered.all().get(0).equals(testAnimal));
//    }

//    @Test
//    public void all_returnAllAnimals_List() {
//        Endangered testAnimal = setUpEndangered();
//        testAnimal.save();
//        Endangered testAnimal2 = setUpEndangered();
//        testAnimal2.save();
//        assertEquals(2, Endangered.all().size());
//    }

//    @Test
//    public void saveAge_addsAgeOfEndangeredAnimalToDB_void() {
//        Endangered testAnimal = setUpEndangered();
//        testAnimal.save();
//        testAnimal.saveAge("newborn");
//        assertEquals("newborn", Endangered.all().get(0).getAge());
//    }
//
//    @Test
//    public void saveHealth_addsHealthOfEndangeredAnimalToDB_void() {
//        Endangered testAnimal = setUpEndangered();
//        testAnimal.save();
//        testAnimal.saveHealth("okay");
//        assertEquals("okay", Endangered.all().get(0).getHealth());
//    }

    @Test
    public void animal_instantiateWithCorrectId_int() {

    }

    //helper class
    public Endangered setUpEndangered() {
        return new Endangered("lion");
    }

}