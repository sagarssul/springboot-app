package com.ust.pnp.arsenal.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ust.pnp.arsenal.exception.LooksServiceException;
import com.ust.pnp.arsenal.model.ApplyLookRequest;
import com.ust.pnp.arsenal.model.ApplyLookVersionResponse;
import com.ust.pnp.arsenal.repo.LooksRepository;
import com.ust.pnp.arsenal.util.OKHttpUtil;

@Service
public class LooksManager {

	@Autowired
	LooksRepository looksRepo;

	@Autowired
	PersonalLooksManager personalLooksManager;

	@Value("${arsenal.makeupar.applyMakeupVersionApi}")
	private String applyMakeupVersionApi;

	/**
	 * This method consumes makeupar/applymakeup API.
	 * 
	 * @param profileId
	 * @param lookId
	 * @return success
	 * @throws IOException
	 * @throws LooksServiceException
	 */
	public List<ApplyLookVersionResponse> applyFaceMakeupVersion(ApplyLookRequest applyModal)
			throws IOException, LooksServiceException {
		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("profileID", applyModal.getProfileId());
		requestBody.put("looksID", applyModal.getLookId());
		requestBody.put("applyID", applyModal.getApplyId());

		Map<String, Object> resultData = OKHttpUtil.connectToClientWithPost(applyMakeupVersionApi, requestBody,
				Map.class, "applyMakeup");

		List<ApplyLookVersionResponse> response = new ArrayList<ApplyLookVersionResponse>();

		if (resultData.containsKey("result")) {
			List<LinkedHashMap<String, String>> lookList = (ArrayList) resultData.get("result");
			
			for (LinkedHashMap<String, String> lookObj : lookList) {
				ApplyLookVersionResponse look = new ApplyLookVersionResponse();
				
				String image = personalLooksManager.getAppliedLook(lookObj.get("id"));
				look.setBase64Image("data:image/png;base64," + image);
				look.setId(lookObj.get("id"));
				look.setVersion(String.valueOf(lookObj.get("version")));
				response.add(look);
			}

		}

		return response;
	}

	}
