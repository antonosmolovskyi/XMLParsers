package mavenClasses;

import java.util.List;

public class Root {
	private String name;
	private List<People> people;

	public void setPeople(List<People> people) {
		this.people = people;
	}
	

	public void setName(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public List<People> getPeople() {
		return people;
	}

	@Override
	public String toString() {
		return "Root [name=" + name + ", people=" + people + "]";
	}

}
