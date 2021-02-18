package events;

import java.util.HashMap;

import data.User;

public interface OnDataChanged {
	public void onData(HashMap<String, User> data);
}
