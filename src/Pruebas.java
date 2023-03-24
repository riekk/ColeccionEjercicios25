import java.io.*;
import java.util.ArrayList;

public class Pruebas {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            //fis = new FileInputStream("/home/ALU1K/Documentos/image.png");
            fis = new FileInputStream("C:/Users/chris/Desktop/CE25/image.jpg");
        } catch ( FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<Integer> data = new ArrayList<>();

        readFile(fis, data);

        writeFile(data);
    }

    public static void readFile(FileInputStream fis, ArrayList<Integer> data) {
        DataInputStream dis = null;
        int i = 0;
        try {
            dis = new DataInputStream(fis);
            while (dis.read() != -1) {  //true?

                data.add(dis.read());
                //System.out.println(data.get(i));
                i++;

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(fis != null) {
                    fis.close();
                }
                if (dis != null) {
                    dis.close();
                }
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void writeFile(ArrayList<Integer> data) {
        DataOutputStream dos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("C:/Users/chris/Desktop/CE25/copy.jpg");
            //fos = new FileOutputStream("/home/ALU1K/Documentos/copy.png");
            dos = new DataOutputStream(fos);

            for (int i = 0; i < data.size(); i++) {
                dos.write(data.get(i));
                //System.out.println(data.get(i));
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(fos != null) {
                    fos.close();
                }
                if (dos != null) {
                    dos.close();
                }
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


    }
} 