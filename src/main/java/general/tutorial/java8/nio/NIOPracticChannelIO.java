package general.tutorial.java8.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;

@Slf4j
public class NIOPracticChannelIO {


    /**
     * Сначалоа создается обхект типа Path, , содержащий относительный путь к файлу test.txt
     * Затем для создания канала, свазанного с файлом , вызывается метод newByteChannel(),
     * которому пердается ссылка на файл filepath. А поскольку никаких параметров открытия
     * файла не указано, то файл по умолчанию открывается для чтения. Далее вызывается метод
     * allocate() чтобы выделить оперативную память под буфер для зранения содержимого файла
     * во время чтения.
     *
     * @param args
     */

    public static void main(String[] args) {
        int count ;
        Path filepath = null;

        try ( SeekableByteChannel fChan = Files.newByteChannel(Paths.get("test.txt"))) {
            ByteBuffer mBuf = ByteBuffer.allocate(128);

            do {
                count = fChan.read(mBuf);

                if(count != -1) {

                    mBuf.rewind();

                    byte[] array = mBuf.array();
                    System.out.println(Arrays.toString(array));
                }
            } while (count != -1);

            System.out.println();

        } catch (IOException e) {
            System.out.println("Error  I/O " + e);
        }
    }


    /**
     * Другой способ чтения файла подразумевает его сопоставление с буфером. Преимущество такого способа состоит в том,
     * что буфер автоматически получает содержимое файла. Сначала получается объект типа Path, инкапсулирующий файл.
     * Затем получается канал к этому файлу. С этой целью вызывается метод Files.newByteChannel(), которому передается
     * объект Path.
     */
    public static void otherWay() {
        try (FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test.txt"))) {
            long fSize = fChan.size();

            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

            byte[] array = mBuf.array();
            System.out.println("Array = " + Arrays.toString(array));
        } catch (IOException e) {
            System.out.println("Error I/O");
        }
    }


    /**
     * Вызов метода rewind() требуется для обнуления текущей позиции после записи данных в буфер mBuf.
     * Не следует забывать , что после метода put() для буфера текущая позиция смещается. Если этого не сделать
     * , то метод write() не обнаружит никаких данных , посчитав, что их там нет.
     */
    public static void writeToFile() {
        try (FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test.txt"),
                                                                    StandardOpenOption.WRITE,
                                                                    StandardOpenOption.CREATE)) {
            ByteBuffer mBuf = ByteBuffer.allocate(26);

            mBuf.put("Hello world from file".getBytes(Charset.forName("US-ASCII")));
            // подготовить к записи буфер
            mBuf.rewind();

            fChan.write(mBuf);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Еще один спсоб записи данных в файл подразумевает его сопоставление с буфером. Преимущество такого подхода
     * заключается в том, что занесенные в буфер данные будут автоматически записаны в файл.
     */
    public static void otheWriteToFile() {
        try (FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test.txt"),
                StandardOpenOption.WRITE,
                StandardOpenOption.READ,
                StandardOpenOption.CREATE)) {

            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);

            byte[] array = mBuf.array();

            System.out.println("Array = " + Arrays.toString(array));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
