package service;

import com.demo.nace.configuration.NaceConfiguration;
import com.demo.nace.entity.NaceEntity;
import com.demo.nace.repository.NaceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * This is test class which creates table in H2 in-memory DB and does the transactions.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { NaceConfiguration.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class NaceServiceTest {

    @Resource
    private NaceRepository naceRepository;

    /**
     * creates a new record in H2 in-memory DB and retrieves the record
     */
    @Test
    public void createAndRetrieveNaceRecord()  {
        NaceEntity naceEntity = buildEntity();
        NaceEntity result = naceRepository.save(naceEntity);
        assertEquals("A", result.getCode());
        assertEquals("1", result.getLevel());
        assertEquals("description", result.getDescription());
        assertEquals("thisItemIncludes", result.getThisItemIncludes());
        assertEquals("thisItemAlsoIncludes", result.getThisItemAlsoIncludes());
        assertEquals("thisItemExcludes", result.getThisItemExcludes());
        assertEquals("rulings", result.getRulings());
        assertEquals("reference", result.getReferenceToIsicRev4());

    }

    /**
     * updates the existing record in H2 in-memory DB and retrieves the record
     */
    @Test
    public void updateAndRetrieveNaceRecord()  {
        NaceEntity naceEntity = buildEntity();
        naceEntity.setCode("B");
        NaceEntity result = naceRepository.save(naceEntity);
        assertEquals("B", naceEntity.getCode());
        assertEquals("1", naceEntity.getLevel());
        assertEquals("description", naceEntity.getDescription());
        assertEquals("thisItemIncludes", naceEntity.getThisItemIncludes());
        assertEquals("thisItemAlsoIncludes", naceEntity.getThisItemAlsoIncludes());
        assertEquals("thisItemExcludes", naceEntity.getThisItemExcludes());
        assertEquals("rulings", naceEntity.getRulings());
        assertEquals("reference", naceEntity.getReferenceToIsicRev4());

    }





    private NaceEntity buildEntity() {
        NaceEntity naceEntity = new NaceEntity();
        naceEntity.setOrderId(Long.valueOf(1234));
        naceEntity.setCode("A");
        naceEntity.setLevel("1");
        naceEntity.setParent(null);
        naceEntity.setDescription("description");
        naceEntity.setThisItemIncludes("thisItemIncludes");
        naceEntity.setThisItemAlsoIncludes("thisItemAlsoIncludes");
        naceEntity.setThisItemExcludes("thisItemExcludes");
        naceEntity.setRulings("rulings");
        naceEntity.setReferenceToIsicRev4("reference");
        return naceEntity;
    }

}
