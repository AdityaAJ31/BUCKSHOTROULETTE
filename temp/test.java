package temp;
class test{
    public static int bool_to_int(boolean a){
        if (a)
            return 1;
        return 0;
    }
    public static void main(String[] args) {
        int arr[] = {3,4};
        System.out.println(arr[bool_to_int(true)]);
    }
}