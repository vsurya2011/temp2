package com.jdbc;

import com.jdbc.operation.*;
import com.jdbc.operation.StudentOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private StudentOperations operations;

	@Autowired
	private InsertOperation insertOp;

	@Autowired
	private FindOperation findOp;

	@Autowired
	private FindAllOperation findAllOp;

	@Autowired
	private DeleteOperation deleteOp;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n 1. Insert \n 2. Find \n 3. FindAll \n 4. Delete \n 5. Exit");
			int choice = sc.nextInt();

			switch (choice) {
				case 1 -> insertOp.execute();
				case 2 -> findOp.execute();
				case 3 -> findAllOp.execute();
				case 4 -> deleteOp.execute();
				case 5 -> System.exit(0);
				default -> System.out.println("Invalid choice");
			}
		}
	}
}