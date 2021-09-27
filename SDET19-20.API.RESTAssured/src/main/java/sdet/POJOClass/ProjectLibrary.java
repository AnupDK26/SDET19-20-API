package sdet.POJOClass;

public class ProjectLibrary {
	
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	//initialize ALL the necessary attributes with the current value 
	public ProjectLibrary(String createdBy, String projectName, String status, int teamSize) {
		
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}
	
	//provide getters and setter to access the attributes
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	
	
	
	
	

}
