package com.github.truongbb.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
      Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
      return metadata.getSessionFactoryBuilder().build();
    }
    return sessionFactory;
  }

}
