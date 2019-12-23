package com.firatulgay.dao;

import com.firatulgay.Domain.BasRolOyuncu;
import com.firatulgay.Domain.Dizi;
import com.firatulgay.Domain.Film;
import com.firatulgay.Views.EkleView.DiziFilmEkle;
import com.firatulgay.utils.HibernateUtil;
import com.vaadin.ui.Notification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DiziFilmDao {

    public Film filmEkle (Film film){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();

            film= (Film) session.merge(film);

            session.getTransaction().commit();

            Notification.show("Film Kaydedildi");
        } catch (Exception ex) {
            Notification.show("Kaydetme İşlemi Başarısız");
            System.out.println(ex.getMessage());
        }

        return film;
    }


    public Dizi diziEkle (Dizi dizi){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();

            dizi= (Dizi) session.merge(dizi);

            session.getTransaction().commit();
            Notification.show("Dizi Kaydedildi");
        } catch (Exception ex) {
            Notification.show("Kaydetme İşlemi Başarısız");
            System.out.println(ex.getMessage());
        }

        return dizi;
    }

    public List<Film> findAllFilm() {
        List<Film> filmList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select film From Film film";
            Query query = session.createQuery(hql);
            filmList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return filmList;
    }

    public Film findFilmById(long id) {
        Film film = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select film From Film film where film.id =:filmId";
            Query query = session.createQuery(hql);
            query.setParameter("filmId", id);
            film = (Film)query.uniqueResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return film;
    }

    public List<Dizi> findAllDizi() {
        List<Dizi> diziList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select dizi From Dizi dizi";
            Query query = session.createQuery(hql);
            diziList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return diziList;
    }

    public List<Film> findAllFilmByOyuncuId(long basrolId) {
        List<Film> films = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select film From Film film where film.basRolOyuncu.id = :basrolId";
            Query query = session.createQuery(hql);
            query.setParameter("basrolId", basrolId);
            films =  query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return films;

    }

    public List<Dizi> findAllDiziByOyuncuId(long basrolId) {
        List<Dizi> diziList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select dizi From Dizi dizi where dizi.basRolOyuncu.id = :basrolId";
            Query query = session.createQuery(hql);
            query.setParameter("basrolId", basrolId);
            diziList =  query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return diziList;

    }
}