package com.ust.pnp.arsenal.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.pnp.arsenal.exception.LooksServiceException;
import com.ust.pnp.arsenal.manager.LooksManager;
import com.ust.pnp.arsenal.model.ApplyLookRequest;
import com.ust.pnp.arsenal.model.ApplyLookVersionResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/looks")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LookResource {

  @Autowired
  LooksManager looksManager;

  /**
   * API to apply makeup on face
   * @return success
   * @throws LooksServiceException
   * @throws IOException 
   */
  @PostMapping(path = "/applymakeup/v2")
  @Operation(description = "Apply makeup on face", operationId = "applyFaceMakeup",
      summary = "Apply makeup on face", tags = {"looks",})
  @ApiResponses(
      value = {@ApiResponse(responseCode = "201", description = "successful get operation"),
          @ApiResponse(responseCode = "400", description = "un-successful get operation")})
  public ResponseEntity<List<ApplyLookVersionResponse>> applyFaceMakeuphVersion(@RequestBody ApplyLookRequest applyModal)
      throws LooksServiceException, IOException {
	  List<ApplyLookVersionResponse> response = looksManager.applyFaceMakeupVersion(applyModal);
	return new ResponseEntity<>(response, response.size() == 0 ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
  }
  
}
