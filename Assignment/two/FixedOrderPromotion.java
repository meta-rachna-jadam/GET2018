import java.util.Date;


public class FixedOrderPromotion implements Promotion{

	private double minimumPrice, discount;

	@Override
	public double getMinimumPrice() {
		return minimumPrice;
	}

	@Override
	public void setMinimumPrice(double minimumPrice) {
		this.minimumPrice = minimumPrice;
		
	}

	@Override
	public double getFixedDiscount() {
		return discount;
	}

	@Override
	public void setFixedDiscount(double discount) {
		this.discount = discount;
		
	}

	/**
	 * this method checks if the promotion can be applied based on the promocode provided on order
	 * @param code contains the promocode as provided on order
	 * @return returns true if promotion can be applied, otherwise false
	 */
	@Override
	public boolean isPromotionApplicable(String code) {
		Date currentDate = new Date();
		boolean result = false;
		
		for(PromotionEnum promotion: PromotionEnum.values())
		{
			if(code.equals(promotion.getCode()))
			{					
				if(currentDate.after(promotion.getStartDate().getTime()) && currentDate.before(promotion.getEndDate().getTime()))
					result = true;
				else
					result = false;
			}
		}
		return result;
	}

}
