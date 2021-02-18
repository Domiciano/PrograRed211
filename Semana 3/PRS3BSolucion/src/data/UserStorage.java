package data;

import java.util.ArrayList;
import java.util.HashMap;

import events.OnDataChanged;
import events.OnUserAddedListener;
import events.OnUserDeletedListener;

public class UserStorage implements OnUserAddedListener, OnUserDeletedListener{
	
	private HashMap<String, User> users;
	private OnDataChanged onDataChanged;
	
	public UserStorage() {
		users = new HashMap<>();
	}
	
	public void setOnDataChanged(OnDataChanged onDataChanged) {
		this.onDataChanged = onDataChanged;
	}
	

	@Override
	public void onUserAdded(String id, String name) {
		System.out.println("Added");
		users.put(id, new User(id, name));
		onDataChanged.onData(this.users);
	}

	@Override
	public void onUserDeleted(String id) {
		System.out.println("Delete");
		users.remove(id);
		onDataChanged.onData(this.users);
	}
	
	
}
