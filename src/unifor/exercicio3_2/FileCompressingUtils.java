package unifor.exercicio3_2;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileCompressingUtils {

	public static boolean compressFile(File f) throws IOException {

		String outputFilePath = f.getAbsolutePath().substring(0, f.getAbsolutePath().length() - 4);
		
		outputFilePath = outputFilePath + ".zip";
		
		compactarParaZip(outputFilePath, f.getAbsolutePath());
		
		return true;
	}

	static final int BUFFER_SIZE = 4096;
	
	public static void compactarParaZip(String arqSaida, String arqEntrada) throws IOException {
		int cont;
		byte[] dados =
		
		new byte[BUFFER_SIZE];
		BufferedInputStream origem = null;
		FileInputStream streamDeEntrada = null;
		FileOutputStream destino = null;
		ZipOutputStream saida = null;
		ZipEntry entry = null;
		try {
			destino = new FileOutputStream(new File(arqSaida));
			saida = new ZipOutputStream(new BufferedOutputStream(destino));
			File file = new File(arqEntrada);
			streamDeEntrada = new FileInputStream(file);
			origem = new BufferedInputStream(streamDeEntrada, BUFFER_SIZE);
			entry = new ZipEntry(file.getName());
			saida.putNextEntry(entry);
			while ((cont = origem.read(dados, 0, BUFFER_SIZE)) != -1) {
				saida.write(dados, 0, cont);
			}
			origem.close();
			saida.close();
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		}
	}
}
