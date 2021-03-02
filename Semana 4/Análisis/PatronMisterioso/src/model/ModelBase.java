package model;

import binding.INotificationModel;

public class ModelBase {
	
	private INotificationModel listener;
	
	public void notifyDatasetChanged() {
		listener.onDataChaged();
	}
	
	public void setListener(INotificationModel listener) {
		this.listener = listener;
	}

}
