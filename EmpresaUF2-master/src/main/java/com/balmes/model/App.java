package com.balmes.model;

import Application.HibernateUtil;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import jakarta.persistence.Query;
import com.balmes.model.Departments;
import com.balmes.model.Employees;

public class App {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

   		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
  		session.beginTransaction();
   		System.out.println("I per inserir, qualsevol altre cosa per buscar:");
   		if(sc.nextLine().equalsIgnoreCase("I")){
   			System.out.println("Nom: ");
   			String nom = sc.nextLine();
   			System.out.println("Cognom: ");
   			String cognom = sc.nextLine();
   			System.out.println("Data naixement (en format 'yyyy-MM-dd'): ");
   			String data1 = sc.nextLine();
   			System.out.println("Gènere: ");
   			String genere = sc.nextLine();
   			System.out.println("Data d’incorporació (en format 'yyyy-MM-dd'): ");
   			String data2 = sc.nextLine();
   			System.out.println("Salari: ");
   			float salari = sc.nextFloat();
   			sc.nextLine(); // Consumim la nova línia deixada per nextFloat()
   			System.out.println("Rol: ");
   			String rol = sc.nextLine();
   			System.out.println("Departament: ");
   			int dept = sc.nextInt();

   			// Comprovar que les dades són vàlides abans d'inserir-les
   			if (nom.isEmpty() || cognom.isEmpty() || data1.isEmpty() || genere.isEmpty() || data2.isEmpty() || rol.isEmpty()) {
   			    System.out.println("Les dades introduïdes no són vàlides.");
   			} else {
   			    String insert = "INSERT INTO employees"
   			            + "(last_name, first_name, birth_date, gender, hire_date, role, salary, deptno) VALUES"
   			            + "('"+cognom+"', '"+nom+"', '"+data1+"', '"+genere+"', '"+data2+"', '"+rol+"', "+salari+", "+dept+")"
   			            + ";";
   			    Query q = session.createNativeQuery(insert);
   			    
   			}
   	   	
   		}else {
   			System.out.println("Quin departament vols buscar?");
   			String departament = sc.nextLine();
   			Query q = session.createNativeQuery("SELECT * FROM employees INNER JOIN departaments ON departaments.deptno = employees.deptno WHERE departaments.deptname = '" + departament + "'");
   			List<Object[]> result = q.getResultList();
   			if (result.isEmpty()) {
   			    System.out.println("No s'han trobat resultats.");
   			} else {
   			    for (Object[] row : result) {
   			        Employees employee = (Employees) row[0]; // Assumint que la primera columna correspon a l'objecte Employees
   			        System.out.println(employee); // Mostra l'objecte Employees per pantalla
   			    }
   			}


   		}
   		session.getTransaction().commit();
   		session.close();
   		
}
}
