package com.capgemini.chess.batch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * batch will find files in chosen folder, read names and size then write in
 * memory and delete files with log in console
 * 
 * @author DOLESIEJ
 *
 */
@Component
public class UpdateFolder {

	private static List<String> files = new ArrayList<String>();

	public UpdateFolder() {
	}

	@Scheduled(fixedRate = 60000)
	public static void checkFolder() {
		String dirPathname = "C:/javatest/";
		File directory = new File(dirPathname);
		if (!directory.isDirectory()) {
			System.out.println(dirPathname + " is not directory");
			return;
		}
		for (File file : directory.listFiles()) {
			files.add(file + " " + CheckSize(file.getPath()) + " bajts");
			System.out.println(file + " " + CheckSize(file.getPath()) + " bajts");
			DeleteFile(file.getPath());
		}

	}

	private static long CheckSize(String path) {
		File file = new File(path);
		if (file.exists()) {
			return file.length();
		} else {
			return 0;
		}
	}

	private static void DeleteFile(String path) {
		File file = new File(path);
		if (file.delete()) {
			System.out.println(file.getName() + " deleted!");
		} else {
			System.out.println("Deleted was not succesful");
		}
	}
}
