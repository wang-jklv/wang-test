package test;

import javax.swing.JPanel;

public class Map extends JPanel {
  private static final long serialVersionUID = 15111511151L;
     /**
	 * ��ͼ��С
	 */
	private int rows = 40;
	private int cols = 40;
	private double k = 0.5;

	private char[][] world = new char[rows][cols];
	private char[][] first_world = new char[rows][cols];
	private char[][] second_world = new char[rows][cols];

	/**
	 * ������ʼ����
	 * @return
	 */
	public char[][] setworld() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (Math.random() < k) {
					world[i][j] = 'd';
				} else {
					world[i][j] = 'l';
				}
			}
		}
		return world;
	}
	
	public char[][] setworld1() {
		for(int i = 0; i<8; i++)
			for(int j = 0; j<8; j++) {
				if(i == j) {
					world[i][j] = 'l';
				}
				else {
					world[i][j] = 'd';
				}
			}
		return world;
	}

	/**
	 * �����ͼ.
	 * @return
	 */
		public char[][] setworld2(){
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if (i == 0 || j == 0 || i == 7 || j == 7) {
					world[i][j] = 'l';
				} else {
					world[i][j] = 'd';
				}
			}
		}
		return world;
	}

	// ���ָ��λ����Χ�������
	public int get_neighbor_count(int rows, int cols) {
		int count = 0;
		for (int i = rows - 1; i <= rows + 1; i++) {
			for (int j = cols - 1; j <= cols + 1; j++) {
				if (i < 0 || i >= first_world.length || j < 0 || j >= first_world[rows].length) { // �����ĸ��ǻ�����������ı��ϣ���ȥ�Ĳ�����ֱ�������ж�
					continue;
				}
				if ((i == rows) && (j == cols)) { // ��Ϊ�����������ж�
					continue;
				} else {
					if (first_world[i][j] == 'l') {
						count++;
					}
				}
			}
		}
		return count;
	}

	// ������Χ����������ͬ����״̬
	public void update_cell() {
		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[0].length; j++) {
				switch (get_neighbor_count(i, j)) {
				case 0:
				case 1:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
					second_world[i][j] = 'd';
					break;
				case 2:
					second_world[i][j] = first_world[i][j];
					break;
				case 3:
					second_world[i][j] = 'l';
					break;
				}
			}
		}
		update_map();
	}

	// ����ͼ����Ϊ�µ�״̬
	public void update_map() {
		for (int i = 0; i < second_world.length; i++) {
			for (int j = 0; j < second_world[0].length; j++) {
				first_world[i][j] = second_world[i][j];
			}
		}
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public char[][] getWorld() {
		return world;
	}

	public void setWorld(char[][] world) {
		this.world = world;
	}

	public char[][] getFirst_world() {
		return first_world;
	}

	public void setFirst_world(char[][] first_world) {
		this.first_world = first_world;
	}

	public char[][] getSecond_world() {
		return second_world;
	}

	public void setSecond_world(char[][] second_world) {
		this.second_world = second_world;
	}

}
