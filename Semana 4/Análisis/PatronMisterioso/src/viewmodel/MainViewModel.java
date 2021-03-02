package viewmodel;

import binding.INotificationModel;
import model.Person;
import model.PersonList;

public class MainViewModel extends ViewModelBase implements INotificationModel {

	//Qué es lo que va a representar la vista
	private PersonList personList;

	public MainViewModel() {
		personList = new PersonList();
		personList.setListener(this);
	}

	@Override
	public void onDataChaged() {
		notifyUpdateUI();
	}

	public void addPersonToList(String id, String name) {
		personList.addPerson(new Person(id, name));
	}

	public PersonList getData() {
		return personList;
	}

	public void runAutoAdd() {
		new Thread(
				() -> {
					while(true) {
						personList.addPerson(new Person("A","Alfabetagamma"));
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		).start();
	}

}
