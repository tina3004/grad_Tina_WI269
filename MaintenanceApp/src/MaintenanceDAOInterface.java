import java.util.List;

public interface MaintenanceDAOInterface {
    void saveMaintenance(Maintenance maintenance);

    Maintenance getMaintenance(int siteno);

    List<Maintenance> getUnpaidMaintenance();

    void markAsPaid(int siteno);
}
