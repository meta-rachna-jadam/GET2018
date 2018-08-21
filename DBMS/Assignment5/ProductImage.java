
public class ProductImage {

    private int productID;
    private String pathOfImage;
    private String alternativeName;
    public ProductImage(){
    	
    }
    
    public ProductImage(int productID, String pathOfImage, String alternativeName){
        this.setProductID(productID);
        this.setAlternativeName(alternativeName);
        this.setPathOfImage(pathOfImage);
    }

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getPathOfImage() {
		return pathOfImage;
	}

	public void setPathOfImage(String pathOfImage) {
		this.pathOfImage = pathOfImage;
	}

	public String getAlternativeName() {
		return alternativeName;
	}

	public void setAlternativeName(String alternativeName) {
		this.alternativeName = alternativeName;
	}
    
}
