public class DLL_Main12 {
    public static void main(String[] args) throws Exception {
        
        DoubleLinkedLists12 dll = new DoubleLinkedLists12();
        dll.print();

        System.out.println("\nSize : " + dll.size());
        System.out.println("=============================================");
        dll.addFirst(3);
        dll.addLast(4);
        dll.addFirst(7);
        dll.print();
        
        System.out.println("\nSize : " + dll.size());
        System.out.println("=============================================");
        dll.add(40, 1);
        dll.print();

        System.out.println("\nSize : " + dll.size());
        System.out.println("=============================================");
        dll.clear();
        dll.print();
        System.out.println("\nSize : " +dll.size());
    }
}
