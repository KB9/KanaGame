package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
	private Scanner scanner;
	private BufferedWriter writer;
	private File file = new File("level.txt");
	private int[][] tiles = new int[Level.mLevelTileWidth][Level.mLevelTileHeight];

	public FileHandling() {
		try {
			if (!file.exists())
				fileDoesNotExist();

			readFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void fileDoesNotExist() {

		try {
			writer = new BufferedWriter(new FileWriter(file));
			file.createNewFile();

			for (int i = 0; i < Level.mLevelTileWidth; i++) {
				for (int j = 0; j < Level.mLevelTileHeight; j++) {
					writer.write("0 ");
					
				}
			}

			writer.close();
		} catch (Exception e) {

		}
	}

	// The high score file is read.
	public int[][] readFile() {
		try {
			scanner = new Scanner(new BufferedReader(new FileReader(file)));

			while (scanner.hasNext()) {
				for (int i = 0; i < Level.mLevelTileWidth; i++) {
					for (int j = 0; j < Level.mLevelTileHeight; j++) {
						tiles[i][j] = scanner.nextInt();
					}
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("READ");
		return tiles;

	}

	public void writeFile() {

		// try
		// {
		// //writer = new BufferedWriter(new FileWriter(file));
		// for(int i = 0; i < 5; i++)
		// {
		// //writer.write(names[i] + " ");
		// //writer.write(Player.times[i] + " ");
		// //writer.write(Player.deaths[i] + " ");
		// }
		// // writer.close();
		// }
		// catch(IOException e)
		// {
		// e.printStackTrace();
		// }
	}
}
