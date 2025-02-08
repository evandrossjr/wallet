package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Tag implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name_tag;
	
	public Tag () {
		
	}

	public Tag(Integer id, String name_tag) {
		super();
		this.id = id;
		this.name_tag = name_tag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName_tag() {
		return name_tag;
	}

	public void setName_tag(String name_tag) {
		this.name_tag = name_tag;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name_tag);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		return Objects.equals(id, other.id) && Objects.equals(name_tag, other.name_tag);
	}

	@Override
	public String toString() {
		return "tag [id=" + id + ", name_tag=" + name_tag + "]";
	}

	
	
	
	
	
	

}
