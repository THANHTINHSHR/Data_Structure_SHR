package giua_ki_SHR;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {
	Date test1 = new Date(15, 10, 2011);
	Date test2 = new Date(28, 2, 2012);
	Date test3 = new Date(29, 2, 2012);
	Date test4 = new Date(30, 2, 2012);
	Date test5 = new Date(29, 2, 2011);

	@Test
	void test() {
		System.out.println(test1);
//		System.out.println(test1.isLeapYear());
//		System.out.println(test1.isDate());
		System.out.println(test2);
//		System.out.println(test2.isLeapYear());
//		System.out.println(test2.isDate());
		System.out.println(test3);
//		System.out.println(test3.isLeapYear());
//		System.out.println(test3.isDate());
		System.out.println(test4);
//		System.out.println(test4.isLeapYear());
//		System.out.println(test4.isDate());
		System.out.println(test5);
//		System.out.println(test5.isLeapYear());
//		System.out.println(test5.isDate());
	}

}
