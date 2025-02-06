package entities;

import java.io.Serializable;

public class ExpenseTag implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer expenseId;
	private Integer tagId;
	
	public ExpenseTag() {
		
	}

	public ExpenseTag(Integer expenseId, Integer tagId) {
		super();
		this.expenseId = expenseId;
		this.tagId = tagId;
	}

	public Integer getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	
	
	
	
	

}
