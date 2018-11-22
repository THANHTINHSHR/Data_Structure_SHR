package giua_ki_SHR;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class ListRestaurantTest {
	static List<RestaurantSHR> listRes = new List<>();
//	static RestaurantSHR restau1 = new RestaurantSHR("tạm", 5155, "Tính", "15/22 Hồng Đức", "Cưới",
//			new Date(1, 12, 2015));

	// xóa 1 nhà hàng theo tên id
	public static void removeByID(int id) throws IndexOutOfBoundsException {
		for (int i = 0; i < listRes.getSize(); i++)
			if (listRes.getData2(i).getID() == id) {
				listRes.removeElement(listRes.getData2(i));
				break; // đảm bảo chạy 1 lần , chỉ xóa 1 phần tử thôi
			}
	}

	// xóa nhiều nhà hàng theo tên nhà hàng
	public static void removeByNameMaster(String name) throws IndexOutOfBoundsException {
		for (int i = 0; i < listRes.getSize(); i++)
			if (listRes.getData2(i).getNameMaster().equals(name))
				listRes.removeElement(listRes.getData2(i));
	}

	// xóa các nhà hàng có doanh thu nhỏ nhất
	public static void removeByMinRevenue() throws IndexOutOfBoundsException {
		for (int i = 0; i < listRes.getSize(); i++)
			if (listRes.getData2(i).getRevenue() == findMinRevenue())
				listRes.removeElement(listRes.getData2(i));
	}

	// xóa nhiều nhà hàng nếu có ngày thành lập trước ngày 1 ngày thành lập cho
	// trước
	public static void removeByDateToSetBefore(Date date) throws IndexOutOfBoundsException { // IndexOutOfBoundsException
																								// là
		// cái mống gì ?!
		for (int i = 0; i < listRes.getSize(); i++) {
			if (listRes.getData2(i).getDateToSet().dayBefore(date)) {
				listRes.removeElement(listRes.getData2(i));
			}
		}
	}

	// sắp xếp theo doanh thu
	public static void sortByRevenue() {
		listRes.sort(new Comparator<RestaurantSHR>() { // Anonymous class !
// cái Comparator này chỉ có 1 hàm duy nhất là compare , hàm compare này trả về giá trị int
			@Override
			public int compare(RestaurantSHR o1, RestaurantSHR o2) {
				return o1.getRevenue() - o2.getRevenue();
			}
		});

	}

	// sắp xếp theo doanh thu 2 - vấn đúng !
	public static void sortByRevenue2() {
		listRes.sortByRevenue2(new Comparator<RestaurantSHR>() {

			@Override
			public int compare(RestaurantSHR o1, RestaurantSHR o2) {
				return o1.getRevenue() - o2.getRevenue();
			}
		});

	}

	// sắp xếp theo tên chủ
	public static void sortByNameMaster() {
		listRes.sort(new Comparator<RestaurantSHR>() {
			@Override
			public int compare(RestaurantSHR o1, RestaurantSHR o2) {
				return o1.getNameMaster().compareToIgnoreCase(o2.getNameMaster()); // cái này và cái dưới nó có khác nhau cái gì ?
//				return o1.getNameMaster().compareTo(o2.getNameMaster());
			}
		});

	}

	// sắp xếp theo ID
	public static void sortByID() {
		listRes.sort(new Comparator<RestaurantSHR>() {

			@Override
			public int compare(RestaurantSHR o1, RestaurantSHR o2) {
				return o1.getID() - o2.getID();

			}

		});
	}

	// sắp xếp theo ID
	public static void sortByDateToSet() {
		listRes.sort(new Comparator<RestaurantSHR>() {

			@Override
			public int compare(RestaurantSHR o1, RestaurantSHR o2) {
				if (!o1.getDateToSet().dayBefore(o2.getDateToSet()))
					return 1;
				return -1;

			}

		});
	}

	// tìm kiếm nhà hàng theo ID
	// vì id chỉ duy nhất có 1 nên chỉ xuất ra 1 đối tượng
	public static RestaurantSHR findByID(int id) {
		for (int i = 0; i < listRes.getSize(); i++) {
			if (listRes.getData2(i).getID() == id)
				return listRes.getData2(i);
		}
		return null;
	}

	// tìm kiếm theo theo tên chủ cửa hàng
	// một người có thể là chủ của nhiều nhà hàng
	public static List<RestaurantSHR> findByNameMaster(String name) {
		List<RestaurantSHR> listByNameMaster = new List<>();
		for (int i = 0; i < listRes.getSize(); i++)
			if (listRes.getData2(i).getNameMaster().equals(name))
				listByNameMaster.addLast(listRes.getData2(i));
		// if (listRes.isEmpty())
		// định làm trường hợp nếu không có thì xuất ra thông báo không có dữ liệu thay
		// vì danh sách trống mà quên cách làm rồi !
		return listByNameMaster;
	}

	// tìm kiếm theo tên nhà hàng
	// một tên có thể sử dụng cho nhiều nhà hàng
	public static List<RestaurantSHR> findByNameRes(String name) {
		List<RestaurantSHR> listByName = new List<>();
		for (int i = 0; i < listRes.getSize(); i++)
			if (listRes.getData2(i).getNameRes().equals(name))
				listByName.addLast(listRes.getData2(i));
		return listByName;
	}

	// tìm kiếm theo theo địa chỉ
	// vì 1 địa chỉ chỉ có thể có 1 nhà hàng nên trả về 1 cái Restaurant
	// [ SAU NÀY MÌNH LÀM CÁI ĐỊA CHỈ DẠNG CONTAINER CHO NÓ MỞ RỘNG THÊM ]
	public static RestaurantSHR findByAdress(String adress) {
		for (int i = 0; i < listRes.getSize(); i++)
			if (listRes.getData2(i).getAddress().equals(adress)) // CÓ DÙNG QUÁ NHIỀU GET KHÔNG ? CÓ NÊN CHUYỂN SANG
																	// DẠNG SẾP - NHÂN VIÊN ?
				return listRes.getData2(i);
		return null;
	}
	// tìm kiếm theo doanh thu CHÍNH XÁC
	public static List<RestaurantSHR> findByRevenue(int revenue) {
		List<RestaurantSHR> listByName = new List<>();
		for (int i = 0; i < listRes.getSize(); i++)
			if (listRes.getData2(i).getRevenue() == revenue)
				listByName.addLast(listRes.getData2(i));
		return listByName;
	}

	// tìm doanh thu lớn nhất
	public static int findMaxRevenue() {
		int maxRevenue = listRes.getData2(0).getRevenue();
		for (int i = 1; i < listRes.getSize(); i++)
			if (listRes.getData2(i).getRevenue() > maxRevenue)
				maxRevenue = listRes.getData2(i).getRevenue();
		return maxRevenue;
	}

	// tìm doanh thu nhỏ nhất
	public static int findMinRevenue() {
		int minRevenue = listRes.getData2(0).getRevenue();
		for (int i = 1; i < listRes.getSize(); i++)
			if (listRes.getData2(i).getRevenue() < minRevenue)
				minRevenue = listRes.getData2(i).getRevenue();
		return minRevenue;
	}

	// tìm kiếm thằng Restaurant có doanh thu lớn nhất
	// có thể có đồng hạng nên là danh sách - List !
	public static List<RestaurantSHR> findRestaurantMaxRevenue() {
		List<RestaurantSHR> listRestaurantMaxRevenue = new List<>();
		for (int i = 1; i < listRes.getSize(); i++)
			if (listRes.getData2(i).getRevenue() == findMaxRevenue())
				listRestaurantMaxRevenue.addLast(listRes.getData2(i));
		return listRestaurantMaxRevenue;
	}

	// tìm kiếm thằng Restaurant có doanh thu lớn nhất
	public static List<RestaurantSHR> findRestaurantMinRevenue() {
		List<RestaurantSHR> listRestaurantMinRevenue = new List<>();
		for (int i = 1; i < listRes.getSize(); i++)
			if (listRes.getData2(i).getRevenue() == findMinRevenue())
				listRestaurantMinRevenue.addLast(listRes.getData2(i));
		return listRestaurantMinRevenue;
	}

	// sửa - đổi chủ của 1 nhà hàng có ID này bằng 1 chủ mới -> 1 đối tượng bị thay
	// đổi
	public static void changeNameMasterbyID(int id, String nameMaster) {
		for (int i = 0; i < listRes.getSize(); i++)
			if (listRes.getData2(i).getID() == id) {
				listRes.getData2(i).setNameMaster(nameMaster);
				break;
			}
	}

	// sửa - loại nhà hàng của nhà hàng này thành 1 loại mới -> 1 đối tượng bị thay
	// đổi
	public static void changeKindResbyID(int id, String kindRes) {
		for (int i = 0; i < listRes.getSize(); i++)
			if (listRes.getData2(i).getID() == id) {
				listRes.getData2(i).setKindRes(kindRes);
				break;
			}
	}

	// sửa - tên nhà hàng của nhà hàng này thành 1 tên mới -> 1 đối tượng bị thay
	// đổi
	public static void changeNameResbyID(int id, String nameRes) {
		for (int i = 0; i < listRes.getSize(); i++)
			if (listRes.getData2(i).getID() == id) {
				listRes.getData2(i).setNameRes(nameRes);
				break;
			}
	}

	// sửa - đổi quyền sử hữu (chủ) của người này sang người khác ->toàn bộ danh
	// sách bị thay đổi
	public static void changeOwnership(String oldOwner, String newOwner) {
		for (int i = 0; i < listRes.getSize(); i++)
			if (listRes.getData2(i).getNameMaster().equals(oldOwner))
				listRes.getData2(i).setNameMaster(newOwner);
	}
	// xuất ra tổng doanh thu trong danh sách 
	public static int exportSumRevenue() {
		int sum = 0 ;
		for (int i = 0; i < listRes.getSize(); i++)
			sum +=listRes.getData2(i).getRevenue() ;
		return sum; 
			
	}

	public static void main(String[] args) {
		RestaurantSHR res1 = new RestaurantSHR(" Mùa Thu Vàng ", 15000000, " Nguyễn Thanh Tính ", " 27/48 Bình Định ",
				" Quán bia ", new Date(14, 6, 2009));
		RestaurantSHR res2 = new RestaurantSHR(" Mùa Đông Trắng ", 16000000, " Nguyễn Huy Cường ", " 35/24 Đà Nẵng ",
				" Quán nhậu ", new Date(14, 6, 2015));
		RestaurantSHR res3 = new RestaurantSHR(" Mùa Xuân Tím", 17000000, " Hồ Gia Hưng ", " 14/12/35 Nha Trang ",
				" Nhà Hàng Cưới ", new Date(9, 6, 2000));
		RestaurantSHR res4 = new RestaurantSHR(" Mùa Hạ Đỏ ", 17000000, " Ân Ngọc Bảo ", " 27/48 Bình Định ",
				" Quán Nướng ", new Date(20, 6, 2010));
		RestaurantSHR res5 = new RestaurantSHR(" Chó Nâu ", 20000000, " Nguyễn Thiện Tâm ", " 30/50 Gia Lai ",
				" Quán Nướng ", new Date(20, 6, 2004));
		RestaurantSHR res6 = new RestaurantSHR(" Sóc Vàng ", 10000000, " Hồ Khải Huy ", " 45/17/120 Quảng Ngãi ",
				" Quán Nướng ", new Date(20, 6, 2015));
		RestaurantSHR res7 = new RestaurantSHR(" Chó Nâu ", 13000000, " Nguyễn Thanh Tính ", " 72/08 Bình Định ",
				" Quán Nướng ", new Date(20, 7, 2009));
		// ADD
		listRes.addLast(res1);
		listRes.addLast(res2);
		listRes.addLast(res3);
		listRes.addLast(res4);
		listRes.addLast(res5);
		listRes.addLast(res6);
		listRes.add(2, res7);
		// REMOVE
		System.out.println("DANH SÁCH GỐC  : ------------- \n" + listRes);
		removeByNameMaster(" Nguyễn Huy Cường "); // ok
		System.out.println("Remove by name master :   Nguyễn Huy Cường ----------- \n" + listRes);
		listRes.addLast(res2);// add lại
		removeByDateToSetBefore(new Date(15, 6, 2009)); // ok
		System.out.println("remove by date to set before : 15/ 6/ 2009  ----------- \n" + listRes);

//		sortByRevenue2(); // ok
		// SORT
		sortByNameMaster();
		System.out.println("sort by name master : ----------- \n" + listRes);
		sortByRevenue(); // ok
		System.out.println("sort by revenue : ----------- \n" + listRes);
		sortByID();
		System.out.println("sort by ID : -----------  \n" + listRes);
		sortByNameMaster();
		System.out.println("sort by name master : ----------- \n" + listRes);
		sortByDateToSet();
		System.out.println("sort dy date to set : ----------- \n" + listRes);
		// FIND
		System.out.println("DANH SÁCH MỚI  : ------------- \n" + listRes);
		System.out.println(
				"find by name master Nguyễn Thanh Tính : ----------- \n" + findByNameMaster(" Nguyễn Thanh Tính "));
		System.out.println("find by name rest Sóc Vàng : ----------- \n" + findByNameRes(" Sóc Vàng "));
		System.out.println("find by adress 27/48 Bình Định : ----------- \n" + findByAdress(" 27/48 Bình Định "));
		System.out.println("find by revenue 17000000 : ----------- \n" + findByRevenue(17000000));
		System.out.println("find  max revenue : ----------- \n" + findMaxRevenue());
		System.out.println("find  min revenue : ----------- \n" + findMinRevenue());
		System.out.println("find rest max revenue : ----------- \n" + findRestaurantMaxRevenue());
		System.out.println("find rest min revenue : ----------- \n" + findRestaurantMinRevenue());
		// FIX -CHANGE
		System.out.println("DANH SÁCH MỚI  : ------------- \n" + listRes);
		changeNameMasterbyID(4, " Trần Bảo Điền ");
		System.out.println("change name master by ID ----- ID 4 - name  Trần Bảo Điền \n" + listRes);
		changeKindResbyID(4, " nhà hàng hải sản nướng ");
		System.out.println("change kind res by ID ----- ID 4 - kind nhà hàng hải sản nướng \n" + listRes);
		changeNameResbyID(7, " Ăn nữa , ăn mãi ");
		System.out.println(" change name Res by ID ---- ID 7 - name  Ăn nữa , ăn mãi \n" + listRes);
		changeOwnership(" Nguyễn Thanh Tính ", " Hồ Nhật Tín ");
		System.out.println(" change ownership -- old owner Nguyễn Thanh Tính  new owner Hồ Nhật Tín \n" + listRes);
		System.out.println(exportSumRevenue());

	}

}
