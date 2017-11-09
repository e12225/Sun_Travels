package main.java.codegen.sunTravels.DAO;

import main.java.codegen.sunTravels.Entities.Hotel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by DELL on 11/9/2017.
 */
@Repository
public class HotelDAOImpl implements HotelDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public void addHotel(Hotel hotel) {
        em.persist(hotel);
    }

    @Override
    public List<Hotel> getHotelList() {

        CriteriaQuery<Hotel> criteriaQuery = em.getCriteriaBuilder().createQuery(Hotel.class);
        @SuppressWarnings("unused") //search what is this annotation
        Root<Hotel> root = criteriaQuery.from(Hotel.class);
        return em.createQuery(criteriaQuery).getResultList();
    }


}
