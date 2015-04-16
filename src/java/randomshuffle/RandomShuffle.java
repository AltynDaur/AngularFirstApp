package randomshuffle;

import entity.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomShuffle {

    public static List<Person> shuffleSantasToPersons(List<Person> persons){
        List<Person> shuffledPersons = new ArrayList<Person>(persons);
        shuffle(shuffledPersons);
        shuffledPersons = listWithoutCollisions(persons,shuffledPersons);
        for (int i = 0; i < persons.size(); i++) {
            if(!persons.get(i).getNeedForGift().contains(shuffledPersons.get(i))){
                persons.get(i).getNeedForGift().add(shuffledPersons.get(i));
            }

        }
        return persons;
    }

    static void shuffle(List<Person> persons) {
        int n = persons.size();
        for (int i = 0; i < persons.size(); i++) {
            // Get a random index of the array past i.
            int random = i + (int) (Math.random() * (n - i));
            // Swap the random element with the present element.
            Person randomPerson = persons.get(random);
            persons.set(random, persons.get(i));
            persons.set(i,randomPerson);
        }
    }

    private static List<Person> listWithoutCollisions (List<Person> originalPersons, List<Person> persons) {
        List<Person> collisions = new ArrayList<Person>();
        for (int i = 0; i < originalPersons.size(); i++) {
            if(originalPersons.get(i).equals(persons.get(i))){
                collisions.add(originalPersons.get(i));
            }
        }
        if(!collisions.isEmpty()){
            for (int i = 0; i < collisions.size(); i++) {
                int indexOfCollision = persons.indexOf(collisions.get(i));
                persons.remove(indexOfCollision);
                try {
                    persons.add(indexOfCollision+1,collisions.get(i));
                } catch (IndexOutOfBoundsException e) {
                    persons.add(indexOfCollision-1,collisions.get(i));
                }
            }
        }
        return persons;
    }
}
