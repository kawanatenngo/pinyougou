package demo;

import org.csource.fastdfs.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class FastDFSdemo {
    public static void main(String[] args) throws Exception {
        // 1. 加载配置文件，配置文件中的内容就是tracker服务的地址
        ClientGlobal.init("D:\\IdeaProjects\\pinyougou\\fastDFSdemo\\src\\main\\resources\\fdfs_client.conf");
        // 2. 创建一个trackerClient对象。直接new一个。
        TrackerClient trackerClient = new TrackerClient();
        // 3. 使用trackerClient对象创建连接，获得一个trackerServer对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 4. 创建一个storageServer的引用，值为null
        StorageServer storageServer = null;
        // 5. 创建一个storageClient对象，需要两个参数trackerServer对象，storageServer的引用
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 6. 使用storageClient对象上传图片
        // 扩展名不带“.”
        String local_filename = "D:\\IdeaProjects\\pinyougou\\fastDFSdemo\\src\\main\\resources\\witchwood-expansionPage-desktop.jpg";
        File file = new File(local_filename);
        //FileInputStream fis = new FileInputStream(f);
        ByteArrayOutputStream bos=null;
        BufferedInputStream in=null;
        bos=new ByteArrayOutputStream((int)file.length());
        in=new BufferedInputStream(new FileInputStream(file));
        int buf_size=1024;
        byte[] buffer=new byte[buf_size];
        int len=0;
        while(-1 != (len=in.read(buffer,0,buf_size))){
            bos.write(buffer,0,len);
        }
        String[] strings = storageClient.upload_file(bos.toByteArray(), "jpg", null);
        // 7. 返回数组。包含组名和图片的路劲
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
