package giua_ki_SHR;

public class RestaurantSHR implements Comparable<RestaurantSHR> {
	private static int currentId = 0;

	private int id;
	private String nameRes; // tên nhà hàng
	private int revenue; // doanh thu
	private String nameMaster; // tên chủ nhà hàng
	private String address; // địa chỉ
	private String kindRes; // loại nhà hàng
	private Date dateToSet; // ngày thành lập

	private static int getNewId() {
		return currentId++;
	}

	public RestaurantSHR(String nameRes, int revenue, String nameMaster, String address, String kindRes,
			Date dateToSet) {
		id = getNewId();
		this.nameRes = nameRes;
		this.revenue = revenue;
		this.nameMaster = nameMaster;
		this.address = address;
		this.kindRes = kindRes;
		this.dateToSet = dateToSet;
	}

	@Override
	public String toString() {
		return "Restaurant : " + "ID :" + id + "\n" + nameRes + ", thu nhập : " + revenue + " , chủ :" + nameMaster
				+ " \n địa chỉ :" + address + ", loại nhà hàng : " + kindRes + ", ngày thành lập :" + dateToSet
				+ "\n";
	}

	@Override
	public int compareTo(RestaurantSHR that) {
		if (this.revenue > that.revenue)
			return 1;
		if (this.revenue == that.revenue)
			return 0;
		return -1;
	}

	public int getID() {
		return id;
	}

	public String getNameRes() {
		return nameRes;
	}

	public void setNameRes(String nameRes) {
		this.nameRes = nameRes;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public String getNameMaster() {
		return nameMaster;
	}

	public void setNameMaster(String nameMaster) {
		this.nameMaster = nameMaster;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getKindRes() {
		return kindRes;
	}

	public void setKindRes(String kindRes) {
		this.kindRes = kindRes;
	}

	public Date getDateToSet() {
		return dateToSet;
	}

	public void setDateToSet(Date dateToSet) {
		this.dateToSet = dateToSet;
	}

}
