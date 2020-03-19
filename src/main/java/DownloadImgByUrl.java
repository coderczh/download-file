import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Chenzh
 */
public class DownloadImgByUrl {
    private static void downloadPicture(String urlList,String path) {
        try {
            URL url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = "http://47.100.139.173:8888/group1/M00/00/01/rBEHPF432xmAIOk-AABdgNfhhRo256.jpg";
        String path="C:\\Users\\Administrator\\Desktop\\img\\pic.jpg";
        downloadPicture(url,path);
    }
}
