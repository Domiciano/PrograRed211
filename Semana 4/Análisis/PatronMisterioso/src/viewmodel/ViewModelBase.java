package viewmodel;

import binding.INotificationViewModel;

public class ViewModelBase {
	
	private INotificationViewModel listener;
	
	public void notifyUpdateUI() {
		listener.OnUpdateUI();
	}
	
	public void setListener(INotificationViewModel listener) {
		this.listener = listener;
	}
	
	
	
}
