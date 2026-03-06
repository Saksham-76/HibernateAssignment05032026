package org;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DisplayAllBooks {

	public static void main(String[] args) {

		String display = "FROM Book";

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseproperties");
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery(display);

		List<Book> books = query.getResultList();

		for(Book b : books) {
			System.out.println(b);
		}

		em.close();
		emf.close();
	}
}