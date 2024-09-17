package interfacee;

public interface iSuppliers {
    void addSupplier(String SupplierName, String ContactInfo, String Address);
    void updateSupplier(int SupplierID, String SupplierName, String ContactInfo, String Address);
    void deleteSupplier(int SupplierID);
    void showSupplier();
}
