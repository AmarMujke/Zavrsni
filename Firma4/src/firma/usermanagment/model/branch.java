package firma.usermanagment.model;

public class branch {
	private int BranchId;
	private String BranchName;
    public branch(int BranchId, String BranchName) {
    	super();
    	this.BranchId = BranchId;
    	this.BranchName = BranchName;
    }
	public int getBranchId() {
		return BranchId;
	}
	public void setBranchId(int branchId) {
		BranchId = branchId;
	}
	public String getBranchName() {
		return BranchName;
	}
	public void setBranchName(String branchName) {
		BranchName = branchName;
	}
}
