public class SalesPerson {

// each object contains details of one salesperson

    private String id;

    private Sales[] salesHistory; // details of the different sales

    private int count = 0; // number of sales made


//constructor for a new salesperson

    public SalesPerson(String id) {
        this.id = id;
        salesHistory = new Sales[100];
    }

// constructor for a salesperson transferred (together with their sales details) from another branch

    public SalesPerson(String id, Sales[] salesHistory, int count) {
        this.id = id;
        this.salesHistory = salesHistory;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String getId() {
        return id;
    }

    public void setSalesHistory(Sales s) {
        salesHistory[count] = s;
        count = count + 1;
    }


    public double calcTotalSales() {
        if (salesHistory.length == 0) {
        return 0;
        }
        double totalSales = 0;
        for (Sales sales : salesHistory) {
            if(sales == null){
                break;
            }
            totalSales += sales.getValue() * sales.getQuantity();
        }
        return totalSales;
    }

    public Sales largestSale() {
        if (salesHistory.length == 0) {
            return null;
        }
        Sales largestSale = salesHistory[0];
        double largest = 0;

        for (Sales sales : salesHistory) {
            if (sales == null){
                break;
            }
            if ((sales.getQuantity() * sales.getValue()) > largest) {
                largestSale = sales;
                largest = sales.getQuantity() * sales.getValue();
            }
        }
        return largestSale;
    }

    public Sales getSalesHistory(int i) {
        return salesHistory[i];
    }

}