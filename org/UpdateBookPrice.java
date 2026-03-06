package org;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateBookPrice {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Book Id");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter Book Author");
		String author = sc.nextLine();

		System.out.println("Enter New Price");
		double price = sc.nextDouble();

		String update = "UPDATE Book b SET b.price=?1 WHERE b.id=?2 AND b.author=?3";

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseproperties");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Query query = em.createQuery(update);

		query.setParameter(1, price);
		query.setParameter(2, id);
		query.setParameter(3, author);

		int result = query.executeUpdate();

		if(result != 0) {
			System.out.println("Price Updated Successfully");
		}
		else {
			System.out.println("Book Not Found");
		}

		et.commit();

		em.close();
		emf.close();
		sc.close();
	}
}