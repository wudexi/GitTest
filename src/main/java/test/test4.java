package test;

public class test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
            System.out.println("in main");
            throw new Exception("Exception is thrown in main");
                    //System.exit(0);
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }finally{
            System.out.println("in finally");
        }
	}

}
