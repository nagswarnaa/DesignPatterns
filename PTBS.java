package design_patterns;

public class PTBS {

	public static PTBSFacade fac;
    public static void main(String[] args) throws Exception {
        fac = new PTBSFacade();         
        if(fac.login()) {
        	fac.selectProduct();
        	fac.attachProductListToUser();
        	fac.productOperation();
        }
        else {
        	System.out.println("Login failed ");
        	
        }
    }
}
