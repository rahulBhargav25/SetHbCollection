package Client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashSet;

public class StoreData {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();


		HashSet<String> set1 = new HashSet<String>();
		set1.add("java is a programming language");
		set1.add("java is a platform");

		HashSet<String> set2 = new HashSet<String>();
		set2.add("Servlet is an interface");
		set2.add("Servlet is an api");

		Ques q1 = new Ques();
		q1.setQname("what is java");
		q1.setAnswers(set1);

		Ques q2 = new Ques();
		q2.setQname("what is servlet?");
		q2.setAnswers(set2);

		session.persist(q1);
		session.persist(q2);

		t.commit();
		System.out.println("success");
	}
}
