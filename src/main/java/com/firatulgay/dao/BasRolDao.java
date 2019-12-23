package com.firatulgay.dao;

import com.firatulgay.Domain.BasRolOyuncu;
import com.firatulgay.utils.HibernateUtil;
import com.vaadin.ui.Notification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
public class BasRolDao {

    public BasRolOyuncu basRolEkle(BasRolOyuncu basRolOyuncu) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();
            basRolOyuncu = (BasRolOyuncu) session.merge(basRolOyuncu);
            session.getTransaction().commit();
            Notification.show("Başrol Kaydedildi");
        } catch (Exception ex) {
            Notification.show("Kaydetme İşlemi Başarısız");
            System.out.println(ex.getMessage());
        }
        return basRolOyuncu;
    }

    public BasRolOyuncu findOyuncuById(long id) {
        BasRolOyuncu basRolOyuncu = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select basRolOyuncu From BasRolOyuncu basRolOyuncu where basRolOyuncu.id =:basRolOyuncuId";
            Query query = session.createQuery(hql);
            query.setParameter("basRolOyuncuId", id);
            basRolOyuncu = (BasRolOyuncu)query.uniqueResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return basRolOyuncu;
    }}
