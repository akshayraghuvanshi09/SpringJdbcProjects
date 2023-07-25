package com.jdbc_hurix.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jdbc_hurix.constant.Messages;
import com.jdbc_hurix.dao.StepDao;
import com.jdbc_hurix.dto.StepRequestDto;
import com.jdbc_hurix.response.CommonResponse;
import com.jdbc_hurix.service.StepService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StepServiceImpl<T> implements StepService<T> {
	@Autowired
	private StepDao stepDao;

	@Override
	public T saveStep(StepRequestDto requestDto) {
		try {
			Integer kitabooId = stepDao.checkDuplicateForKitabooId(requestDto.getKitabooId());
			Integer refId = stepDao.checkDuplicateForRefId(requestDto.getRefId());
			if (kitabooId != 0) {
				return (T) new CommonResponse(Messages.DUPLICATE_KITABOO_ID, HttpStatus.OK.value());
			} else if (refId != 0) {
				return (T) new CommonResponse(Messages.DUPLICATE_REF_ID, HttpStatus.OK.value());
			} else {
				log.info("saveStep() calling {}");
				stepDao.saveStep(requestDto);
				return (T) new CommonResponse(Messages.SUCCESS, HttpStatus.OK.value());
			}
		} catch (Exception e) {
			log.error("saveStep() mehtod calling {}", e);
			return (T) new CommonResponse(Messages.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

	}

	@Override
	public T getStepById(Long id) {
		try {
			List<StepRequestDto> byIdStep = stepDao.getByIdStep(id);
			if (!byIdStep.isEmpty()) {
				return (T) byIdStep.get(0);
			} else {
				return (T) new CommonResponse(Messages.VALID_ID, HttpStatus.BAD_REQUEST.value());
			}
		} catch (Exception e) {
			log.error("getStepById() mehtod calling {}", e);
			return (T) new CommonResponse(Messages.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

	}
}
