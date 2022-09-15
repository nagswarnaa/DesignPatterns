package design_patterns;

public class MeatProductMenu implements ProductMenu {

	@Override
	public void showAddButton() {
		System.out.println("Displaying the Add Button");
	}

	@Override
	public void showMenu() {
		System.out.println("Displaying the Menu");
	}

	@Override
	public void showViewButton() {
		System.out.println("Displaying the View Button");
	}

	@Override
	public void showComboxes() {
		System.out.println("Displaying the Comboxes");
	}

	@Override
	public void showRadioButton() {
		System.out.println("Displaying the Radio Button");
	}

	@Override
	public void showLabels() {
		System.out.println("Displaying the show Labels");
	}

}
