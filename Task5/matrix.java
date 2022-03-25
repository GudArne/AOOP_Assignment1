import java.util.Set;

public class matrix
{
    int coloumn;
    int row;
    private double [][] ele = null;

    public matrix(int row, int coloumn)
    {
        this.coloumn = coloumn;
        this.row = row;
        this.ele = new  double[row][coloumn];
    }

    double getMatrix(int row, int column)
    {
        return ele[row][column];
    }

    void setMatrix(double element, int row, int coloumn)
    {
        ele[row][coloumn] = element;
    }

    public matrix addingMatrix(matrix first, matrix second)
    {
        // checking compatibility
        if(first.coloumn != second.coloumn && first.row != second.row)
        throw new IllegalArgumentException("Not compatible matrices");

        matrix sum = new matrix(first.row, first.coloumn);
        for(int i = 0; i<first.row; i++)
        {
            for (int j = 0; j<coloumn; j++)
            {
                sum.setMatrix(first.getMatrix(i, j) + second.getMatrix(i, j), i, j); 
            }
        }
        return sum;
    }

    public matrix multiplyMatrix(matrix first, matrix second)
    {
        
        //checking compatibility
        if(first.coloumn != second.row)
            throw new IllegalArgumentException("Not compatible matrices");

        matrix product = new matrix(first.row, second.coloumn);
        double helpVar = 0;
        for(int i = 0; i<first.row; i++)
        {
            for(int j = 0; j< second.row; j++)
            {
                for(int k = 0; k<second.coloumn; k++)
                {
                    helpVar += first.getMatrix(i, k)*second.getMatrix(k, j);
                }
                product.setMatrix(helpVar, i, j);
                helpVar = 0;
            }
        }
        return product;
    }
    public static void main(String[] args) 
    {

        matrix first = new matrix(2, 2);
        matrix second = new matrix(2, 2);
        for(int i = 0; i <  first.row; i++)
        {
            for(int j = 0; j<first.coloumn; j++)
            {
                first.setMatrix(j+1, i, j);
                second.setMatrix(j+2, i, j);
            }
        }    
        
        first.addingMatrix(first, second);
        first.multiplyMatrix(first, second);
    }
}
