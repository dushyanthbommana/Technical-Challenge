package com.demo.nace.service;

import com.demo.nace.entity.NaceEntity;
import com.demo.nace.exception.DataBaseException;
import com.demo.nace.repository.NaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.Optional;

import static com.demo.nace.util.Constants.NO_RECORD_ERROR_MESSAGE;

/**
 * This service class contain methods which interacts with repository class to retrive data
 */
@Service
public class NaceService {
    @Autowired
    private NaceRepository naceRepository;

    @Autowired
    private EntityManager entityManager;

    public void createNace(NaceEntity naceEntity){
        //Also we can use naceRepository.save(naceEntity) to update the record
        try{
        naceRepository.createNace(naceEntity);
        }catch (DataAccessException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    /**
     * This method retrieves naceEntity for given orderId
     * @param orderId
     * @return naceEntity
     */
    public NaceEntity getNaceDetails(Long orderId) {
       Optional<NaceEntity> naceEntity= naceRepository.findByOrderId(orderId);
       if(naceEntity.isPresent()){
           return naceEntity.get();
       }
       return null;
    }

    /**
     * This methods update the DB with the updated values
     * @param naceEntity
     * @param orderId
     */
    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public void updateNace(NaceEntity naceEntity,Long orderId) {
        try{
            Optional<NaceEntity> response = naceRepository.findByOrderId(orderId);
            if(response.isPresent()){
                NaceEntity  existingNaceRecord = response.get();
                existingNaceRecord.setCode(naceEntity.getCode());
                existingNaceRecord.setDescription(naceEntity.getDescription());
                existingNaceRecord.setLevel(naceEntity.getLevel());
                existingNaceRecord.setParent(naceEntity.getParent());
                existingNaceRecord.setRulings(naceEntity.getRulings());
                existingNaceRecord.setThisItemIncludes(naceEntity.getThisItemIncludes());
                existingNaceRecord.setThisItemAlsoIncludes(naceEntity.getThisItemAlsoIncludes());
                existingNaceRecord.setThisItemExcludes(naceEntity.getThisItemExcludes());
                existingNaceRecord.setReferenceToIsicRev4(naceEntity.getReferenceToIsicRev4());
                naceRepository.save(existingNaceRecord);
            }
        }catch (Exception e){
            throw new DataBaseException(e.getMessage());
        }
    }
}
