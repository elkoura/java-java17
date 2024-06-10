package java17.ex03;

import java.util.function.BinaryOperator;

import org.junit.Test;

import java17.data.Person;

/**
 * Exercice 03 - java.util.function.BinaryOperator
 */
public class Function_03_Test {

    //  tag::makeAChild[]
    // Compléter la fonction makeAChild
    BinaryOperator<Person> makeAChild = (father, mother) -> new Person(
        father.getFirstname() + " " + mother.getFirstname(),  // Prénom de l'enfant
        father.getLastname(),  // Nom de famille de l'enfant
        0,  // Âge de l'enfant
        null  // Mot de passe de l'enfant
    );
    //  end::makeAChild[]


    @Test
    public void test_makeAChild() throws Exception {

        Person father = new Person("John", "France", 25, "johndoe");
        Person mother = new Person("Aline", "Lebreton", 22, "alino");

        // TODO compléter le test pour qu'il soit passant
        Person child = makeAChild.apply(father, mother);//apply

        assert child.getFirstname().equals("John Aline");
        assert child.getLastname().equals("France");
        assert child.getAge().equals(0);
        assert child.getPassword() == null;
    }

}
