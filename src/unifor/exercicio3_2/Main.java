package unifor.exercicio3_2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Main {

	private static final int NUMBER_OF_FILES = 10;

	public static void main(String[] args) throws IOException {

		long start = System.nanoTime();

		ArrayList<Thread> threads = new ArrayList<Thread>();

		MassFileCompressor massCompressor = new MassFileCompressor();

		massCompressor.setId("Mass Compressor");

		String workingDirectory = System.getProperty("user.dir");

		for(int i = 0 ; i < args.length ; i++){

			File original = new File(workingDirectory + "/src/teste.txt");

			File file = new File(workingDirectory + "/compress/" + args[i] + ".txt");

			Files.copy(original.toPath(), file.toPath());

			if (file != null) {
				massCompressor.getFiles().add(original);
			}

			threads.add(new Thread(new FileCompressorThread(file, "Thread " + i)));
		}

		massCompressor.run();

		for (Thread thread : threads) {
			thread.start();
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Tempo total: " + (System.nanoTime() - start) / 1e6);
	}
}
