package Day5LabBook;

class Program33_Background implements Runnable{
int i=0;
public void run(){ // if return type is int throws error as it has to implement callable for run() with return type
while(true){
i++;
System.out.println("i="+i);
} //End while
//return 1;
}//End run
}//End class
