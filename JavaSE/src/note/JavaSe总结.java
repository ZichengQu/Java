public static 包装类 valueOf(相应基本数据类型);
int 包装类对象.intValue();
static int Integer.parseInt(String);

String:
public char charAt(int index);
public int compareTo(String str);
public String(byte[] bytes, int offset, int length);
public String(char[] value, int offset, int count);
public boolean endsWith(String suffix);
public int indexOf(int ch);
public int indexOf(int ch, int fromIndex);
public int indexOf(String str);
public int indexOf(String str, int fromIndex);
public int lastIndexOf(int ch) 
public boolean isEmpty();
public String substring(int beginIndex);
public String substring(int beginIndex, int endIndex);
public char[] toCharArray();
length();
toLowerCase();
toUpperCase();
Arrays.toString(arr);
Arrays.sort(arr);
Arrays.copyOf(int[] original, int newLength);

正则：
[]-------表示一个位置，如果该位置上只有一种可能，可以忽略不写
()-------表示一个组合（至少是两位，并且是连续的）
{}-------用来定义字符串长度的范围
public String[] split(regex);
public boolean matches(regex);

StringBuffer/StringBuilder：
append(Object obj);
insert(int index, Object obj);
delete(int beginIndex, int endIndex);
deleteCharAt(int index);

Collection:
boolean add(Object obj);
void add(int index, Object obj);
int size();
void clear();
boolean isEmpty();
boolean contains(Object o);
E get(int index);
E set(int index, E element);
E remove(int index);
boolean remove(Object obj);
void addFirst(E e); //only used in LinkedList
void addLast(E e); //only used in LinkedList
public static List Arrays.asList(Array arr);
list.toArray(arr);
Collections.sort(list);

Map:
V put(K k, V v);
Set<K> keySet();
int size();
V remove(K k);
boolean remove(K k, V v);
public boolean containsKey(Object key);
public boolean containsValue(Object value);
V get(Object key);
boolean isEmpty();
public void clear();

Iterator;
Iterator it = list/set.iterator();
boolean hasNext();
E next();

File:
public static String separator;
public boolean createNewFile() throws IOException;
public boolean mkdir()/mkdirs();//创建由此抽象路径名命名的目录。//创建由此抽象路径名命名的目录，包括任何必需但不存在的父目录。
public boolean delete();
public File getAbsoluteFile();
public String getAbsolutePath();
public String getName();
public int compareTo(File f);
public long length();//获取文件中符号的个数,返回由此抽象路径名表示的文件的长度。
public File[] listFiles();//返回一个抽象路径名数组，表示由该抽象路径名表示的目录中的文件。
public String[] list();//返回一个字符串数组，命名由此抽象路径名表示的目录中的文件和目录。
public boolean exists();
public boolean isAbsolute();
public boolean isDirectory();
public boolean isFile();
public boolean isHidden();

Reader：//字符
	FileReader: 	public int read(), 
					public int read(char[] buf)
	BufferedReader: public int read(), 
					public int read(char[] buf, int off, int len), 
					String readLine()
Writer: //字符
	FileWriter: 	public void write(char[] buf), 
					public void write(char[] buf, int beginIndex, int len), 
					public void write(String str), 
					public void write(String str, int beginIndex, int len)
	BufferedWriter: public void write(int ch), 
					public void write(char[] buf, int off, int len), 
					public void write(String str, int off, int len), 
					public void newLine()
InputStream: //字节
	FileInputStream:  	 public int read(), 
						 public int read(byte[] buf), 
						 public int read(byte[] buf,int beginIndex,int len)
	BufferedInputStream: public int read(), 
						 public int read(byte[] buf,int beginIndex,int len)
OutputStream: //字节
	FileOutputStream: 	  public void write(int b), 
						  public void write(byte[] buf), 
						  public void write(byte[] buf,int beginIndex,int len)
	BufferedOutputStream: public void write(int b), 
						  public void write(byte[] buf,int beginIndex,int len)
InputStreamReader/OutputStreamWriter //转换流

for(int i=1;i<arr.length;i++){//冒泡算法
    for(int j=1;j<arr.length-i;j++){
    //交换位置
}

折半查找：查找指定元素在数组中的位置，如果不存在返回-1
		public static int zheBan(int[] ar,int num){			
			int begin=0;//查找起始位置			
			int end=ar.length-1;//查找结束位置
			/* 1.如果结束位置小于起始位置，这样的数组不存在
			 * 2.如果结束位置大于起始位置，数组中有多个元素
			 * 3.如果结束位置等于起始位置，数组中只有一个元素
			 * */
			while(begin<=end){				
				int middle=(begin+end)/2;//中间位置
				if(num==ar[middle]){
					return middle;
				}else if(num>ar[middle]){
					begin=middle+1;
				}else{
					end=middle-1;
				}
			}
			return -1;
	    }

线程:
	public class ThreadDemo {
		public static void main(String[] args) {
			/*启动线程要指定start方法，而不是run方法。
			run方法是线程要执行的任务，当线程的start方法调用后，进入runnable状态，一旦获取cpu时间，run方法会自动调用。*/
			//方法一
			Thread t1 = new MyThread1();
			Thread t2 = new MyThread2();
			t1.start();
			t2.start();//也可能是t2先进入running，t1一定先进入runnable状态。
			//方法二
			Runnable r3 = new MyRunnable1();
			Runnable r4 = new MyRunnable2();
			Thread t3 = new Thread(r3);
			Thread t4 = new Thread(r4);
			t3.start();
			t4.start();
			//方法三
			Thread t5 = new Thread() {
				public void run() {
					for(int i=0;i<1000;i++) {
						System.out.println("MyThread5");
					}
				}
			};
			t5.start();
			//方法四
			Runnable r6 = new Runnable() {
				public void run() {
					for(int i=0;i<1000;i++) {
						System.out.println("MyRunnable6");
					}
				}
			};
			Thread t6 = new Thread(r6);
			t6.start();
		}
	}
	public class MyThread1 extends Thread{//也可以是ThreadDemo的内部类
		public void run() {
			for(int i=0;i<1000;i++) {
				System.out.println("MyThread1");
			}
		}
	}
	public class MyThread2 extends Thread{
		public void run() {
			for(int i=0;i<1000;i++) {
				System.out.println("MyThread2");
			}
		}
	}
	public class MyRunnable1 implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<1000;i++) {
				System.out.println("MyRunnable1");
			}		
		}
	}
	public class MyRunnable2 implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<1000;i++) {
				System.out.println("MyRunnable2");
			}	
		}
	}
