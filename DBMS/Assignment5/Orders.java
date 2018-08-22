import java.util.Date;

/**
 * This class maintain some properties of orders
 * @author Rachna Jadam
 *
 */
public class Orders {
    private int id;
    private Date orderPlacingDate;
    private float totalPrice;
	
    public Orders(int id, Date orderPlacingDate, float totalPrice){
        this.setId(id);
        this.setOrderPlacingDate(orderPlacingDate);
        this.setTotalPrice(totalPrice);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderPlacingDate() {
		return orderPlacingDate;
	}

	public void setOrderPlacingDate(Date orderPlacingDate) {
		this.orderPlacingDate = orderPlacingDate;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}
