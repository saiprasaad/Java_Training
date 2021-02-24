package day7;

public class BuildDemo {
	public static void main(String[] args) {
		Computer c1=new Computer.ComputerBuilder("1TB","16GB").Build();
		System.out.println(c1);
		Computer c2=new Computer.ComputerBuilder("1TB","8GB").setBluetooth("Bluetooth v5").setGraphicCard("NVIDIA GForce").Build();
		System.out.println(c2);
		System.out.println(new Computer.ComputerBuilder("","").setBluetooth("hi"));
		System.out.println(new Computer.ComputerBuilder("","").setGraphicCard("hi"));
	}
}

class Computer
{
	//fixed
	private String HDD; 
	private String RAM;
	
	//optional
	private String graphicCard;
	private String bluetooth;
	
	
	
	@Override
	public String toString() {
		return "Computer [HDD=" + HDD + ", RAM=" + RAM + ", graphicCard=" + graphicCard + ", bluetooth=" + bluetooth
				+ "]";
	}
	public final String getHDD() {
		return HDD;
	}
	public final void setHDD(String hDD) {
		HDD = hDD;
	}
	public final String getRAM() {
		return RAM;
	}
	public final void setRAM(String rAM) {
		RAM = rAM;
	}
	public final String getGraphicCard() {
		return graphicCard;
	}
	public final void setGraphicCard(String graphicCard) {
		this.graphicCard = graphicCard;
	}
	public final String getBluetooth() {
		return bluetooth;
	}
	public final void setBluetooth(String bluetooth) {
		this.bluetooth = bluetooth;
	
	}
	public Computer(ComputerBuilder builder) {
		this.RAM=builder.RAM;
		this.HDD=builder.HDD;
		this.bluetooth=builder.getBluetooth();
		this.graphicCard=builder.getGraphicCard();
	}
	public static class ComputerBuilder
	{
		//fixed
		private String HDD; 
		private String RAM;
		
		//optional
		private String graphicCard;
		private String bluetooth;
		
		public ComputerBuilder(String HDD,String RAM) {
			this.HDD=HDD;
			this.RAM=RAM;
		}
		public Computer Build()
		{
			return new Computer(this);
		}
		public final String getGraphicCard() {
			return graphicCard;
		}
		public ComputerBuilder setGraphicCard(String graphicCard) {
			this.graphicCard = graphicCard;
			return this;
		}
		public final String getBluetooth() {
			return bluetooth;
		}
		public ComputerBuilder setBluetooth(String bluetooth) {
			this.bluetooth = bluetooth;
			return this;
		}
		
	}
}