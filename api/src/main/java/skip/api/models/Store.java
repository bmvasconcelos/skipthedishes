package skip.api.models;

public class Store {
	
	private Integer id;
	private String name;
	private String address;
	private Integer cousineId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getCousineId() {
		return cousineId;
	}
	public void setCousineId(Integer cousineId) {
		this.cousineId = cousineId;
	}

}
