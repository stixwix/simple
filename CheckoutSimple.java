package checkout.simple;


import java.util.ArrayList;
import java.util.List;

public class CheckoutSimple {
	
	// Note - I would normally choose JUnit for tests but due to time constraint will run basic tests from Main method
	// Also would use Log4j for logging
	public static void main(String[] args) {
		
		CustomerOrder customerOrder = CheckoutSimple.loadCustomerOrder();
		long total = customerOrder.printReceipt();

		if (total != 400){
			System.out.println("Test1 failed");
		}
	}
	
	
	// simulate loading the order from DB
	private static CustomerOrder loadCustomerOrder(){
			
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.addItem(new GroceryItem("apple", 60,5));
		customerOrder.addItem(new GroceryItem("orange", 25,4));
		return customerOrder;
	}

	// represents items selected for purchase by user 
	private static class GroceryItem{
			
		private String name;
		private int price;
		private int qty;
	
		public GroceryItem(String name, int price, int qty) {
			super();
			this.name = name;
			this.price = price;
			this.qty = qty;
		}
	
	}
	
	
	// holds a list of items selected for purchase by the user
	private static class CustomerOrder{
		
		private List<GroceryItem> orderItems = new ArrayList<GroceryItem>();
		
		private void addItem (GroceryItem item){
			orderItems.add(item);
		}
		
		private long calculateTotal(){
			long total = 0;
			for (GroceryItem item : orderItems){
				total += (item.price * item.qty);
			}
			return total;
		}
		
		private long printReceipt(){
			System.out.println("item name" + "\t" + "item price"+ "\t" +"item qty");
			for (GroceryItem item : orderItems){
				System.out.println(item.name + "\t\t" + item.price + "\t\t"+item.qty);
			}
			System.out.println("-----------------------------------------");
			long total = calculateTotal();
			System.out.println("total\t\t\t\t" + total);
			return total;
		}
		
	}
	
	

}



