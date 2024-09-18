package interfacee;

public interface iProducts {
	void addProducts(String ProductName, int CategoryID, int Size, String Color, Double Price, int StockQuantity);

	void updateProducts(int ProductID, String ProductName, int CategoryID, int Size, String Color, Double Price,
			int StockQuantity);

	void deleteProducts(int ProductID);

	void showProducts();
}
