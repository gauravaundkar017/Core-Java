package com.app.customers_utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.core.Customer;

public interface IOUtils {

	static Object readDetails(String fName) throws IOException, ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fName))) {
			return in.readObject();
		}
	}

	static void writeDetails(Map<String, Customer> mapDetails, String fName) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fName))) {
			out.writeObject(mapDetails);

		}

	}
}
