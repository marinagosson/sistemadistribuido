package unifor.exercicio3_2;
import java.io.File;
import java.io.IOException;

public class FileCompressorThread implements Runnable {

	private File file;
	private String id;
	private double time;
	private boolean finished;

	public FileCompressorThread(File file, String id) {
		super();
		this.file = file;
		this.id = id;
	}

	@Override
	public void run() {

		if (file != null) {

			long start = System.nanoTime();

			try {

				FileCompressingUtils.compressFile(file);

				double difference = (System.nanoTime() - start) / 1e6;

				System.out.println("A " + this.id + " finalizou em " + difference + " nano");

			} catch (IOException e) {

				System.out.println("Erro na thread " + this.id);

				e.printStackTrace();
			}
		}
	}
	


	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

}
