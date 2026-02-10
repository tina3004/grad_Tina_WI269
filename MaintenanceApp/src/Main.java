import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    static UserDAOInterface userDAO = new UserDAO();
    static SiteDAOInterface siteDAO = new SiteDAO();
    static MaintenanceDAOInterface maintenanceDAO = new MaintenanceDAO();
    static ApprovalDAOInterface approvalDAO = new ApprovalDAO();
    public static void main(String[] args) {

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User user = userDAO.getUserByName(username);

        if (user == null || !user.getPassword().equals(password)) {
            System.out.println("Invalid username or password");
            return;
        }

        if (!user.getStatus().equalsIgnoreCase("ACTIVE")) {
            System.out.println("User is inactive");
            return;
        }

        if (user.getRole().equalsIgnoreCase("ADMIN")) {
            adminMenu();
        } else {
            ownerMenu(user);
        }
    }

    private static void adminMenu() {

        while (true) {
            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. View all sites");
            System.out.println("2. View unpaid maintenance");
            System.out.println("3. Mark maintenance as paid");
            System.out.println("4. View approval requests");
            System.out.println("5. Approve / Reject request");
            System.out.println("6. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> viewAllSites();
                case 2 -> viewUnpaidMaintenance();
                case 3 -> markMaintenancePaid();
                case 4 -> viewApprovals();
                case 5 -> updateApproval();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void viewAllSites() {
        List<Site> sites = siteDAO.getAllSites();
        for (Site s : sites) {
            System.out.println("Site No: " + s.getSiteno()
                    + ", Type: " + s.getType()
                    + ", Occupied: " + s.isOccupied());
        }
    }

    private static void viewUnpaidMaintenance() {
        List<Maintenance> list = maintenanceDAO.getUnpaidMaintenance();
        for (Maintenance m : list) {
            System.out.println("Site No: " + m.getSiteno()
                    + ", Amount: " + m.getAmount()
                    + ", Paid: " + m.isPaid());
        }
    }

    private static void markMaintenancePaid() {
        System.out.print("Enter site number: ");
        int siteno = sc.nextInt();
        maintenanceDAO.markAsPaid(siteno);
        System.out.println("Maintenance marked as paid");
    }

    private static void viewApprovals() {
        List<Approval> list = approvalDAO.getPendingRequests();
        for (Approval a : list) {
            System.out.println("Approval ID: " + a.getId()
                    + ", Site No: " + a.getSiteno()
                    + ", User ID: " + a.getUserId()
                    + ", Status: " + a.getStatus());
        }
    }

    private static void updateApproval() {
        System.out.print("Enter approval ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Approve or Reject (A/R): ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("A")) {
            approvalDAO.updateStatus(id, "APPROVED");
            System.out.println("Request approved");
        } else if (choice.equalsIgnoreCase("R")) {
            approvalDAO.updateStatus(id, "REJECTED");
            System.out.println("Request rejected");
        } else {
            System.out.println("Invalid option");
        }
    }


    private static void ownerMenu(User user) {

        while (true) {
            System.out.println("\n--- OWNER MENU ---");
            System.out.println("1. View my site");
            System.out.println("2. View my maintenance");
            System.out.println("3. Request site update");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> viewMySite(user);
                case 2 -> viewMyMaintenance(user);
                case 3 -> requestUpdate(user);
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void viewMySite(User user) {
        Site site = siteDAO.getSiteBySiteno(user.getSiteno());
        System.out.println("Site No: " + site.getSiteno()
                + ", Type: " + site.getType()
                + ", Occupied: " + site.isOccupied());
    }

    private static void viewMyMaintenance(User user) {
        Maintenance m = maintenanceDAO.getMaintenance(user.getSiteno());
        System.out.println("Amount: " + m.getAmount()
                + ", Paid: " + m.isPaid());
    }

    private static void requestUpdate(User user) {
        approvalDAO.createRequest(user.getSiteno(), user.getId());
        System.out.println("Update request sent to admin");
    }

    }
