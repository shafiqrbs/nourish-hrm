package com.erp.hrm.util;

import com.erp.hrm.domain.DeviceRowUploadedData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class BulkInsetUtil {
    /*
    public static <T> List<T> bulkInsertWithEntityManager(EntityManagerFactory emf , List<T> insertList) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        insertList.forEach(temp -> entityManager.persist(temp));
        entityManager.getTransaction().commit();
        entityManager.close();
        return insertList;
    }
    */

    public static <T> List<T> bulkInsertWithEntityManager(EntityManagerFactory emf , List<T> insertList) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        int batchSize = 500;
        try {
            entityTransaction.begin();
            for (int i = 0; i < insertList.size(); i++) {
                if (i > 0 && i % batchSize == 0) {
                    entityTransaction.commit();
                    entityTransaction.begin();
                    entityManager.clear();
                }
                entityManager.persist(insertList.get(i));
            }
            entityTransaction.commit();
        } catch (RuntimeException e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
        return insertList;
    }
}
