package Day5LabBook;
	class BaseClassOver{
		private void amethod(int iBase){
		System.out.println("Base.amethod");
		}
		}
		class Program59_Over extends BaseClassOver{
		public static void main(String argv[]){
		Program59_Over o = new Program59_Over();
		int iBase=0;
		o.amethod(iBase);
		}
		public void amethod(int iOver){
		System.out.println("Over.amethod"); // prints this line Over.amethod as object of Program59_Over is created and is used
		}
}
