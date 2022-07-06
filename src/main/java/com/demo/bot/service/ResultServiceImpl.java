package com.demo.bot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.demo.bot.dto.ResultDTO;


@Service
public class ResultServiceImpl implements ResultService {

	@Override
	public boolean validateResult(ResultDTO question) throws Exception {
		int sum = 0;
		final List<Integer> list = question.getQuestion();
		for (final int val : list) {
			sum += val;
		}
		if (sum != question.getAnswer()) {
			return false;
		}
		return true;

	}

	@Override
	public List<Integer> getNumbers() throws Exception {
		final int listSize = ThreadLocalRandom.current().nextInt(2, 5);
		final List<Integer> list = new ArrayList<>();
		for (int i = 0; i < listSize; i++) {
			final int randInt = ThreadLocalRandom.current().nextInt(0, 100);
			list.add(randInt);
		}
		return list;
	}

}
