package encapsulationJava;
public class RunEncap {
	
	public static void main(String[] args) {
		EncapTest encap = new EncapTest();
		
		encap.setName("James");
		encap.setAge(20);
		encap.setIdNum("12343ms");

		System.out.println("Name : " + encap.getName());
		System.out.println("Age : " + encap.getAge());
		System.out.println("IdNum: " +encap.getIdNum());		
	}
}
