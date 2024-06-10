package java17.ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

import java17.data.Data;
import java17.data.Person;

/**
 * Exercice 4 - java.util.function.Predicate
 */
public class Function_04_Test {

    // tag::filterMethod[]
	//une methode denereique qui prend une liste d'element T et un predicte (une fonction qui retourne Booléen) 
    <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();//Crée une nouvelle liste vide nommée result pour stocker les éléments qui satisfont le prédicat.
        for (T el : list) {
            if (predicate.test(el)) {
                result.add(el);
            }
        }
        return result;
    }
    // end::filterMethod[]

    // PART 1 - ADULT

    // tag::adult[]
    // TODO Compléter la fonction
    // TODO AGE >=18
    Predicate<Person> adult = person -> person.getAge() >= 18;
    // end::adult[]

    @Test
    public void test_predicate() throws Exception {

        List<Person> personList = Data.buildPersonList();

        // TODO invoquer la méthode filter pour que le test soit passant
        List<Person> result = filter(personList, adult);

        assert result.size() == 4;

    }

    // PART 2 - ADULT AND LASTNAME=France AND FIRSTNAME=Armor

    // tag::predicateand[]
    // TODO compléter la fonction
    // TODO le prédicat vérifie que le nom est "France"
    Predicate<Person> lastnameIsFrance = person -> "France".equals(person.getFirstname());


    // TODO compléter la fonction
    // TODO le prédicat vérifie que le prénom est "Armor"
    Predicate<Person> firstnameIsArmor = person -> "Armor".equals(person.getLastname());
    // end::predicateand[]

    @Test
    public void test_predicate_and() throws Exception {

        List<Person> personList = Data.buildPersonList();

        // TODO invoquer la méthode filter pour que le test soit passant
        // TODO chaîner les prédicats adult, lastnameIsFrance et firstnameIsArmor avec la méthode and
        List<Person> result = filter(personList, adult.and(lastnameIsFrance).and(firstnameIsArmor));

        assert result.size() == 3;
        assert result.get(0).getFirstname().equals("Armor");
        assert result.get(0).getLastname().equals("France");
        assert result.get(0).getAge().equals(25);

    }
}



