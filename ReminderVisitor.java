package design_patterns;

import java.util.Date;

public class ReminderVisitor extends NodeVisitor {

	@Override
	public void visitFacade(PTBSFacade facade) {
		ProductIterator prdtr=new ProductIterator(facade.theProductList);
		if(facade.theProductList!=null&& (!facade.theProductList.isEmpty())) {
			System.out.println("Visting each product in the Product list");
			while(prdtr.hasNext()) 
				System.out.print(prdtr.Next() +"is visited ");
		}
		else {
			System.out.print("Product List is empty");
		}
	}

	public void visitTrading(Trading trading) {
		Date currentDate=new Date();
		if(trading.DueDate.after(currentDate)) {
			System.out.print("Trading is due");
		}

	}

	@Override
	public void visitProduct(Product product) {
		Trading trading=new Trading();
		if(trading.tradingList!=null&& (!trading.tradingList.isEmpty())) {
			System.out.println("Visting each Trading for the given Product");			
		}
		else {
			System.out.print("No Trading for the given Product  is empty");
		}
	}

}
