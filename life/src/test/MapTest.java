package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapTest {

	private Map map1 = new Map();
	private Map map2 = new Map();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Set up before calss");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Tear down after class");
	}

	@Before
	public void setUp() throws Exception {
		map1.setFirst_world(map1.setworld1());
		map2.setFirst_world(map2.setworld2());
		System.out.println("Set up");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Tear down");
	}

	@Test
	public void testGet_neighbor_count() {
		int [][] array1 = {
				{1,2,1,0,0,0,0,0},
				{2,2,2,1,0,0,0,0},
				{1,2,2,2,1,0,0,0},
				{0,1,2,2,2,1,0,0},
				{0,0,1,2,2,2,1,0},
				{0,0,0,1,2,2,2,1},
				{0,0,0,0,1,2,2,2},
				{0,0,0,0,0,1,2,1}
				};
				
		for(int i = 0; i<8; i++)
			for(int j = 0; j<8; j++) {
				System.out.print(map1.get_neighbor_count(i, j));
				assertEquals(array1[i][j], map1.get_neighbor_count(i,j));
			}
		
		int [][]array2= {
				{2,3,2,2,2,2,3,2},
				{3,5,3,3,3,3,5,3},
				{2,3,0,0,0,0,3,2},
				{2,3,0,0,0,0,3,2},
				{2,3,0,0,0,0,3,2},
				{2,3,0,0,0,0,3,2},
				{3,5,3,3,3,3,5,3},
				{2,3,2,2,2,2,3,2}
				};
		
		for(int i = 0; i<8; i++)
			for(int j = 0; j<8; j++) {
				System.out.print(map2.get_neighbor_count(i, j));
				assertEquals(array2[i][j], map2.get_neighbor_count(i,j));
			}
	}

	@Test
	public void testUpdate_cell() {
		map1.update_cell();
		char [][] array1 = new char[8][8];
		for (int i = 0; i<8; i++)
			for (int j = 0; j<8; j++) {
				if(i == j) {
					array1[i][j] = 'l';
				}
				else {
					array1[i][j] = 'd';
				}
			}
		array1[0][0] = 'd';
		array1[7][7] = 'd';
		for(int i = 0; i<8; i++)
			for(int j = 0; j<8; j++) {
				assertEquals(array1[i][j], map1.getSecond_world()[i][j]);
			}

		map2.update_cell();
		char [][] array2 = new char[8][8];
		for(int i = 0;i<8;i++) {
			for(int j = 0;j<8;j++) {
				if(i==0 || j==0 || i==7 || j==7) {
					array2[i][j] = 'l';
				}
				else if((i==1 || i==6)&&((j!=1)&&(j!=6))){
					array2[i][j] = 'l';
				}
				else if((j==1 || j==6)&&((i!=1)&&(i!=6))){
					array2[i][j] = 'l';
				}
				else {
					array2[i][j] = 'd';
				}
			}
		}
		for(int i = 0; i<8; i++)
			for(int j = 0; j<8; j++) {
				assertEquals(array2[i][j], map2.getSecond_world()[i][j]);
			}
	}

}
