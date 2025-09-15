package sep._4th;

class Product
{
	int p_id, quantity;
	String p_name;
        double price;
        	
	void setInfo(int pId, String p_name,  int qty  , double price)
        {
		this.p_id = pId;
		this.quantity = qty;
		this.p_name = p_name;
		this.price = price;
	}
	String getInfo()
	{
		return "Product info : " + p_id + " " + p_name + " " + quantity + " " + price;
		
	}
	
	void display()
	{
		System.out.println("Product Id Is : " + p_id);
		System.out.println("Product name Is : " + p_name);
		System.out.println("Product Quantity Is : " + quantity);
		System.out.println("Product Price Is : " + price);

	}

}

class TestProduct
{
	public static void main(String args[])
	{	Product p1;
		p1 = new Product();
		p1.setInfo(12, "Laptop" , 2, 70000.98);
		p1.display();
	}

}