package studentactivityguide.threading;

public class PurchasingAgent {

	public PurchasingAgent(){
	
	}
	public void purchase(){
		
		Store shirtStore = Store.getInstance();
		
		synchronized(shirtStore) {
		if(shirtStore.getShirtCount() > 0 && shirtStore.authorizeCreditCard("1234", 15.00)){
			Shirt shirt = shirtStore.takeShirt();
			
				System.out.println("The shirt is ours!");
				System.out.println(shirt);
				
			
			}
		else{
			System.out.println("No shirt for you");
		}
		}
	}
}
