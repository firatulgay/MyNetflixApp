package com.firatulgay.dao;

import com.firatulgay.Domain.Dizi;
import com.firatulgay.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by FiratUlgay on 22.12.2019.
 */
public class DiziFilmBasrolDao {

    public List<Dizi> findAllDizi() {
        List<Dizi> diziList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select dizi_film_basrol From DiziFilmBasrol dizi_film_basrol";
            Query query = session.createQuery(hql);
            diziList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return diziList;
    }

}
