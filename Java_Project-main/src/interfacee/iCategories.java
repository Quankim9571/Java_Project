package interfacee;

import java.sql.Date;

public interface iCategories {
	void addCategory(String CategoryName);
    void updateCategory(int CategoryID, String CategoryName);
    void deleteCategory(int CategoryID);
    void showCategory();
}
