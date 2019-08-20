
class FruitBox <T> {
	T item;
	public FruitBox(T item) {
		this.item = item;
	}
	public void store(T item) {
		this.item = item;
	}
	public T pullOut() {
		return item;
	}
}

class Orange {
	int sugar;
	public Orange(int sugar) {
		this.sugar = sugar;
	}
	public void showSugarContent() {
		System.out.println("당도 : " + sugar);
	}
}

class Apple {
	int weight;
	public Apple(int weight) {
		this.weight = weight;
	}
	public void showWeightContent() {
		System.out.println("무게 : " + weight);
	}
}
public class Generics_Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FruitBox<Orange> orBox = new FruitBox<Orange>(new Orange(10));
		Orange org = orBox.pullOut();
		org.showSugarContent();
		
		FruitBox<Apple> apBox = new FruitBox<Apple>(new Apple(200));
		apBox.store(new Apple(200));
		Apple apl = apBox.pullOut();
		apl.showWeightContent();
	}

}
