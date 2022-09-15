package design_patterns;

public abstract class Person {
	public ProductMenu theProductMenu;
    public void showAddButton() {}
    public abstract ProductMenu CreateProductMenu(int nProductCategory);
    public void ShowViewButton() {}    
    public abstract void ShowMenu();
    public void showLabels() {}
    public void ShowRadioButton() {}
    
    
}
