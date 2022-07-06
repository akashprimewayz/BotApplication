package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.demo.bot.controller.ResultController;
import com.demo.bot.dto.ResultDTO;
import com.demo.bot.service.ResultService;

@ExtendWith(MockitoExtension.class)
public class BotControllerUnitTests {
	@InjectMocks
	ResultController resultController;

	@Mock
	ResultService resultService;

	@Test
	public void testvalidateResult() throws Exception {
		final MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		final ResultDTO resultDTO = new ResultDTO();
		final List<Integer> numList = new ArrayList<>();
		numList.add(1);
		numList.add(2);
		numList.add(3);

		resultDTO.setQuestion(numList);
		resultDTO.setAnswer(6);
		when(resultService.validateResult(any(ResultDTO.class))).thenReturn(true);

		final ResponseEntity<Boolean> responseEntity = resultController.validate(resultDTO);

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	public void testvalidateFaildResult() throws Exception {
		final MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		final ResultDTO resultDTO = new ResultDTO();
		final List<Integer> numList = new ArrayList<>();
		numList.add(1);
		numList.add(2);
		numList.add(3);

		resultDTO.setQuestion(numList);
		resultDTO.setAnswer(4);
		when(resultService.validateResult(any(ResultDTO.class))).thenReturn(false);

		final ResponseEntity<Boolean> responseEntity = resultController.validate(resultDTO);

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(400);
	}

	@Test
	public void getTestNumber() throws Exception {
		final MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		final List<Integer> numList = new ArrayList<>();

		when(resultService.getNumbers()).thenReturn(numList);

		final ResponseEntity<List<Integer>> responseEntity = resultController.getNumbers();

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

}
