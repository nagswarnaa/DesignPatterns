package design_patterns;

public class ProductIterator implements ListIterator {

	private ClassProductList theProductList;
	private int productNumber;
	ProductIterator(ClassProductList theProductList){
		this.theProductList=theProductList;
		productNumber=0;
	}
	@Override
	public boolean hasNext() {
		
		if(productNumber > (theProductList.size()-1))
			return false;
		else
			return true;
	}

	@Override
	public String Next() {		
		return hasNext()? theProductList.get(productNumber++):null;	
	}

	@Override
	public void Remove() {
		
	}

	@Override
	public void MoveToHead() {
		
	}

}
