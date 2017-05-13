import java.util.Arrays;

public class BowlingGame {
    public int getBowlingScore(String bowlingCode) {
        char[] bowling = bowlingCode.toCharArray();
        char[][] bowlingC = new char[11][2];
        int len = bowling.length;
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 2; j++)
                bowlingC[i][j] = '0';
        }
        int row = 0;
        for(int i = 0; i < len; i++){
            if(bowling[i] == '|') continue;
            if(bowling[i] == 'X') {
                bowlingC[row][0] = 'X';
                if(row != 10) row++;
                if(row == 10){
                    bowlingC[row][1] = bowling[i];
                }
            }
            else {
                if(row != 10) {
                    bowlingC[row][0] = bowling[i++];
                    bowlingC[row++][1] = bowling[i];
                }
                else{
                    if(i < len)
                        bowlingC[row][0] = bowling[i++];
                    if(i < len)
                        bowlingC[row][1] = bowling[i];
                }

            }
        }
        int rst = 0;
        for(int i = 0; i < 10; i++){
            if(bowlingC[i][0] == 'X'){//计算后一个frame的所有
                rst += 10;

                if(bowlingC[i+1][0] == 'X') {
                    rst += 10;
                    if(i == 9){
                        if(bowlingC[i+1][1] == 'X'){
                            rst += 10;
                        }

                        else
                            if(bowlingC[i+1][1] != '-')
                                rst += bowlingC[i+1][1] - '0';
                    }else{
                        if(bowlingC[i+2][0] == 'X')
                            rst += 10;
                        else if(bowlingC[i+2][0] != '-')
                            rst += bowlingC[i+2][0] - '0';
                    }
                } else
                if(bowlingC[i+1][1] == '/')
                    rst += 10;
                else{
                    if(bowlingC[i+1][0] != '-')
                        rst += bowlingC[i+1][0] - '0';
                    if(bowlingC[i+1][1] != '-')
                        rst += bowlingC[i+1][1] - '0';
                }
            }
            else if(bowlingC[i][1] == '/'){//计算下一个球的分数
                rst += 10;
                if(bowlingC[i+1][0] == 'X')
                    rst += 10;
                else if(bowlingC[i+1][0] == '-')
                    continue;
                else
                    rst += bowlingC[i+1][0] - '0';
            }
            else{//正常加分
                if(bowlingC[i][0] != '-')
                    rst += bowlingC[i][0] - '0';
                if(bowlingC[i][1] != '-')
                    rst += bowlingC[i][1] - '0';
            }
        }
        return rst;
    }

}
