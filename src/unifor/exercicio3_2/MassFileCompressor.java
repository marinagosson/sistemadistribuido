package unifor.exercicio3_2;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MassFileCompressor {

	private ArrayList<File> files;
	private String id;
	private double time;

	public MassFileCompressor() {
		super();
		
		files = new ArrayList<File>();
	}

	public ArrayList<File> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<File> files) {
		this.files = files;
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

	public void run() {

		long start = System.nanoTime();
		
		for (File file : files) {

			try {
				FileCompressingUtils.compressFile(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		double difference = (System.nanoTime() - start)/1e6;

		setTime(difference);
		
		System.out.println(id + " concluída em "+ difference+ " nano");
	}

}
