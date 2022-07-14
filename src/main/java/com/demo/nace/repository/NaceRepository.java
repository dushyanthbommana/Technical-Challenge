package com.demo.nace.repository;

import com.demo.nace.entity.NaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 * This is a repository class which interacts with DB
 */
@Repository
public interface NaceRepository extends JpaRepository<NaceEntity,Integer> {

    @Transactional
    @Query(value = "insert into nace_details (order_num,level,code,parent,description,This_item_includes,This_item_also_includes,Rulings,This_item_excludes,Reference_to_ISIC_Rev_4) "
            + "VALUES (:#{#naceEntity.orderId},:#{#naceEntity.level},:#{#naceEntity.code},:#{#naceEntity.parent},:#{#naceEntity.description},:#{#naceEntity.thisItemIncludes}" +
            ",:#{#naceEntity.thisItemAlsoIncludes}, :#{#naceEntity.rulings},:#{#naceEntity.thisItemExcludes},:#{#naceEntity.referenceToIsicRev4})", nativeQuery = true)
    void createNace(@Param("naceEntity") NaceEntity naceEntity);

    @Transactional
    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<NaceEntity> findByOrderId(Long order_num);


}
