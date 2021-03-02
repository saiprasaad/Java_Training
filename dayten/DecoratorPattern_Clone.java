package dayten;

public class DecoratorPattern_Clone {
	public static void main(String[] args) throws CloneNotSupportedException {

		
//		Icecream icecreamobj=new ChocoChips(new Vanilla(new ButterScotch(new Gems(new Vanilla()))));
//		System.out.println(icecreamobj);
		Vanilla vanillaobj=new Vanilla();
		ButterScotch butterscotchobj=new ButterScotch();

		Icecream icecreamobj=new Vanilla(butterscotchobj.getClone());
		System.out.println("Total cost of Icecream is "+icecreamobj.cost());
	}
}
abstract class Icecream{
	public abstract int cost();}
abstract class Cream extends Icecream{};
abstract class IceCreamIngredients extends Icecream{};

class Vanilla extends Icecream implements Cloneable
{
	Icecream icecream; 
	public Vanilla() {
		System.out.println(this.icecream);
		// TODO Auto-generated constructor stub
	}
	public Vanilla(Icecream icecream) {
		this.icecream=icecream;
		System.out.println(this.icecream);
	}
	@Override
	public int cost() {
		if(this.icecream==null)
			return 10;
		else
			return 10+this.icecream.cost();
	}
	public Vanilla getClone() throws CloneNotSupportedException
	{
		return (Vanilla) super.clone();
	}
}
class ButterScotch extends Icecream implements Cloneable
{
	Icecream icecream;
	public ButterScotch() {
		// TODO Auto-generated constructor stub
	}
	public ButterScotch(Icecream icecream) {
		this.icecream=icecream;
		System.out.println(this.icecream);
	}
	@Override
	public int cost() {
		if(this.icecream==null)
			return 15;
		else
			return 15+this.icecream.cost();
	}
	public ButterScotch getClone() throws CloneNotSupportedException
	{
		return (ButterScotch) super.clone();
	}
}
class ChocoChips extends IceCreamIngredients
{
	Icecream icecream;
	public ChocoChips() {
		// TODO Auto-generated constructor stub
	}
	public ChocoChips(Icecream icecream) {
		this.icecream=icecream;
		System.out.println(this.icecream);
	}
	@Override
	public int cost() {
		return 5+this.icecream.cost();
	}
}
class Gems extends IceCreamIngredients
{
	Icecream icecream;
	public Gems() {
		// TODO Auto-generated constructor stub
	}
	public Gems(Icecream icecream) {
		this.icecream=icecream;
		System.out.println(this.icecream);
	}
	@Override
	public int cost() {
		return 10+this.icecream.cost();
	}
}