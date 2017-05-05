/**
 * 
 */
package jsycbc.github.com.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import jsycbc.github.com.batch.bo.Person;

/**
 * @author bianchao
 *
 */
public class MyProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person person) throws Exception {
	System.out.println(person.toString());
	return person;
    }

}
