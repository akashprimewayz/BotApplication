package com.demo.bot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bot.dto.ResultDTO;
import com.demo.bot.service.ResultService;


@RestController
@RequestMapping("/api/v1")
public class ResultController {

	@Autowired
	private ResultService resultService;

	@PostMapping("/validate")
	public ResponseEntity<Boolean> validate(@Valid @RequestBody ResultDTO question) {
		try {

			if (resultService.validateResult(question)) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		} catch (final Exception e) {
			// Adding Print StackTrace as we are not using logger.
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/question")
	public ResponseEntity<List<Integer>> getNumbers() {
		try {

			return new ResponseEntity<>(resultService.getNumbers(), HttpStatus.OK);

		} catch (final Exception e) {
			// Adding Print StackTrace as we are not using logger.
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
