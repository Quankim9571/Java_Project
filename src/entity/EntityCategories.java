package entity;

public class EntityCategories {
	private int CategoryID;
	private String CategoryName;
	
	public EntityCategories() {
		super();
	}
	
	public EntityCategories(int categoryID, String categoryName) {
		super();
		CategoryID = categoryID;
		CategoryName = categoryName;
	}

	public int getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	
}
