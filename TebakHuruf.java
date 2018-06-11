package ga.snowsakura.GuessingWords;

import java.util.Scanner;
import java.util.Random;

public class TebakHuruf {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		String[] kata = {"mobil", "pisang", "komputer", "sapi", "hujan", "air", "buah", "kucing", "macan"};
		boolean Bermain = true;
		
		while (Bermain == true) {
			System.out.println("Welcome to Guessing Word Game!");
			char[] randomWordToGuess = kata[random.nextInt(kata.length)].toCharArray(); //Merubah dari mobil jadi m,o,b,i,l
			int jumlahMenebak = randomWordToGuess.length;
			char[] playerGuess = new char[jumlahMenebak];
			
			for(int i = 0; i < playerGuess.length;i++) {
				playerGuess[i] = '*';
			}
			
			boolean wordIsGuessed = false;
			int mencoba = 0;
			
			while (!wordIsGuessed && mencoba != jumlahMenebak + 2) {
				System.out.println("Tebakan Saat Ini: ");
				PrintArray(playerGuess);
				System.out.printf("Kamu tinggal punya %d kesempatan untuk mencoba.\n", jumlahMenebak + 2 - mencoba);
				System.out.println("Masukan satu huruf");
				char input = scanner.nextLine().charAt(0); //kalo misalnya user masukin data seperti "askdafioaf" maka yang akan diambil hanya huruf yang pertama
				mencoba++;
				
				if (input == '-') {
					Bermain = false;
					wordIsGuessed = true;
				}else {
					for(int i = 0; i < randomWordToGuess.length;i++) {
						if (randomWordToGuess[i] == input) {
							playerGuess[i] = input;
						}
					}
					
					if (isTheWordGuessed(playerGuess)) {
						wordIsGuessed = true;
						System.out.println("");
						System.out.println("Katanya adalah: ");
						System.out.println(playerGuess);
						System.out.println("Selamat Anda Menang!");
					}
				}
			}

			if(!wordIsGuessed) {
				System.out.println("Kamu Telah habis kesempatan untuk Menebak :(");
				System.out.println("   ____________");
				System.out.println("   |          _|_");
				System.out.println("   |         /   \\");
				System.out.println("   |        |     |");
				System.out.println("   |         \\_ _/");
				System.out.println("   |          _|_");
				System.out.println("   |         / | \\");
				System.out.println("   |          / \\ ");
				System.out.println("___|___      /   \\");
			}
			System.out.println("Apakah Kamu Mau Bermain Lagi? (Ya/Tidak)");
			String anotherGame = scanner.nextLine();
			if(anotherGame.equals("tidak")) Bermain = false;
		}
		
		System.out.println("Permainan Berakhir!");
		scanner.close();
	}
	
	public static void PrintArray(char[] array) {
		for(int i = 0; i < array.length;i++) {
			System.out.print(array[i] + "");
		}
		System.out.println();
	}

	public static boolean isTheWordGuessed(char[] array) {
		for(int i = 0; i < array.length;i++) {
			if(array[i] == '*') return false;
		}
		return true;
	}
	
}
