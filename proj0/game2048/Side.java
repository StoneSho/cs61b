package game2048;
/** 棋盘四个方向的符号名称。
 *  作者: P. N. Hilfinger */
public enum Side {
    /** 对于下面每个符号方向 D 来说，参数 (COL0, ROW0, DCOL 和 DROW)
     *  解释如下：
     *     棋盘的标准方向是顶部朝北，行和列（见 Model 类）是从
     *     棋盘的左下角编号的。假设棋盘按方向 D 排列，D 方向
     *     是最远离你的方向。则：
     *        * (COL0*s, ROW0*s) 是重新排列棋盘后左下角的标准坐标
     *          （s 是棋盘大小），并且
     *        * 如果 (c, r) 是重新排列棋盘上某一方块的标准坐标，
     *          则 (c+DCOL, r+DROW) 是重新排列后紧接其上的方块
     *          的标准坐标。
     *  采用这种方法的目的是，通过使用下面的 col() 和 row() 方法
     *  从重新排列后的坐标转换到标准坐标，可以使用相同的代码来计算
     *  任意方向上的棋盘倾斜结果。 */

    NORTH(0, 0, 0, 1), EAST(0, 1, 1, 0), SOUTH(1, 1, 0, -1),
    WEST(1, 0, -1, 0);

    /** 该方向 (DCOL, DROW) 表示从棋盘上任意方块移动一格时，
     *  行数增加 DROW，列数增加 DCOL。（COL0, ROW0）表示
     *  面朝该方向时，左下角方块的行列位置。 */
    Side(int col0, int row0, int dcol, int drow) {
        this.row0 = row0;
        this.col0 = col0;
        this.drow = drow;
        this.dcol = dcol;
    }

    /** 返回与 S 方向相反的方向。 */
    static Side opposite(Side s) {
        if (s == NORTH) {
            return SOUTH;
        } else if (s == SOUTH) {
            return NORTH;
        } else if (s == EAST) {
            return WEST;
        } else {
            return EAST;
        }
    }

    /** 返回棋盘大小为 SIZE、当前 Side 顶部的棋盘中 (C, R) 方块的
     *  标准列号。 */
    public int col(int c, int r, int size) {
        return col0 * (size - 1) + c * drow + r * dcol;
    }

    /** 返回棋盘大小为 SIZE、当前 Side 顶部的棋盘中 (C, R) 方块的
     *  标准行号。 */
    public int row(int c, int r, int size) {
        return row0 * (size - 1) - c * dcol + r * drow;
    }

    /** 描述此方向的参数，具体如本类开头的注释中所述。 */
    private int row0, col0, drow, dcol;
};
