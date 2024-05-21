public class DinnerFullCourse {
    private Dish[] list = new Dish[5];// [0]-[4]の計5個

	DinnerFullCourse(){
		this.list[0] = new Dish();
		this.list[0].setName("特選シーザサラダ");
		this.list[0].setValune(600);

		this.list[1] = new Dish();
		this.list[1].setName("ステーキ");
		this.list[1].setValune(8000);

		this.list[2] = new Dish();
		this.list[2].setName("ハンバーガー");
		this.list[2].setValune(800);

		this.list[3] = new Dish();
		this.list[3].setName("寿司");
		this.list[3].setValune(2000);

		this.list[4] = new Dish();
		this.list[4].setName("プルーツポンチ");
		this.list[4].setValune(300);
	}

	public static void main(String[] args) {
		DinnerFullCourse fullcourse = new DinnerFullCourse();
		fullcourse.eatAll();
	}

	public void eatAll(){
		System.out.println("たかし、今日の夜ごはんは・・・");
		for(Dish menuList :list){
			System.out.println(menuList.getName() +"：" +  menuList.getValune() + "円");
		}
	}
}
