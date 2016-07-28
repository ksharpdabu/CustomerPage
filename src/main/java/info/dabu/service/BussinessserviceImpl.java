package info.dabu.service;

import info.dabu.dao.CustomerDao;
import info.dabu.dao.CustomerDaoMySQLImpl;
import info.dabu.domain.Customer;
import info.dabu.web.bean.Page;

import java.util.List;
import java.util.UUID;

/**
 * Created by AlexY on 2016/7/26.
 */
public class BussinessserviceImpl implements Bussinessservice {

    private CustomerDao  dao = new CustomerDaoMySQLImpl();

    @Override
    public List<Customer> findAll() {



        return dao.findAll();
    }

    @Override
    public void saveCustomer(Customer c) {
//        设置Id，因为数据库中Id字段不是自增的，所以需要使用GUID确保Id是唯一的
        c.setId(UUID.randomUUID().toString());
        dao.save(c);

    }

    @Override
    public void deleteCustomer(String customerId) {

        dao.delete(customerId);

    }

    @Override
    public Customer findOne(String customerId) {

         return dao.findOne(customerId);
    }

    @Override
    public void updateCustomer(Customer c) {

        if ( null == c.getId() || "".equals(c.getId().trim())){
            throw new IllegalArgumentException("更新的客户Id不能为空");
        }


        dao.update(c);
    }

    @Override
    public Page findPageRecords(String num) {

        int pageNum = 1;


        // TODO: 2016/7/28 这里处理有问题，用户输错，不应该直接报错，而应该进行容错处理，提示用户错误
        if ( num != num && !num.trim().equals("")){
            try{
                pageNum = Integer.parseInt(num);
            }catch (NumberFormatException e){
                throw new RuntimeException("页面必须是数字",e);
            }
        }


        int totalRecordsNum = dao.getTotalRecords();

        Page page = new Page(pageNum,totalRecordsNum);

//        把查询的记录放进去,关键的地方
        //其实这个功能，执行了两次sql查询
        List<Customer> cs = dao.findPageRecords(page.getStartIndex(),page.getPageSize());

        page.setReacords(cs);

        return page;



    }
}
