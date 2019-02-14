package velasco.v;

public class Invoice 
{
	protected Integer id;
    protected String dept;
    protected String descript;
    protected Integer qty;
    protected Double price;

    public Invoice(Integer id, String dept, String descript, Integer qty, Double price) 
    {
        this.id = id;
        this.dept = dept;
        this.descript = descript;
        this.qty = qty;
        this.price = price;
    }

    public Integer getId() 
    {
        return id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }
    
    public String getDept() 
    {
        return dept;
    }

    public void setDept(String dept) 
    {
        this.dept = dept;
    }

    public String getDescription() 
    {
        return descript;
    }

    public void setDescription(String descript) 
    {
        this.descript = descript;
    }

	public Integer getQty() 
	{
		return qty;
	}

	public void setQty(Integer qty) 
	{
		this.qty = qty;
	}

	public Double getPrice() 
	{
		return price;
	}

	public void setPrice(Double price) 
	{
		this.price = price;
	}    
}
