package com.ust.pnp.arsenal.manager;

import java.util.Base64;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.pnp.arsenal.exception.LooksServiceException;
import com.ust.pnp.arsenal.model.SharedPersonalLook;
import com.ust.pnp.arsenal.repo.secondary.SharedPersonalLooksRepository;

@Service
public class PersonalLooksManager {

	@Autowired
	private SharedPersonalLooksRepository sharedPersonalLooksRepo;

	/**
	 * Method to fetch generated profile from shared DB
	 * 
	 * @param pid
	 * @return {@link base64 string}
	 * @throws LooksServiceException
	 */
	public String getAppliedLook(String pid) throws LooksServiceException {
		if (StringUtils.isBlank(pid)) {
			throw new LooksServiceException("pid is null or empty :");
		}
		SharedPersonalLook look = sharedPersonalLooksRepo.findByPid(pid);
		if (look == null) {
			throw new LooksServiceException("No Personal look found in shared DB : " + pid);
		}
		return Base64.getEncoder().encodeToString(look.getPmakeupoutimg().getData());
	}

}
