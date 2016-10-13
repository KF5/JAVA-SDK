package com.kf5.support.model;

public class AICategory {

	private int category_id;
	
	private String answer;
	
	private String other_titles;
	
	public String getOther_titles() {
		return other_titles;
	}

	public void setOther_titles(String other_titles) {
		this.other_titles = other_titles;
	}

	private boolean active;
	
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public AIQuestionCategory getAiQuestionCategory() {
		return aiQuestionCategory;
	}

	public void setAiQuestionCategory(AIQuestionCategory aiQuestionCategory) {
		this.aiQuestionCategory = aiQuestionCategory;
	}

	private String created_at;
	
	private int id;
	
	private String title;
	
	private AIQuestionCategory  aiQuestionCategory;
	
}
