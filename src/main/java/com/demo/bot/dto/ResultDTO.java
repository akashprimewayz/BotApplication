package com.demo.bot.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ResultDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@NotEmpty
    @Size(min=2)
	List<Integer> question = new ArrayList<>();
	@NotNull
	Integer answer;

	public List<Integer> getQuestion() {
		return question;
	}

	public void setQuestion(List<Integer> question) {
		this.question = question;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

}
