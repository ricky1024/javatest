public class Test1 {

    public static void main(String[] args) {  
          
        //静态初始化数组：方法一  
        String cats[] = new String[] {  
                "Tom","Sam","Mimi"  
        };  
          
        //静态初始化数组：方法二  
        String dogs[] = {"Jimmy","Gougou","Doggy"};  
          
        //动态初始化数据  
        String books[] = new String[2];  
        books[0] = "Thinking in Java";  
        books[1] = "Effective Java";  
          
        System.out.println(cats.length);
        System.out.println(dogs.length);
        System.out.println(books.length);
        System.out.println(books[0]);  
    }  
}