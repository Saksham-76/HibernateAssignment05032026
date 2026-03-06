package org;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DisplayBookByTitle {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Book Title");
		String title = sc.nextLine();

		String display = "FROM Book b WHERE b.title=?1";

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseproperties");
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery(display);

		query.setParameter(1, title);

		List<Book> books = query.getResultList();

		for(Book b : books) {
			System.out.println(b);
		}

		em.close();
		emf.close();
		sc.close();
	}
}