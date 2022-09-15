/**
 * 
 */
package design_patterns;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class PTBSFacade {
	
	int UserType;
	static Person thePerson;
	ClassProductList theProductList;
	static int nProductCategory;
	UserInformation usrInfo=null;
	
	public PTBSFacade() {
		System.out.println("Using Facade Design Pattern");       		
	}
	public boolean authenticateUser() {
		
		System.out.print("Authenticating User");
		String filePath="";
		boolean isValidUser=false;
		Scanner scnr= new Scanner(System.in);		
		if(usrInfo.getUserType()!=-1)
		{
			filePath= usrInfo.getUserType()==0?"../design_patterns/src/design_patterns/BuyerInfo":"../design_patterns/src/design_patterns/SellerInfo";			
		}
		  try {
		      File FileObject = new File(filePath);
		      Scanner FileReader = new Scanner(FileObject);  
		      while (FileReader.hasNextLine()) {
		        String dataFromFile = FileReader.nextLine();		        	
		        String[] Credentials=dataFromFile.split(":");
		        if(usrInfo.getUserName().equals(Credentials[0]) && usrInfo.getPassword().equals(Credentials[1]))
		    	{
		    		isValidUser=true;
		    		return isValidUser;	    		
		    	}
		      }
		      FileReader.close();
		    } catch (FileNotFoundException e) {	
		    	System.out.print("Invalid File");
		      e.printStackTrace();
		    } 		  
	  
	    return isValidUser;		
	}
	public boolean login() throws FileNotFoundException {		
		Scanner scnr= new Scanner(System.in);
		System.out.println("Login as \n1.Buyer\n2.Seller");    
	    System.out.println("Enter UserType");	
		UserType=scnr.nextInt()-1;				
		System.out.println("Enter username to login");	
		String usNm=scnr.next();		
		System.out.println("Enter Password to login");
		String pwrd=scnr.next();
		usrInfo =new UserInformation(UserType,usNm,pwrd);
				
		boolean isValidUser=authenticateUser();
		if(isValidUser) {			
			 createUser(usrInfo);
			 createProductList();
			 return isValidUser;
		}	
		return isValidUser;	
	}
	public void addTrading() {
		
	}
	public void viewTrading() {
		
	}
	public void decideBidding(){
		
	}
	public void discussBidding(){
		
	}
	public void submitBidding(){
		
	}
	public static void remind(){
		
	}
	public void createUser(UserInformation usrInfo){
		
		int swtVariable=usrInfo.getUserType()+1;
        if(swtVariable==1 || swtVariable==2) {        	
    		switch(swtVariable) {
    		case 1:
    			System.out.println("Creating new Buyer Instance\n");
    			thePerson = new Buyer();   			
    			break;
    		case 2:
    			System.out.println("Creating new Seller instance\n");
    			thePerson = new Seller();
    			break;
    		}
		}
	}
	public void createProductList() throws FileNotFoundException{
		String username=usrInfo.getUserName();
		String FilePath="../design_patterns/src/design_patterns/UserProduct";
		File FileObject = new File(FilePath);	
	    Scanner FileReader = new Scanner(FileObject);
	    theProductList =new ClassProductList();
	    
	    while (FileReader.hasNextLine()) {
	        String dataFromFile = FileReader.nextLine();		        	
	        String[] Credentials=dataFromFile.split(":");
	        if(username.equals(Credentials[0]))
	    	{    		
	    		theProductList.add(Credentials[1]);
	    	}
	      }       
	    FileReader.close();
	}
	public void attachProductListToUser(){
		
	}
	public void selectProduct(){
		Scanner scnr= new Scanner(System.in);
		System.out.println("Displaying Items using Iterator Design Pattern\nPlease select the product");
	    ProductIterator c= new ProductIterator(theProductList);
	    int index=0;
	    while(true)
	    {	if(c.hasNext())   {
	    	System.out.println((index++)+"."+c.Next());
	    }
	    else break;	    	
	    }	
	    int selectedProductNumber=scnr.nextInt();							
		System.out.println( theProductList.get(selectedProductNumber)+"is selected");	
		System.out.println("Select the product Category");
		System.out.print("1.Meat\n2.Produce");
		scnr.nextLine();
		nProductCategory=scnr.nextInt()-1;
		
	}
	public  void productOperation(){
		System.out.println("Select the operation from the below menu: ");
        System.out.println("1.Create product menu");
        System.out.println("2.Display Products Menu");
        System.out.println("3.Display Reminders");
        System.out.println("4.Exit");
        System.out.println("Enter element");
        
        Scanner sc = new Scanner(System.in);
        int selectedOperation=sc.nextInt();
        
        switch (selectedOperation) {       
            case 1:
                thePerson.CreateProductMenu(nProductCategory);
                break;
            case 2:
                thePerson.ShowMenu();
                break;
            case 3:
                remind();
                break;
            case 4:
            	System.out.println("Logged Out Successfully!!!!!!");
            	break;
        }
        
	}
	

}
