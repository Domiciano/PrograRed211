package model;

import java.util.ArrayList;

public class PersonList extends ModelBase{
	
	private ArrayList<Person> persons;
	
	public PersonList() {
		persons = new ArrayList<>();
	}
	
	public void addPerson(Person p) {
		persons.add(p);
		notifyDatasetChanged();
	}
	
	public ArrayList<Person> getPersons() {
		return persons;
	}
	
}
