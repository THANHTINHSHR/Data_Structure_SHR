package giua_ki_SHR;

import java.util.Comparator;

public class List<E extends Comparable<E>> {

	public static final int CAPACITY = 50;// độ dài mặc định
	E[] data; // generic, E là một kiểu dữ liệu bất kỳ
	private int size = 0; // số phần tử hiện có trong danh sách

	// constructors
	public List() { // khi khởi tạo mà không định sẵn độ dài, sẽ lấy độ dài mặc định
		this(CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public List(int capacity) {
		data = (E[]) new Comparable[capacity];
	}

	public List(E[] data, int size) {
		this.data = data;
		this.size = size;
	}

	// kiểm tra danh sách rỗng
	public boolean isEmpty() {
		return size == 0;
	}

	// Kểm tra index hợp lệ
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n)
			throw new IndexOutOfBoundsException("Illegal Index : " + i);

	}

	// Chèn phần tử vào danh sách , chèn vào vị trí định sẵn
	public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
		checkIndex(i, size + 1);// kiểm tra index hợp lệ
		if (size == data.length) // danh sách đã đầy
			throw new IllegalStateException("Array is full");
		for (int k = size - 1; k >= i; k--) // dời các phần tử sang phải
			data[k + 1] = data[k];
		data[i] = e; // đặt phần tử mới vào danh sách
		size++;
	}

	// Chèn 1 phần tử vào danh sách ( nếu không nói gì thì add vào cuối mảng )
	public void addLast(E e) throws IndexOutOfBoundsException, IllegalStateException {
		add(size, e);
	}

	// Hủy phần tử khỏi danh sách _ tại vị trí i
	public void remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		for (int j = i; j < size - 1; j++) // dịch các phần tử còn lại sang trái
			data[j] = data[j + 1];

		data[size - 1] = null; // gán các phần tử cuối cùng bằng null
		size--;
	}

	// Hủy phần tử có giá trị e trong danh sách, lưu ý có thể chỉ hủy một phần tử -
	// hủy toàn bộ các phần tử có giá trị bằng e
	public void removeElement(E e) throws IndexOutOfBoundsException {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				remove(i);
			}
		}
	}

	public E[] getData() {
		return data;
	}

	public E getData2(int index) { // vì E là một kiểu dữ liệu trừu tượng nên không thể trả về 1 cái mảng E được ,
									// ta chỉ có thể trả về phần tử ở vị trí trong mảng
		return data[index];
	}

	public void setData(E[] data) {
		this.data = data;
	}

	public void setData2(int index, E dataInput) { // thử thôi :D nhưng vẫn đúng :D
		this.data[index] = dataInput;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// truy xuất mảng
	public String toString() {
		String result = "";
		for (int i = 0; i < size; i++) {
			result += data[i] + "\n";
		}
		return result;
	}

	// Tìm 1 phần tử , trả về vị trí ĐẦU TIÊN của nó
	public int findElement(E e) throws IndexOutOfBoundsException {
		int result = 0;

		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				result = i;
				break;
			}
		}
		return result;
	}

	// kiểm tra danh sách đầy
	// kiểm tra danh sách rỗng
	public boolean isFull() {
		return size == CAPACITY;
	}

	// Sắp xếp danh sách theo selection sort
	public void selectionSort() {
		int min = 0;
		E support = data[0];
		for (int i = 0; i < size; i++) {
			min = findMin(i);
			if (!data[i].equals(data[min])) {
				// hoán vị
				support = data[i];
				data[i] = data[min];
				data[min] = support;
			}

		}
		// System.out.println(toString());
	}

	public int findMin(int begin) { // tìm vị trí minIndex
		int minIndex = begin;
		for (int i = begin; i < size; i++) {
			if (data[i].compareTo(data[minIndex]) < 0) {
				minIndex = i;
				begin++;
			}
		}
		return minIndex;
	}

	public void sort(Comparator<E> comparator) {
		E support = data[0];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (comparator.compare(data[i], data[j]) <= 0) {
					// hoán vị
					support = data[i];
					data[i] = data[j];
					data[j] = support;
				}
	}
	public void sortByRevenue2(Comparator<E> comparator) {
		E support = getData2(0);
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (comparator.compare(getData2(i), getData2(j)) <= 0) {
					// hoán vị
					support = getData2(i);
					setData2(i, getData2(j));
					setData2(j, support);
				}
	}
//	public void sortByNameMaster(Comparator<E> comparator) {
//		E support = data[0];
//		for (int i = 0; i < size; i++)
//			for (int j = 0; j < size; j++)
//				if (comparator.compare(data[i], data[j]) <= 0) {
//					// hoán vị
//					support = data[i];
//					data[i] = data[j];
//					data[j] = support;
//				}
//	
//	}
//
//	public void sortByID(Comparator<E> comparator) {
//		E support = data[0];
//		for (int i = 0; i < size; i++)
//			for (int j = 0; j < size; j++)
//				if (comparator.compare(data[i], data[j]) <= 0) {
//					// hoán vị
//					support = data[i];
//					data[i] = data[j];
//					data[j] = support;
//				}
//	
//		
//	}
//
//	public void sortByDateToSet(Comparator<RestaurantSHR> comparator) {
//		// TODO Auto-generated method stub
//		
//	}

}
