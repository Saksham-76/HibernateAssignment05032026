package org;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddBook {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Book b = new Book();

		System.out.println("Enter Book Title");
		b.setTitle(sc.nextLine());

		System.out.println("Enter Book Author");
		b.setAuthor(sc.nextLine());

		System.out.println("Enter Book Price");
		b.setPrice(sc.nextDouble());

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseproperties");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		em.persist(b);

		et.commit();

		System.out.println("Book Added Successfully");

		em.close();
		emf.close();
		sc.close();
	}
}