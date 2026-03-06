package org;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteBook {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Book Id");
		int id = sc.nextInt();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseproperties");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Book b = em.find(Book.class, id);

		if(b != null) {

			et.begin();

			em.remove(b);

			et.commit();

			System.out.println("Book Deleted Successfully");
		}
		else {
			System.out.println("Book Not Found");
		}

		em.close();
		emf.close();
		sc.close();
	}
}