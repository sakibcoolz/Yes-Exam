package in.yis.mains.model;

public class Privileges {

	private Long id;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Privileges(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Privileges() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Privileges [id=" + id + ", name=" + name + "]";
	}
}
