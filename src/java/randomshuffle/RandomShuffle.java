package randomshuffle;

import entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomShuffle {

    public static List<Person> shuffleSantasToPersons(List<Person> persons){
        List<Integer> personsIndexes = getIndexes(persons.size());
        Random random = new Random();
        for (int i = 0; i < persons.size(); i++) {
            int randomIndex = personsIndexes.get(random.nextInt(persons.size()-i));
            persons.get(i).getNeedForGift().add(persons.get(randomIndex));
        }
        return persons;//TODO need to test
    }

    private static List<Integer> getIndexes(int size) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            resultList.add(i);
        }
        return resultList;
    }
}
