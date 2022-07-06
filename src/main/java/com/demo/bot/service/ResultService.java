package com.demo.bot.service;

import java.util.List;

import com.demo.bot.dto.ResultDTO;


public interface ResultService {

	public boolean validateResult(ResultDTO question) throws Exception;

	public List<Integer> getNumbers() throws Exception;

}
