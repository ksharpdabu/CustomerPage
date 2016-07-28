package info.dabu.dao;

import info.dabu.domain.Customer;

import java.util.List;

/**
 * Created by AlexY on 2016/7/26.
 */
public interface CustomerDao {

    @Deprecated
    List<Customer> findAll();

    void save(Customer c);

    void delete(String customerId);

    Customer findOne(String customerId);

    void update(Customer c);




//    分页查询相关的方法

    /**
     * 查找总记录的条数
     * @return
     */
    int getTotalRecords();

//

    /**
     * 查找出指定索引后的客户
     * @param startIndex  开始记录的索引
     * @param pageSize  一次查询的条数
     * @return
     */
    List<Customer> findPageRecords(int startIndex,int pageSize);

}
