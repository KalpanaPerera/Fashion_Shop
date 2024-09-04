import java.util.*;
class Demo{
    public static Scanner input = new Scanner(System.in);

    public static String[] orderIds = new String[0];
    public static String[] customerIds = new String[0];
    public static String[] tSizes = new String[]{"XS","S","M","L","XL","XXL"};
    public static double[] prices = new double[]{600.00,800.00,900.00,1000.00,1100.00,1200.00};
    public static int[] quantity = new int[0];
    public static final int PROCESSING = 0;
    public static final int DELIVERING = 1;
    public static final int DELIVERED = 2;

    public static int getIndex(String user){
        for (int i = 0; i < tSizes.length; i++){
            if (user.equals(tSizes[i])){
                return i;
            }
        }
        return -1;
    }

    public static String generateId(){
        if (orderIds.length>0){
            int id = Integer.parseInt(orderIds[orderIds.length-1].split("[R]")[1]);
            id++;

            return String.format("ODR#%05d",id);
        }
        return "ODR#00001";
    }

    public static void displayUserId(){
        System.out.println("\n+--------------------------------------------------+");
        System.out.printf("|%50s|%n","Display Details               ");
        System.out.println("+--------------------------------------------------+");

        L1:do{
            System.out.print("\nEnter username : ");
            String user = input.next();

            if (!isValidOrderID(user)){
                System.out.print("Enter Password : ");
                String pswd = input.next();

                if (pswd.equals(tSizes[getIndex(user)])){
                    System.out.println("\n\t\tUser ID : "+tSizes[getIndex(user)]);

                    do{
                        System.out.print("Do you want to search another user ID? (y/n) : ");
                        String yn = input.next().toLowerCase();

                        if (yn.equals("y")){
                            continue L1;
                        }else if (yn.equals("n")){
                            home();
                        }
                        System.out.println("\n\t\tInvalid...");
                    } while (true);
                }else{
                    System.out.println("\n\t\tInvalid Password.. Try again..");
                }
            }else{
                System.out.println("\n\t\tInvalid Username..");

                do{
                    System.out.print("Do you want to try again? (y/n) : ");
                    String yn = input.next().toLowerCase();

                    if (yn.equals("y")){
                        continue L1;
                    }else if (yn.equals("n")){
                        home();
                    }
                    System.out.println("\n\t\tInvalid...");
                } while (true);
            }
        } while (true);

    }


    public static boolean isValidOrderID(String id){
        for (int i = 0; i < tSizes.length; i++){
            if (id.equals(tSizes[i])){
                return false;
            }
        }
        return true;
    }

    public static String[] extendArray(String[] br){
        String[] temp = new String[br.length+1];
        for (int i = 0; i < br.length; i++){
            temp[i] = br[i];
        }
        return temp;
    }

    public static void home(){

        System.out.println("+--------------------------------------------------+");
        System.out.printf("|%50s|%n","Fashion Shop               ");
        System.out.println("+--------------------------------------------------+");
        System.out.print("\n\t[1] Place Order");
        System.out.println("\t\t\t\t\t\t[2] Search Customer");
        System.out.print("\t[3] Search Order");
        System.out.println("\t\t\t\t\t[4] View Reports");
        System.out.print("\t[5] Change Order Status");
        System.out.println("\t\t\t\t[6] Delete Order");

        do{
            System.out.print("\nInput Option : ");
            int option = input.nextInt();

            switch (option){
                case 1:placeOrder();break;
                case 2:searchCustomer();break;
                case 3:searchOrder();break;
                case 4:viewReports();break;
                case 5:changeOrderStatus();break;
                case 6:deleteOrder();break;
                default: System.out.println("\n\t\tInvalid..");
            }
        } while (true);
    }

    private static void placeOrder() {
        System.out.println("\n+--------------------------------------------------+");
        System.out.printf("|%50s|%n","Place Order               ");
        System.out.println("+--------------------------------------------------+");

        L1:do{
            System.out.print("\nEnter Order ID : ");
            String oid = input.next();

            if (!isValidOrderID(oid)){
                System.out.print("Enter Customer Phone Number : ");
                String cpno = input.next();

                if (cpno.equals(tSizes[getIndex(oid)])){
                    System.out.println("\n\t\tUser ID : "+tSizes[getIndex(oid)]);

                    do{
                        System.out.print("Do you want to search another user ID? (y/n) : ");
                        String yn = input.next().toLowerCase();

                        if (yn.equals("y")){
                            continue L1;
                        }else if (yn.equals("n")){
                            home();
                        }
                        System.out.println("\n\t\tInvalid...");
                    } while (true);
                }else{
                    System.out.println("\n\t\tInvalid Password.. Try again..");
                }
            }else{
                System.out.println("\n\t\tInvalid Username..");

                do{
                    System.out.print("Do you want to try again? (y/n) : ");
                    String yn = input.next().toLowerCase();

                    if (yn.equals("y")){
                        continue L1;
                    }else if (yn.equals("n")){
                        home();
                    }
                    System.out.println("\n\t\tInvalid...");
                } while (true);
            }
        } while (true);

    }
    private static void searchCustomer() {
    }
    private static void searchOrder() {
    }
    private static void viewReports() {
    }
    private static void changeOrderStatus() {
    }
    private static void deleteOrder() {
    }

    public static void main(String[] args){
        home();
    }
}

