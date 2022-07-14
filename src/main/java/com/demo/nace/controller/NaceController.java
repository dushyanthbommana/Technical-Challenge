package com.demo.nace.controller;

import com.demo.nace.entity.NaceEntity;
import com.demo.nace.service.NaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.demo.nace.util.Constants.NO_RECORD_ERROR_MESSAGE;

/**
 * This class contains methods with endpoints
 */
@RestController
public class NaceController {

    @Autowired
    private NaceService naceService;

    /**
     * This method creates record in DB
     * @param naceEntity
     * @param headers
     * @return http status code 201
     */
    @RequestMapping(value = "/create/nace", method = RequestMethod.POST)
    public ResponseEntity createNaceDetails(@RequestBody NaceEntity naceEntity , @RequestHeader Map<String,String> headers){
        naceService.createNace(naceEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * This method updates the DB
     * @param naceEntity
     * @param headers
     * @return success status code
     */
    @RequestMapping(value = "/update/nace/{orderId}", method = RequestMethod.PUT)
    public ResponseEntity putNaceDetails(@RequestBody NaceEntity naceEntity ,@PathVariable String orderId, @RequestHeader Map<String,String> headers){
           naceService.updateNace(naceEntity,Long.valueOf(orderId));
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * This method returns nace record for the given orderId
     * @param orderId
     * @param headers
     * @return naceEntity
     */
    @RequestMapping(value = "/nace/{orderId}", method = RequestMethod.GET)
    public ResponseEntity getNaceDetails(@PathVariable String orderId , @RequestHeader Map<String,String> headers){
        NaceEntity naceEntity = naceService.getNaceDetails(Long.valueOf(orderId));
        if(null != naceEntity){
            return new ResponseEntity<>(naceEntity, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(NO_RECORD_ERROR_MESSAGE, HttpStatus.OK);
        }

    }
}
