package entities;

import java.io.Serializable;
import java.util.Objects;

public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id_category;
	private String name_category;
	
	
	public Category() {
		
	}


	public Category(Integer id_category, String name_category) {
		super();
		this.id_category = id_category;
		this.name_category = name_category;
	}


	public Integer getId_category() {
		return id_category;
	}


	public void setId_category(Integer id_category) {
		this.id_category = id_category;
	}


	public String getName_category() {
		return name_category;
	}


	public void setName_category(String name_category) {
		this.name_category = name_category;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id_category, name_category);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id_category, other.id_category) && Objects.equals(name_category, other.name_category);
	}


	@Override
	public String toString() {
		return "category [id_category=" + id_category + ", name_category=" + name_category + "]";
	}

	
	
}
