import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;



public class ProxySrv {
	public static int i=0;
	public static String datos[] =new String [5];
	private static final int PORT = 9000;
        static String control=" ";
        static String e="";

	private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("The chat server is running.");//imprime en consola "The chat server is running."
		ServerSocket listener = new ServerSocket(PORT);//declara el servidor listener
		try {
			while (true) {//si es verdader
				new Handler(listener.accept()).start();//metodo Handler comienza y server accept
			}
		} finally {
			listener.close();//finaliza servidor.
		}
	}
	public static void mandarCorreo() {

		// El correo gmail de envío
		String correoEnvia = datos[0];
		String claveCorreo = datos[1];


		// La configuración para enviar correo
		Properties properties = new Properties();

		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.user", correoEnvia);
		properties.put("mail.password", claveCorreo);

		// Obtener la sesion
		Session session = Session.getInstance(properties, null);
		int aviso = 0;
		try {
			// Crear el cuerpo del mensaje
			MimeMessage mimeMessage = new MimeMessage(session);

			// Agregar quien envía el correo
			mimeMessage.setFrom(new InternetAddress(correoEnvia));

			// Los destinatarios
			InternetAddress[] internetAddresses = {new InternetAddress(datos[2])};
			//		     new InternetAddress("correo2@gmail.com"),
			//		     new InternetAddress("correo3@gmail.com") };

			// Agregar los destinatarios al mensaje
			mimeMessage.setRecipients(Message.RecipientType.TO,
					internetAddresses);
			// Agregar el asunto al correo
			mimeMessage.setSubject(datos[3]);
			// Creo la parte del mensaje
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setText(datos[4]);
			// Crear el multipart para agregar la parte del mensaje anterior
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			// Agregar el multipart al cuerpo del mensaje
			mimeMessage.setContent(multipart);
			// Enviar el mensaje
			Transport transport = session.getTransport("smtp");
			transport.connect(correoEnvia, claveCorreo);
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			transport.close();
			System.out.println("cierre");

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
			aviso = 1;
		}
		if (aviso==0) {
			control="¡Correo electrónico enviado exitosamente!";
		}
	}
	public static void mandarCorreoError() {

		// El correo gmail de envío
		String correoEnvia = datos[0];
		String claveCorreo = datos[1];


		// La configuración para enviar correo
		Properties properties = new Properties();

		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.user", correoEnvia);
		properties.put("mail.password", claveCorreo);

		// Obtener la sesion
		Session session = Session.getInstance(properties, null);
		int aviso = 0;
		try {
			// Crear el cuerpo del mensaje
			MimeMessage mimeMessage = new MimeMessage(session);

			// Agregar quien envía el correo
			mimeMessage.setFrom(new InternetAddress(correoEnvia));

			// Los destinatarios
			InternetAddress[] internetAddresses = {new InternetAddress(datos[0])};
			//		     new InternetAddress("correo2@gmail.com"),
			//		     new InternetAddress("correo3@gmail.com") };

			// Agregar los destinatarios al mensaje
			mimeMessage.setRecipients(Message.RecipientType.TO,
					internetAddresses);

			// Agregar el asunto al correo
			mimeMessage.setSubject("Mensaje de error");

			// Creo la parte del mensaje
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setText(datos[4]);
			


			// Crear el multipart para agregar la parte del mensaje anterior
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);


			// Agregar el multipart al cuerpo del mensaje
			mimeMessage.setContent(multipart);

			// Enviar el mensaje
			Transport transport = session.getTransport("smtp");
			transport.connect(correoEnvia, claveCorreo);
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

			transport.close();
			System.out.println("cierre");

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
			aviso = 1;
		}
		if (aviso==0) {
			control="¡Correo electrónico enviado exitosamente!";
		}
		
	}

		
	private static class Handler extends Thread {// extends Thread para  redefinir el método run
		private Socket socket;//establecimiento de la conexión de red y del envío de datos a través de ella.
		private BufferedReader in;// Para leer del teclado con el método readLine()
		private PrintWriter out;//  Para poder mandar el string leido al cliente

		/**
		 * Constructs a handler thread, squirreling away the socket.
		 * All the interesting work is done in the run method.
		 */
		public Handler(Socket socket) {//metodo Handler recibe el socket
			this.socket = socket;//socket declarado a fuera del metodo es igual al socket recibido.
		}



		public void run() {	
			String mensajeServidor;
			StringTokenizer tokens;
			StringTokenizer tokens1;
                        ArrayList<String> palabras = new ArrayList();
                        leer(palabras);
                        e="";
			i=0;
			try {

				in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //lee el socket ingresado.
				out= new PrintWriter(socket.getOutputStream(), true);//escribir datos en cliente.

				while (true) {
					mensajeServidor = in.readLine();//lee los datos de cliente
					if (mensajeServidor == null) {//si es vacio
						return;//regresa
					}else {

						tokens=new StringTokenizer(mensajeServidor,"¬");//divide al string en tokens cada que encuentra este simbolo ¬
						while(tokens.hasMoreTokens()){
							String str=tokens.nextToken();//los tokens son almacenados en str
							datos[i]=str;
							i++;
						}System.out.println(datos[4]);	
						tokens1=new StringTokenizer(datos[4]," ");
						while(tokens1.hasMoreTokens()){
							String str1=tokens1.nextToken();
                                                        for( String s : palabras ){
                                                        
                                                        
							if(str1.toUpperCase().equals(s)){//si hay estas palabras
							 e+=s+" ";
							}
                                                        }
                  				}
                                                
                                            if(e!=""){
                                                   datos[4]=e+" Estas palabras no son permitidas";
							mandarCorreoError();
                                                        i=0;
							out.println("Error "+e+" Estas palabras no son permitidas");
                                                        e="";
                                                   }else{
                                                   mandarCorreo();
                                                   i=0;
                                                   e="";
                                                   out.println("correcto "+ control);
                                                   }

					}
				}
			}catch (IOException e) {//en caso de error
				System.out.println("\n"+ e+ "no hay coneccion");//imprimir en consola el error 
			}  finally {
				if (out != null) {
					writers.remove(out);
				}
				try {
					socket.close();
					System.out.println("Fin de la conexión");
				} catch (IOException e) {
				}
				//Se finaliza la conexión con el cliente
			}
		} 
        
        public void leer(ArrayList pCompare){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        int i=0;
        try {
			archivo = new File ("palabras.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);

			String linea;
                        while((linea=br.readLine())!=null){
                        StringTokenizer token=new StringTokenizer(linea," ");
                        while(token.hasMoreTokens()){
                            pCompare.add(token.nextToken());
                            
                        }
                        }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           try{
              if( null != fr ){
                 fr.close();
              }
           }catch (Exception e2){
              e2.printStackTrace();
           }
        }

    }
	}

}
