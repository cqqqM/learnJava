package IO.进阶;

import java.io.*;

/**
 * 文件夹复制
 *
 */
public class CopyFolderDemo {
    public static void main(String[] args) throws IOException {
        copyFolder();
        copyFolders();
    }



    /**
     * 复制单级文件夹
     */
    private static void copyFolder() throws IOException {
        //创建源目录File对象，获取源目录名
        File srcFolder = new File("D:\\files\\2019-2020\\车架OCR");
        String srcFolderName = srcFolder.getName();

        //创建目的地目录File对象：目的path + 源目录名
        File dstFolder = new File("myArray",srcFolderName);

        //目的地目录是否存在
        if(!dstFolder.exists()){
            dstFolder.mkdir();
        }

        //源目录下的所有文件的File数组
        File[] listFiles = srcFolder.listFiles();

        for(File srcFile : listFiles) {
            //获取源文件名
            String srcFileName = srcFile.getName();

            //创建目的File对象：目的path + 源文件名
            File dstFile = new File(dstFolder,srcFileName);
            dstFile.createNewFile();

            //复制文件
            copyFile(srcFile,dstFile);
        }
    }

    /**
     * 复制多级文件夹
     */
    private static void copyFolders() throws IOException {
        File srcFile = new File("D:\\files\\2019-2020\\地铁客流预测");
        File dstFile = new File("myArray");
        copyFoldersRecursion(srcFile, dstFile);
    }

    /**
     * 递归复制多级文件夹
     */
    private static void copyFoldersRecursion(File srcFile, File dstFile) throws IOException {
        //判断数据源File是否是目录：如果是目录，遍历目录并递归复制；如果是文件，直接复制文件
        if(srcFile.isDirectory()) { //对文件夹的处理
            String srcFileName = srcFile.getName();
            //创建目的地file对象
            File newFolder = new File(dstFile,srcFileName);
            if(!newFolder.exists()) {
                newFolder.mkdir();
            }
            //获取源目录下所有文件的File数组
            File[] fileArray = srcFile.listFiles();
            //遍历得到每一个File对象
            for(File file : fileArray) {
                copyFoldersRecursion(file,newFolder);
            }
        } else { //对文件的处理
            //创建目的文件File对象：目的path + 源文件名
            File newFile = new File(dstFile,srcFile.getName());
            copyFile(srcFile,newFile);
        }
    }


    /**
     * 复制功能使用字节缓冲流实现
     */
    private static void copyFile(File srcFile, File dstFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dstFile));

        byte[] bys = new byte[1024];
        int len;
        while((len=bis.read(bys)) != -1) {
            bos.write(bys,0,len);
        }
        bos.close();
        bis.close();
    }
}
