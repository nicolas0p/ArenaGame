package model;

public class Wallet {
	
	double money;
	
	public Wallet(double $$) {
		money = $$;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void addMoney(double $$) {
		money += $$;
	}
	
	public void subMoney(double $$) {
		money -= $$;
	}
}
