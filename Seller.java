package design_patterns;

public class Seller extends Person {

	@Override
	public ProductMenu CreateProductMenu(int nProductCategory) {
		System.out.println("Creating menu for seller using Factory Design Pattern");
        if(nProductCategory==0 || nProductCategory==1) {
        	int swtVariable=nProductCategory+1;
    		switch(swtVariable) {
    		case 1:
    			theProductMenu=new MeatProductMenu();
    			break;
    		case 2:
    			theProductMenu=new ProduceProductMenu();
    			break;
    		}
		}
        return theProductMenu;		    
	}

	@Override
	public void ShowMenu() {
		
		System.out.println("Displaying Menu using Bridge Design Pattern");
	}

}
