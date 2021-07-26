package com.proquest.interview.phonebook;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.proquest.interview.util.DatabaseUtil;

public class PhoneBookImpl implements PhoneBook {
	public List people;
	
	@Override
	public void addPerson(Person newPerson) {
		//TODO: write this method
		// add to the list of phonebook
		people.add(newPerson);
		// save to the DB
		saveToDB(newPerson);
	}
	
	@Override
	public Person findPerson(String fn, String sn) {
		//TODO: write this method
		String name = fn + " " + sn;
		Person p = new Person();
		// search in the List of people
		ListIterator<Person> it = people.listIterator();
		while (it.hasNext()){
			Person tp = it.next();
			if (tp.getName() == name) {
				p = tp;
				break;
			}
		}

		return p;
	}
	public void saveToDB(Person newPerson){
		try {
			Connection cn = DatabaseUtil.getConnection();
			Statement stmt = cn.createStatement();

			stmt.execute("INSERT INTO PHONEBOOK (NAME, PHONENUMBER, ADDRESS) VALUES('"+newPerson.getName() +"','"+newPerson.getPhoneNumber()+"', '"+newPerson.getAddress()+"')");
			cn.commit();
			stmt.close();
			cn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void printPerson(Person p){
		System.out.println(p.getName() + ", " + p.getPhoneNumber() + ", " + p.getAddress() +";");
	}
	public void main(String[] args) {
		DatabaseUtil.initDB();  //You should not remove this line, it creates the in-memory database

		/* TODO: create person objects and put them in the PhoneBook and database
		 * John Smith, (248) 123-4567, 1234 Sand Hill Dr, Royal Oak, MI
		 * Cynthia Smith, (824) 128-8758, 875 Main St, Ann Arbor, MI
		*/
		people = new ArrayList<Person>();
		Person John = new Person("John Smith","(248) 123-4567", "1234 Sand Hill Dr, Royal Oak, MI");
		Person Cynthia = new Person ("Cynthia Smith", "(824) 128-8758", "875 Main St, Ann Arbor, MI");
		addPerson(John);
		addPerson(Cynthia);

		// TODO: print the phone book out to System.out
		Person p = new Person();
		// search in the List of people
		ListIterator<Person> it = people.listIterator();
		while (it.hasNext())
		{
			p = it.next();
			printPerson(p);
		}
		// TODO: find Cynthia Smith and print out just her entry
		printPerson(findPerson("Cynthia", "Smith"));

		// TODO: insert the new person objects into the database
		  // created a new method to insert new person to the DB
	}
}
