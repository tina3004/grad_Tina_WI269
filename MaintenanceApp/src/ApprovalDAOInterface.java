import java.util.List;

public interface ApprovalDAOInterface {
    void createRequest(int siteno, int userId);

    List<Approval> getPendingRequests();

    void updateStatus(int approvalId, String status);
}
